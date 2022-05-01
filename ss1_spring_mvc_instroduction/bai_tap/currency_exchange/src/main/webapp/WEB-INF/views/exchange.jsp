
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Currency Exchange</h2>
<form action="/exchange">
    <div>
        USD:
        <input type="text" name="usd">
    </div>
    <div>
        VND: ${vnd}
    </div>
    <div>
        <input type="submit" value="Exchange">
    </div>
</form>

</body>
</html>
