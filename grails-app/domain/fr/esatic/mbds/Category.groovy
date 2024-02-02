package fr.esatic.mbds

class Category {

    String name
    String description
    Category parent

    static hasMany = [products: Product, subCategories: Category]

    static constraints = {
        name nullable: false, blank: false
        description nullable: false, blank: false
        parent nullable: true
        products nullable: true
        subCategories nullable: true
    }

    static mapping = {
        description type: 'text'
    }
}
