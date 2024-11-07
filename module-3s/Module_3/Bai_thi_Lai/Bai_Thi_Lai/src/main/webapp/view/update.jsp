<%--
  Created by IntelliJ IDEA.
  User: XUAN
  Date: 11/03/2024
  Time: 2:20 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><style>
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
  <form action="/test?action=update" method="post">
    <h3 style="text-align: center">UPDATE</h3>
    <div class="mb-3">
      <label for="exampleInputEmail1" class="form-label">Mã bệnh nhân</label>
      <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="maBenhNhan">
    </div>
    <input type="submit" value="CẬP NHẬT" role="button" class="btn btn-primary">
  </form>
</div>
</body>
</html>
