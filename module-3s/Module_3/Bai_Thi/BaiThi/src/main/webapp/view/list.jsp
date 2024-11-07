<%--
  Created by IntelliJ IDEA.
  User: XUAN
  Date: 07/03/2024
  Time: 10:49 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<% String mess = request.getParameter("mess");
    String messUpdate = request.getParameter("messUpdate");
    if (mess == null){
        mess = "";
    }
    if (messUpdate == null){
        messUpdate = "";
    }
%>
<p><%=mess%></p>
<p><%=messUpdate%></p>
<form action="" method="get">
    <input type="hidden" name="action" value="add">
    <input type="submit" value="Thêm Mới" role="button" class="btn btn-primary">
</form>
</form>
<form action="/test?action=search" method="post" >
    <div class="mb-3">
        <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" style="width: 300px" name="tenBenhNhan" placeholder="Nhập tên tìm kiếm" value="tenBenhNhan">
        <input type="submit" class="btn btn-primary" value="Tìm kiếm" placeholder="">
    </div>
</form>

    <table class="table table-striped">
        <thead>
            <tr>
                <th>STT</th>
                <th>MÃ Bệnh án</th>
                <th>Mã Bệnh nhân</th>
                <th>Tên Bệnh Nhân</th>
                <th>Ngày nhập viện</th>
                <th>Ngày ra viện</th>
                <th>Lý do nhập viện</th>
                <th>Cập nhật</th>
                <th>Xóa</th>
            </tr>
        </thead>

<%--        this.maBenhAn = maBenhAn;--%>
<%--        this.maBenhNhan = maBenhNhan;--%>
<%--        this.tenBenNhan = tenBenNhan;--%>
<%--        this.ngayNhapVien = ngayNhanVien;--%>
<%--        this.ngayRaVien = ngayRaVien;--%>
<%--        this.lyDo = lyDo;--%>
        <tbody>
            <c:forEach var="benhAn" items="${benhAnList}" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${benhAn.maBenhAn}</td>
                    <td>${benhAn.maBenhNhan}</td>
                    <td>${benhAn.tenBenhNhan}</td>
                    <td>${benhAn.ngayNhapVien}</td>
                    <td>${benhAn.ngayRaVien}</td>
                    <td>${benhAn.lyDo}</td>
                    <td>
                        <form action="/test" method="get">
                            <input type="hidden" name="action" value="showFormUpdate">
                            <input type="hidden" name="idUpdate" value="${benhAn.idBenhAn}">
                            <input type="hidden" value="${benhAn.idBenhNhan}" name="idBenhNhan">
                            <input type="submit" role="button" value="UPDATE"   class="btn btn-primary">
                        </form>
                    </td>
                    <td>
                        <button type="button" class="btn btn-primary" onclick="deleteI('${benhAn.idBenhAn}','${benhAn.tenBenhNhan}')"   data-bs-toggle="modal" data-bs-target="#exampleModal">
                            DELETE
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/test?action=delete" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Bạn có muốn xóa bệnh nhân </h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="hidden" name="idBenhAn" id="idBenhAn" value="">
                    <p><span id="tenBenhNhan"></span></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
<script>
    function deleteI(idBenhAn, tenBenhNhan) {
        document.getElementById("idBenhAn").value = idBenhAn;
        document.getElementById("tenBenhNhan").innerText =  tenBenhNhan;
    };
</script>
</html>
