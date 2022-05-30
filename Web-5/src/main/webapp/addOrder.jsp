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

            <input type="hidden" name="command"
                   value="add_order">

            <label for="brand"><fmt:message key="brand"/></label>
            <input id="brand" name="brand" type="text" class="form-control"
                   value="${param.brand}">

            <label for="mileage"><fmt:message key="mileage"/></label>
            <input id="mileage" name="mileage" type="number" class="form-control"
                   value="${param.mileage}">

            <label for="is_finished"><fmt:message key="is_finished"/></label>
            <input id="is_finished" name="is_finished" type="checkbox" class="form-control" checked="checked"
                   value="${param.is_finished}">

            <label for="departure"><fmt:message key="departure"/></label>
            <input id="departure" name="departure" type="text" class="form-control"
                   value="${param.departure}">

            <label for="destination"><fmt:message key="destination"/></label>
            <input id="destination" name="destination" type="text" class="form-control"
                   value="${param.destination}">

            <label for="start_time"><fmt:message key="start_time"/></label>
            <input id="start_time" name="start_time" type="time" class="form-control"
                   value="${param.start_time}">

            <button type="submit" class="btn btn-primary"><fmt:message key="submit"/></button>
        </form>
    </div>

</main>
<jsp:include page="blocks/footer.jsp"/>
</body>
</html>