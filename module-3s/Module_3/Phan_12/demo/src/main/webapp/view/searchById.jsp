<%--
  Created by IntelliJ IDEA.
  User: XUAN
  Date: 23/02/2024
  Time: 7:50 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
<%--<%--%>
<%--  int flag = Integer.parseInt(request.getParameter("flag"));--%>
<%--%>--%>
<form action="/user?action=search" method="post">
  <input type="text" name="name" value="${name}">
  <input type="submit" role="button">
</form>
<table class="table">

  <thead>
  <tr>
    <th scope="col">Mã Khách hàng</th>
    <th scope="col">Tên Khách hàng</th>
    <th scope="col">Email</th>
    <th scope="col">Country</th>
  </tr>
  </thead>
    <tbody>
    <c:forEach var="user" items="${userList}" varStatus="status">
      <tr>
        <th scope="row">${user.getId()}</th>
        <td>${user.getName()}</td>
        <td>${user.getEmail()}</td>
        <td>${user.getCountry()}</td>
      </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
