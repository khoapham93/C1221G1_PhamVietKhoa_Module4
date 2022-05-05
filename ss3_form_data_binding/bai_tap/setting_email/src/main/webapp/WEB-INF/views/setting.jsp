<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Settings</title>
</head>
<body>
<h2>Settings</h2>
<span style="color: green"> ${message}</span>
<form:form action="setting" method="post" modelAttribute="setting">
    <div>
        languages:
        <form:select path="language" itemValue="${setting.language}">
            <form:option value="English">English</form:option>
            <form:option value="Vietnamese">Vietnamese</form:option>
            <form:option value="Chinese">Chinese</form:option>
            <form:option value="Japanese">Japanese</form:option>
        </form:select>
    </div>
    <div>
        page size: show
        <form:select path="pageSize" itemValue="${setting.pageSize}">
            <form:option value="5"/>5
            <form:option value="10"/>10
            <form:option value="15"/>15
            <form:option value="20"/>20
            <form:option value="50"/>50
            <form:option value="100"/>100
        </form:select>
    </div>
    <div>
        Spams filter:
        <form:checkbox path="spamFilter" itemValue="${setting.spamFilter}"/>
    </div>
    <div>
        Signature:
        <form:textarea path="signature" itemValue="${setting.signature}"/>
    </div>
    <div>
        <input type="submit" value="Update"/>
        <input type="reset" value="Cancel"/>
    </div>
</form:form>
</body>
</html>
