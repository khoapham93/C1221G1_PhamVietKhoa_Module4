<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Translate</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

</head>
<body>

<form class="form container" action="/translate">
    <div class="row">
        <div class="mb-3 col-5">
            <label for="english">English</label>
            <textarea name="english" class="form-control" id="english" placeholder="Enter text to translate"><c:if
                    test="${english != null or !empty english}">${english}</c:if></textarea>
        </div>
        <div class="mb-3 col-5">
            <label for="validationTextarea">Vietnamese</label>
            <textarea name="vietnamese" class="form-control" id="validationTextarea" placeholder="bản dịch"><c:if
                    test="${vietnamese != null or !empty vietnamese}">${vietnamese}</c:if></textarea>
        </div>
    </div>

    <input type="submit">
</form>


</body>
</html>
