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
    <div>
        <form action="controller" method="POST">

            <input type="hidden" name="command" value="add_car">

            <label for="car_number"><fmt:message key="car_number"/></label>
            <input id="car_number" name="number" type="number" class="form-control" value="${param.number}">

            <label for="brand"><fmt:message key="brand"/></label>
            <input id="brand" name="brand" type="text" class="form-control" value="${param.brand}">

            <label for="mileage"><fmt:message key="mileage"/></label>
            <input id="mileage" name="mileage" type="number" class="form-control" value="${param.mileage}">

            <label for="state"><fmt:message key="state"/></label>
            <input id="state" name="state" type="number" class="form-control" value="${param.state}">

            <button type="submit" class="btn btn-primary"><fmt:message key="submit"/></button>
        </form>
    </div>
</main>
<jsp:include page="blocks/footer.jsp"/>
</body>
</html>