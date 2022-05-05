<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ceate Song</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>
<body>
<div class="container col-5 mx-auto">
    <h2>Create Song</h2>
    <p>
        <a href="/">
            Back to list
        </a>
    </p>
   <form:form cssClass="form" action="save" method="post" modelAttribute="songForm" enctype="multipart/form-data">
        <div class="form-group">
            name:
            <form:input cssClass="form-control" path="name"></form:input>
        </div>
       <div class="form-group">
           Artist:
           <form:input cssClass="form-control" path="artist"></form:input>
       </div >
       <div class="form-group">
           Genre:
           <form:input cssClass="form-control" path="genre"></form:input>
       </div >
       <div class="form-group">
           File:
           <form:input type="file"  path="filePath" accept="audio/mp3, audio/wav, audio/ogg"></form:input>
       </div>
       <input  type="submit" value="Save"/>
   </form:form>
    <div>
        <p class="text-success">${message}</p>
    </div>
</div>
</body>
</html>
