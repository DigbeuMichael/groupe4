<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'product.label', default: 'Product')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-product" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="list-product" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <table>
                <thead>
                <tr>
                    <th class="sortable"><a href="/product/index?sort=name&amp;max=10&amp;order=asc">Name</a></th>

                    <th class="sortable"><a href="/product/index?sort=description&amp;max=10&amp;order=asc">Description</a></th>

                    <th class="sortable"><a href="/product/index?sort=price&amp;max=10&amp;order=asc">Price</a></th>

                    <th class="sortable"><a href="/product/index?sort=illustrations&amp;max=10&amp;order=asc">Illustrations</a></th>

                    <th class="sortable"><a href="/product/index?sort=status&amp;max=10&amp;order=asc">Status</a></th>

                    <th class="sortable"><a href="/product/index?sort=category&amp;max=10&amp;order=asc">Category</a></th>
                </tr>
                </thead>
                <tbody>

                <g:each in="${productList}" var="product">
                    <tr>
                        <td>
                            <g:link controller="product" action="show" id="${product.id}">${product.name}</g:link>
                        </td>
                        <td>${product.description}</td>
                        <td>${product.price}</td>
                        <td>
                            <g:each in="${product.illustrations}" var="illustration">
                                <img src="${grailsApplication.config.illustrations.url+illustration.filename}" />
                            </g:each>
                         </td>
                        <td>${product.status}</td>
                        <td>
                            <g:link controller="category" action="show" id="${product.category.id}">${product.category.name}</g:link>
                        </td>
                    </tr>
                </g:each>
                </tbody>
            </table>

            <div class="pagination">
                <g:paginate total="${productCount ?: 0}" />
            </div>
        </div>
    </body>
</html>