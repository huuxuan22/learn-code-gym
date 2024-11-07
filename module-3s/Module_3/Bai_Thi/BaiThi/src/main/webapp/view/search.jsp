<%--
  Created by IntelliJ IDEA.
  User: XUAN
  Date: 07/03/2024
  Time: 10:59 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
<form action="/test?action=search" method="post" style="width: 300px">
    <div class="mb-3">
        <input type="email" class="form-control" id="exampleInputEmail1" name="search" aria-describedby="emailHelp">
        <input type="submit" class="btn btn-primary" role="button">
    </div>
</form>

    <table class="table table-striped">
        <thead>
            <tr>
                <th></th>
            </tr>
        </thead>
        <tbody>
<%--            <c:forEach var="" items="" varStatus="status">--%>
<%--                <tr>--%>
<%--                    <td></td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>
        </tbody>
    </table>
</body>
</html>
