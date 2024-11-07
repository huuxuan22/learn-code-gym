<%--
  Created by IntelliJ IDEA.
  User: XUAN
  Date: 11/03/2024
  Time: 2:13 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">--%>
<%--  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>--%>
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css" />
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css"/>

</head>
<body>
<% String mess = request.getParameter("mess");
    String messUpdate = request.getParameter("messUpdate");
    String messAdd = request.getParameter("messAdd");
    if (mess == null){
        mess = "";
    }
    if (messUpdate == null){
        messUpdate = "";
    }
    if(messAdd == null){
        messAdd = "";
    }
%>
<p><%=messAdd%></p>
<form action="/test" method="get">
    <input type="hidden" name="action" value="showFormThongKe">
    <input type="submit" value="Thống kê" role="button" class="btn btn-primary">
</form>
</form>


<%--<form action="/test?action=search" method="post" >--%>
<%--    <div class="mb-3">--%>
<%--        <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" style="width: 300px" name="tenBenhNhan" placeholder="Nhập tên tìm kiếm" value="tenBenhNhan">--%>
<%--        <input type="submit" class="btn btn-primary" value="Tìm kiếm" placeholder="">--%>
<%--    </div>--%>
<%--</form>--%>

<table class="table table-striped table-bordered" id="testTable">
    <thead>
    <tr>
        <th>Ma sach</th>
        <th>Ten Sach</th>
        <th>Tac gia</th>
        <th>So Luong</th>
        <th>Mo ta</th>
        <th>Muon sach</th>
        <th>Muon sách</th>
    </tr>
    </thead>
   <tbody>
        <c:forEach var="sach" items="${sachList}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${sach.maSach}</td>
                <td>${sach.tenSach}</td>
                <td>${sach.tenTacGia}</td>
                <td>${sach.moTa}</td>
                <td>${sach.soLuong}</td>
                <td>
                    <form action="/test" method="get">
                        <input type="hidden" name="action" value="showFormMuon">
                        <input type="hidden" name="tenSach" value="${sach.tenSach}">
                        <input type="hidden" name="maMuonSach" value="${sach.maMuonSach}">
                        <input type="hidden" name="idSach" value="${sach.idSach}">
                        <input type="submit" role="button" class="btn btn-primary" value="Muon">
                    </form>
                </td>
            </tr>
        </c:forEach>
   </tbody>
</table>


</body>
<script>
    function deleteI(idBenhAn, tenBenhNhan) {
        document.getElementById("idBenhAn").value = idBenhAn;
        document.getElementById("tenBenhNhan").innerText =  tenBenhNhan;
    };
</script>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function() {
        $('#testTable').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 3
        } );
    } );
</script>
</body>
</html>
