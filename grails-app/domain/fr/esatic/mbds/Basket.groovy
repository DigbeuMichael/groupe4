package fr.esatic.mbds

class Basket {

    Float total = 0
    Date lastUpdated

    static hasMany = [products: BasketItem]

    static belongsTo = [user: User]

    static constraints = {
        total min: 0F
        user nullable: false
    }
}
