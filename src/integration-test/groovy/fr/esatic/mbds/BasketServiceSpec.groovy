package fr.esatic.mbds

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class BasketServiceSpec extends Specification {

    BasketService basketService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Basket(...).save(flush: true, failOnError: true)
        //new Basket(...).save(flush: true, failOnError: true)
        //Basket basket = new Basket(...).save(flush: true, failOnError: true)
        //new Basket(...).save(flush: true, failOnError: true)
        //new Basket(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //basket.id
    }

    void "test get"() {
        setupData()

        expect:
        basketService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Basket> basketList = basketService.list(max: 2, offset: 2)

        then:
        basketList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        basketService.count() == 5
    }

    void "test delete"() {
        Long basketId = setupData()

        expect:
        basketService.count() == 5

        when:
        basketService.delete(basketId)
        sessionFactory.currentSession.flush()

        then:
        basketService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Basket basket = new Basket()
        basketService.save(basket)

        then:
        basket.id != null
    }
}
