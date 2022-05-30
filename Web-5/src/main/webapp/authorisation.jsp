<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<fmt:setLocale value="${sessionScope.localisation}" scope="session"/>
<fmt:setBundle basename="localisation.localisedtext"/>

<!DOCTYPE html>
<html lang="${sessionScope.localisation}">
<jsp:include page="blocks/head.jsp"/>
<body>
<main class="page">
    <div class="container">
        <h1 class="display-4"><fmt:message key="authorisation"/></h1>

        <form action="controller" method="POST">
            <input type="hidden" name="command" value="login">
            <div class="form-group">
                <label><fmt:message key="email"/></label>
                <label>
                    <input type="text" class="form-control" name="email" value="${param.email}">
                </label>
            </div>
            <div class="form-group">
                <label><fmt:message key="password"/></label>
                <label>
                    <input type="password" class="form-control" name="password" value="${param.password}">
                </label>
            </div>
            <button type="submit" class="btn btn-primary"><fmt:message key="submit"/></button>
        </form>
    </div>
</main>
<jsp:include page="blocks/footer.jsp"/>
</body>
</html>