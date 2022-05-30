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
    <div class='console-container'>
        <span style="color: #04AA6D"> <fmt:message key="title"/></span>
    </div>
    <p>
        <fmt:message key="main_text1"/><br>
        <fmt:message key="main_text2"/><br>
        <fmt:message key="main_text3"/><br>
    </p>
</main>
<jsp:include page="blocks/footer.jsp"/>
</body>
</html>