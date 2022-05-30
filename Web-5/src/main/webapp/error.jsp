<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<fmt:setLocale value="${sessionScope.localisation}" scope="session"/>
<fmt:setBundle basename="localisation.localisedtext"/>

<!DOCTYPE html>
<html lang="${sessionScope.localisation}">
<jsp:include page="blocks/head.jsp"/>

<body class="page">
<main>
    <div class="container-fluid" style="height: 100%; position: absolute; margin: 0;">
        <div class="row align-items-center" style="height: 100%">
            <div class="col">
                <h3 class="display-4"><fmt:message key="error500"/></h3>
                <hr class="my-4">

                <form class="form-inline" action="controller">
                    <input type="hidden" name="command" value="default">
                    <label class="mr-sm-2"><fmt:message key="error500"/></label>
                    <button type="submit" class="btn btn-outline-primary my-2 my-sm-0">&#8962;</button>
                </form>
            </div>
        </div>
    </div>
</main>
<jsp:include page="blocks/footer.jsp"/>
</body>
</html>
