<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<fmt:setLocale value="${sessionScope.localisation}" scope="session"/>
<fmt:setBundle basename="localisation.localisedtext"/>

<!DOCTYPE html>
<html lang="${sessionScope.localisation}">
<jsp:include page="blocks/head.jsp"/>

<body class="page">
<jsp:include page="blocks/header.jsp"/>
<main>
    <table class="table">
        <tr>
            <th scope="col"><fmt:message key="id"/></th>
            <th scope="col"><fmt:message key="brand"/></th>
            <th scope="col"><fmt:message key="mileage"/></th>
            <th scope="col"><fmt:message key="is_finished"/></th>
            <th scope="col"><fmt:message key="departure"/></th>
            <th scope="col"><fmt:message key="destination"/></th>
            <th scope="col"><fmt:message key="start_time"/></th>
        </tr>

        <c:forEach items="${orders}" var="order">
            <tr>
                <td>${order.getId()}</td>
                <td>${order.getBrand()}</td>
                <td>${order.getMileage()}</td>
                <td>${order.getIsFinished()}</td>
                <td>${order.getDeparture()}</td>
                <td>${order.getDestination()}</td>
                <td>${order.getStartTime()}</td>
            </tr>
        </c:forEach>
    </table>
</main>
<jsp:include page="blocks/footer.jsp"/>
</body>
</html>