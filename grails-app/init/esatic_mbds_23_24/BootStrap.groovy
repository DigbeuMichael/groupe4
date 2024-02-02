package esatic_mbds_23_24

import fr.esatic.mbds.Basket
import fr.esatic.mbds.BasketItem
import fr.esatic.mbds.Category
import fr.esatic.mbds.Illustration
import fr.esatic.mbds.Product
import fr.esatic.mbds.Role
import fr.esatic.mbds.User
import fr.esatic.mbds.UserRole


class BootStrap {

    def init = { servletContext ->
        // On crée 2 rôles
        def clientRole = new Role(authority: "ROLE_CLIENT").save()
        def adminRole = new Role(authority: "ROLE_ADMIN").save()

        // On ajoute un administrateur
        def adminUser = new User(username: "admin",password: "admin").save()
        // On lui attribue le rôle associé
        UserRole.create(adminUser, adminRole, true)

        // On crée 5 catégories de base
        (1..5).each {
            Integer catId ->
                def categoryInstance = new Category(name: "Category $catId", description: "Description de la category $catId")
                // Pour chaque catégorie on ajoute 10 produits
                (1..10).each {
                    Integer pId ->
                        def productInstance = new Product(name: "Product $catId.$pId", description: "Description du produit", price: 100*pId)
                        // Pour chaque produit on ajoute 3 illustrations
                        (1..3).each {
                            Integer iId ->
                                productInstance.addToIllustrations(new Illustration(filename: "grails.svg"))
                        }
                        categoryInstance.addToProducts(productInstance)
                }
                // Pour chaque catégorie on ajoute 5 sous catégories
                (1..5).each {
                    Integer subCatId ->
                        def subCategoryInstance = new Category(name: "Subcategory $catId.$subCatId", description: "Une super description de sous catégorie")
                        // et 10 produits dans chaque sous catégorie
                        (1..10).each {
                            Integer pSubId ->
                                def subCatProductInstance = new Product(name: "Product $catId.$subCatId.$pSubId", description: "Description du produit", price: 100 * pSubId)
                                // et encore 3 illustrations par produit
                                (1..3).each {
                                    Integer iId ->
                                        subCatProductInstance.addToIllustrations(new Illustration(filename: "grails.svg"))
                                }
                                subCategoryInstance.addToProducts(subCatProductInstance)
                        }
                        categoryInstance.addToSubCategories(subCategoryInstance)
                        categoryInstance.save()
                }
        }

        // On crée 4 "clients"
        ["Beatrice", "Sirianne", "Roxane", "Richmond"].each {
            String uName ->
                def userInstance = new User(username: uName, password: "password").save()
                UserRole.create(userInstance, clientRole, true)

                // Pour chaque client on ajoute un nouveau panier
                def basketInstance = new Basket()
                // Et on ajoute 3 articles dans chaque panier
                (1..3).each {
                    Integer bIId ->
                        def p = Product.get(bIId)
                        def basketItemInstance = new BasketItem(name: p.name, description: p.description, price: p.price, quantity: 1, product: p)
                        // Ces articles de panier auront 3 illustrations chacun
                        (1..3).each {
                            Integer iId ->
                                basketItemInstance.addToIllustrations(new Illustration(filename: "grails.svg"))
                        }
                        basketInstance.addToProducts(basketItemInstance)
                }
                userInstance.addToBaskets(basketInstance)
                userInstance.save(flush: true)
        }

        assert Role.count == 2
        assert User.count == 5
        assert Category.count == 30
        assert Product.count == 300
        assert Basket.count == 4
        assert BasketItem.count == 12
        assert Illustration.count == 936

    }

    def destroy = {
    }
}
