<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h2>
    Calculator
</h2>
<form action="/cal" method="post">
    <div>
        <input type="number" name="number1" value="${number1}" step="any">
        <input type="number" name="number2" value="${number2}" step="any">
    </div>
    <div>
        <input type="submit" name="operator" value="Addition(+)">
        <input type="submit" name="operator" value="Subtraction(-)">
        <input type="submit" name="operator" value="Multiplication(x)">
        <input type="submit" name="operator" value="Division(/)">
    </div>
    <div>
        <c:if test="${empty error || error == null}">
            <p style="color: green">
                Result ${operator}: ${result}
            </p>
        </c:if>
        <c:if test="${error != null}">
            <p STYLE="color: red">
                    ${error}
            </p>
        </c:if>
    </div>

</form>
</body>
</html>
