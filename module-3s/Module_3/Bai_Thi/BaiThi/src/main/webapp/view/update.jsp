<%--
  Created by IntelliJ IDEA.
  User: XUAN
  Date: 07/03/2024
  Time: 10:49 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <style>
        .form{

        }
        .container{
            width: 500px;
            height: 600px;
            border-radius: 10%;
            border: 1px groove gray;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
    </style>
</head>
<body>
<div class="container">
    <form action="/test?action=update" method="post" class="form">
        <h3 style="text-align: center">UPDATE</h3>
        <input type="text" name="idBenhAn" value="<%=request.getParameter("idUpdate")%>">
        <input type="text" name="idBenhNhan" value="<%=request.getParameter("idBenhNhan")%>">
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Mã bệnh nhân</label>
            <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="maBenhNhan">
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Mã bệnh án</label>
            <input type="text" class="form-control" id="exampleInputPassword1" name="maBenhAn">
        </div>
<%--        <div class="mb-3">--%>
<%--            <label for="exampleInputEmail1" class="form-label">tên bệnh Án</label>--%>
<%--            <input type="text" class="form-control" aria-describedby="emailHelp" name="tenBenhAn">--%>
<%--        </div>--%>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">tên bệnh nhân</label>
            <input type="text" class="form-control" aria-describedby="emailHelp" name="tenBenhNhan">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Ngày nhập viện</label>
            <input type="text" class="form-control"  aria-describedby="emailHelp" name="ngayNhapVien">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Ngày ra viện</label>
            <input type="text" class="form-control"  aria-describedby="emailHelp" name="ngayRaVien">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Lý do </label>
            <input type="text" class="form-control"  aria-describedby="emailHelp" name="lyDo">
        </div>
        <div class="mb-3">
            <input type="submit" class="btn btn-primary" value="CẬP NHẬT"  aria-describedby="emailHelp" name="lyDo">
        </div>
    </form>
</div>
</body>
</html>
