<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <a href="meals" class="navbar-brand"><spring:message code="app.title"/></a>

        <div class="collapse navbar-collapse">
            <form:form class="navbar-form navbar-right" action="logout" method="post">
                <sec:authorize access="isAuthenticated()">
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <a class="btn btn-info" href="users"><spring:message code="user.title"/></a>
                    </sec:authorize>
                    <a class="btn btn-info" href="profile">${userTo.name} <spring:message code="app.profile"/></a>
                    <button class="btn btn-primary" type="submit">
                        <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
                    </button>
                </sec:authorize>
                <%--<a href="?languageVar=en">EN</a>--%>
                <%--<a href="?languageVar=ru">RU</a>--%>
                <div class="btn-group">
                    <a class="btn dropdown-toggle" data-toggle="dropdown" href="?languageVar=ru">
                        <span class="caret"></span>
                        ${pageContext.response.locale}
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="?languageVar=en">en</a></li>
                        <li><a href="?languageVar=ru">ru</a></li>
                    </ul>
                </div>
            </form:form>
        </div>
    </div>
</div>