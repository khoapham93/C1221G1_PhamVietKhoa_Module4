<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save</title>
</head>
<body>
<div class="container">
    <h2>Sandwich Condiments save:</h2>
    <c:if test="${error == null || empty error}">
        <c:forEach var="condiment" items="${condiments}">
            ${condiment}
            <br>
        </c:forEach>
    </c:if>
    <c:if test="${error != null}">
        ${error}
    </c:if>
</div>
</body>
</html>
