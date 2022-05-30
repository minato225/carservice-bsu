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
    <textarea id="chatTextArea" class="form-control" readonly="readonly" rows="10"></textarea>

    <input type="text" class="form-control" id="chatMessage" placeholder="<fmt:message key="placeholder"/>">
    <input type="button" class="btn btn-primary" value="<fmt:message key="submit"/>" onclick="sendMessage()">

    <script type="text/javascript">

        let url = document.location.host + document.location.pathname + "/chatServerEndpoint";

        if (window.location.protocol === "http:")
            url = "ws://" + url
        else
            url = "wss://" + url

        const websocket = new WebSocket(url)

        websocket.onmessage = function processMessage(message) {
            chatTextArea.value += message.data + '\n';
        };

        function sendMessage() {
            if (chatMessage.value !== '') {
                websocket.send(chatMessage.value);
                chatMessage.value = '';
            }
        }

    </script>
</main>
<jsp:include page="blocks/footer.jsp"/>
</body>
</html>
