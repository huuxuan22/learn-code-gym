<%--
  Created by IntelliJ IDEA.
  User: XUAN
  Date: 20/03/2024
  Time: 8:34 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/create" class="btn btn-primary">Thêm mới đi cha nội</a>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>stt</th>
            <th>id</th>
            <th>Tên</th>
            <th>Mô tả</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="demo" items="${list}" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${demo.id}</td>
                    <td>${demo.name}</td>
                    <td>${demo.mota}</td>
                </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</html>
