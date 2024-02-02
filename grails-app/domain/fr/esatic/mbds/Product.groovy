package fr.esatic.mbds

class Product {

    String name
    String description
    Float price
    String status = "Available"
    Date dateCreated
    Date lastUpdated

    static hasMany = [illustrations: Illustration]

    static belongsTo = [category: Category]

    static constraints = {
        name nullable: false, blank: false
        description nullable: false, blank: false
        price nullable: false, min: 0F
        illustrations nullable: true
        status inList: ["Available","Unavailable"]
        illustrations nullable: true
        category nullable: false
    }

    static mapping = {
        description type: 'text'
    }
}
