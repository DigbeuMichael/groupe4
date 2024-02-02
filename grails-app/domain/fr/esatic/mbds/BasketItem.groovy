package fr.esatic.mbds

class BasketItem {

    String name
    String description
    Float price
    Integer quantity
    Date lastUpdated
    Product product

    static hasMany = [illustrations: Illustration]

    static belongsTo = [basket: Basket]

    static constraints = {
        name nullable: false, blank: false
        description nullable: false, blank: false
        price nullable: false, min: 0F
        quantity nullable: false, min: 0
        product nullable: false
        illustrations nullable: true
        basket nullable: false
    }

    static mapping = {
        description type: 'text'
    }
}
