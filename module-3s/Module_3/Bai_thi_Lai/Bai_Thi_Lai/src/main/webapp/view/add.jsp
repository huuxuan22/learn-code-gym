<%--
  Created by IntelliJ IDEA.
  User: XUAN
  Date: 11/03/2024
  Time: 2:16 CH
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
  <form action="/test?action=save" method="post">
    <h3 style="text-align: center">ADD NEW</h3>
    <div class="mb-3">
      <label for="exampleInputEmail1" class="form-label">Mã Muon sach</label>
      <input type="text" value="<%=request.getParameter("maMuonSach")%>" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="maMuonSach">
    </div>


      <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Ten sach</label>
          <input type="text" value="<%=request.getParameter("tenSach")%>" class="form-control"  aria-describedby="emailHelp" name="tenSach">
      </div>

      <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">id sach</label>
          <input type="text" value="<%=request.getParameter("idSach")%>" class="form-control"  aria-describedby="emailHelp" name="idSach">
      </div>


      <div class="mb-3">
          <select name="idHocSinh" id="idHocSinh">
              <c:forEach var="list" items="${hocSinhList}">
                  <option class="form-control" name="idHocSinh" id="idhocSinh" value="${list.idHocSinh}">${list.hoTen}</option>
              </c:forEach>
          </select>
<%--          <label for="exampleInputEmail1" class="form-label">Ten hoc sinh</label>--%>
<%--          <input type="text" value="<%=request.getParameter("maMuonSach")%>" class="form-control"  aria-describedby="emailHelp" name="maBenhNhan">--%>
      </div>


      <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Ngay Muon sach</label>
          <input type="text" class="form-control"  aria-describedby="emailHelp" name="ngayMuonSach">
      </div>


      <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Ngay Tra sach</label>
          <input type="text"  class="form-control" id="" aria-describedby="emailHelp" name="ngayTraSach">
      </div>


    <input type="submit" role="button" class="btn btn-primary" value="Muon Sach">
  </form>
</div>
<form action="/test" method="get">
    <input type="hidden" name="action" value="">
    <input type="submit" value="HUY" class="btn btn-primary">
</form>
</body>
</html>
