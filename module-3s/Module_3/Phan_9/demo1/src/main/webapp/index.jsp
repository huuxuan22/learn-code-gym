<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="/CalculateServlet" method="post">
    <label for="num1">Enter number 1:</label>
    <input type="text" id="num1" name="num1" required>

    <br>

    <label for="num2">Enter number 2:</label>
    <input type="text" id="num2" name="num2" required>

    <br>

    <input type="submit" value="Calculate">
</form>
</body>
</html>