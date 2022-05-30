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
            <th scope="col"><fmt:message key="name"/></th>
            <th scope="col"><fmt:message key="experience"/></th>
            <th scope="col"><fmt:message key="car_number"/></th>
        </tr>

        <c:forEach items="${drivers}" var="driver">
            <tr>
                <td>${driver.getId()}</td>
                <td>${driver.getName()}</td>
                <td>${driver.getExperience()}</td>
                <td>${driver.getCarByCarNumber().getNumber()}</td>
            </tr>
        </c:forEach>
    </table>
</main>
<jsp:include page="blocks/footer.jsp"/>
</body>
</html>