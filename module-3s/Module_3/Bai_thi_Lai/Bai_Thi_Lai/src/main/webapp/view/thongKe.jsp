<%--
  Created by IntelliJ IDEA.
  User: XUAN
  Date: 11/03/2024
  Time: 7:30 CH
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
<h1 style="text-align: center">THỐNG KÊ MƯỢN SÁCH</h1>
<table class="table table-striped table-bordered" id="thongKeTable">
    <thead>
    <tr>
        <th>Ma Muon sach</th>
        <th>Ten Sach</th>
        <th>Tac gia</th>
        <th>Ten hoc sinh</th>
        <th>lop</th>
        <th>ngay muon</th>
        <th>ngay tra</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="thongKe" items="${thongKe}" varStatus="status">
        <tr>
            <td>${thongKe.maMuonSach}</td>
            <td>${thongKe.tenSach}</td>
            <td>${thongKe.tacGia}</td>
            <td>${thongKe.tenHocSinh}</td>
            <td>${thongKe.lop}</td>
            <td>${thongKe.ngayMuon}</td>
            <td>${thongKe.ngayTra}</td>
            <td>
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Trả Sách
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/test?action=Sach">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Bạn có muốn trả sách hay không</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    ...
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Không</button>
                    <button type="button" class="btn btn-primary">Trả sách</button>
                </div>
            </div>
        </form>
    </div>
</div>
</div>
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
        $('#thongKeTable').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 3
        } );
    } );
</script>
</body>
</html>
