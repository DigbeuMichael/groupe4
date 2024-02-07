package fr.esatic.mbds

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

@Secured(["ROLE_ADMIN"])
class BasketController {

    BasketService basketService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond basketService.list(params), model:[basketCount: basketService.count()]
    }

    def show(Long id) {
        respond basketService.get(id)
    }

    def create() {
        respond new Basket(params)
    }

    def save(Basket basket) {
        if (basket == null) {
            notFound()
            return
        }

        try {
            basketService.save(basket)
        } catch (ValidationException e) {
            respond basket.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'basket.label', default: 'Basket'), basket.id])
                redirect basket
            }
            '*' { respond basket, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond basketService.get(id)
    }

    def update(Basket basket) {
        if (basket == null) {
            notFound()
            return
        }

        try {
            basketService.save(basket)
        } catch (ValidationException e) {
            respond basket.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'basket.label', default: 'Basket'), basket.id])
                redirect basket
            }
            '*'{ respond basket, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        basketService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'basket.label', default: 'Basket'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'basket.label', default: 'Basket'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
