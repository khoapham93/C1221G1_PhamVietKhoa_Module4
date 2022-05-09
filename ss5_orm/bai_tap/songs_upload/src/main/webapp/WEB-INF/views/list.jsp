<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Song List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h2>Songs list</h2>
    <p>
        <a href="/create">
            Add new product
        </a>
    </p>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">id</th>
            <th scope="col">Song</th>
            <th scope="col">Artist</th>
            <th scope="col">Genre</th>
            <th scope="col">File</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${songs}" var="song" varStatus="loop">
            <tr>
                <th scope="row">${loop.count}</th>
                <td>${song.id}</td>
                <td>${song.name}</td>
                <td>${song.artist}</td>
                <td>${song.genre}</td>
                <td>
                    <audio controls>
                        <source src="/songs/${song.filePath}" type="audio/mpeg">
                        Your browser does not support the audio element.
                    </audio>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
