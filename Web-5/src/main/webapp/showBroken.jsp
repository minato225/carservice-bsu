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
            <th scope="col"><fmt:message key="car_number"/></th>
            <th scope="col"><fmt:message key="brand"/></th>
            <th scope="col"><fmt:message key="mileage"/></th>
            <th scope="col"><fmt:message key="state"/></th>
        </tr>

        <c:forEach items="${cars}" var="car">
            <tr>
                <td>${car.getNumber()}</td>
                <td>${car.getBrand()}</td>
                <td>${car.getMileage()}</td>
                <td>${car.getState()}</td>
            </tr>
        </c:forEach>
    </table>
</main>
<jsp:include page="blocks/footer.jsp"/>
</body>
</html>