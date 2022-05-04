
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h2>Sandwich Condiments</h2>
    <form action="/save">

        <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck1" name="condiments" value="lettuce">
            <label class="form-check-label" for="exampleCheck1">Lettuce</label>
        </div>
        <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck2" name="condiments" value="tomato">
            <label class="form-check-label" for="exampleCheck2">Tomato</label>
        </div>

        <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck3" name="condiments" value="mustard">
            <label class="form-check-label" for="exampleCheck3">Mustard</label>
        </div>
        <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck4" name="condiments" value="sprouts">
            <label class="form-check-label" for="exampleCheck4">Sprouts</label>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</div>

</body>
</html>
