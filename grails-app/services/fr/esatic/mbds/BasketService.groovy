package fr.esatic.mbds

import grails.gorm.services.Service

@Service(Basket)
interface BasketService {

    Basket get(Serializable id)

    List<Basket> list(Map args)

    Long count()

    void delete(Serializable id)

    Basket save(Basket basket)

}