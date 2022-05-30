<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.doskoch.fpm.web5.model.auth.UserType" %>

<fmt:setLocale value="${sessionScope.localisation}" scope="session"/>
<fmt:setBundle basename="localisation.localisedtext"/>

<header>
    <div class="topnav">
        <a class="active" href="./controller?command=home"><fmt:message key="home"/></a>
        <c:choose>
            <c:when test="${sessionScope.user.type == UserType.ADMIN}">
                <a href="./controller?command=get_cardrivers"><fmt:message key="drivers"/></a>
                <a href="./controller?command=get_cars"><fmt:message key="cars"/></a>
                <a href="./controller?command=get_orders"><fmt:message key="orders"/></a>
                <a href="./controller?command=get_broken"><fmt:message key="broken"/></a>
                <a href="./controller?command=start_add_car"><fmt:message key="new_car"/></a>
                <a href="./controller?command=start_add_order"><fmt:message key="new_order"/></a>
                <a href="./controller?command=to_chat"><fmt:message key="to_chat"/></a>
            </c:when>
            <c:when test="${sessionScope.user.type== UserType.CARDRIVER}">
                <a href="./controller?command=get_cardrivers"><fmt:message key="drivers"/></a>
                <a href="./controller?command=get_broken"><fmt:message key="broken"/></a>
                <a href="./controller?command=to_chat"><fmt:message key="to_chat"/></a>
            </c:when>
            <c:otherwise>
                <a href="./controller?command=start_add_order"><fmt:message key="new_order"/></a>
            </c:otherwise>
        </c:choose>
    </div>
</header>