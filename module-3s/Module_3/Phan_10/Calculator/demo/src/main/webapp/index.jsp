<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="calculator" method="post">
    <input type="text" name="number1">
    <input type="text" name="number2">
    <input type="submit" value="click">
    <select name="choose" id="">
        <option value="add">Cộng</option>
        <option value="minus">Trừ </option>
        <option value="mutyl">Nhân</option>
        <option value="div">Chia</option>
    </select>
</form>
</body>
</html>