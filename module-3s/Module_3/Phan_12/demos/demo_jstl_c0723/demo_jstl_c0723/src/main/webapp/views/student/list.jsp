<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 1/31/2024
  Time: 6:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<html>
<c:import url="../layout/head.jsp"></c:import>
<body>
<c:import url="../layout/navbar.jsp"></c:import>
<%--<script>--%>
<%--    function displayToast(message, color) {--%>
<%--        document.getElementById("toastContent").innerHTML = message;--%>
<%--        document.getElementById("liveToast").style.background = color;--%>
<%--        let myAlert = document.getElementById('liveToast');//select id of toast--%>
<%--        let bsAlert = new bootstrap.Toast(myAlert);//inizialize it--%>
<%--        bsAlert.show();//show it--%>
<%--    }--%>
<%--</script>--%>
<h1>Trang danh sách</h1>
<a href="/student?action=add">Thêm mới</a>
<%
    String mess = request.getParameter("mess");
    if (mess==null){
        mess ="";
    }
%>

<p ><%=mess%></p>
<c:if test="${message!=null}">
    <p>${message}</p>
</c:if>

<form action="/student" method="get">
    <input hidden type="text" style="background-color: rgb(230, 236, 244);" name="action" value="search">
    <input type="text" name="searchName" value="${searchName}">
    <button>Search</button>
</form>
<table class="table table-striped">
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>gender</th>
        <th>point</th>
        <th>Rank</th>
        <th>class id</th>
        <th>Delete</th>
    </tr>

    <c:forEach var="student" items="${studentList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${student.getName()}</td>
            <c:if test="${student.isGender()}">
                <td>Nam</td>
            </c:if>
            <c:if test="${!student.isGender()}">
                <td>Nữ</td>
            </c:if>
            <td>${student.getPoint()}</td>
            <c:choose>
                <c:when test="${student.getPoint()>=8}">
                    <td>Giỏi</td>
                </c:when>
                <c:when test="${student.getPoint()>=7}">
                    <td>Khá</td>
                </c:when>
                <c:when test="${student.getPoint()>=5}">
                    <td>Trung bình</td>
                </c:when>
                <c:otherwise>
                    <td>Yêu sắc yếu</td>
                </c:otherwise>
            </c:choose>
            <td>${student.getClassId()}</td>
            <td>
                <button  onclick="infoDelete(${student.getId()},'${student.getName()}')" type="button" class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Delete
                </button>
            </td>
        </tr>
    </c:forEach>

</table>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/student?action=delete" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input hidden  type="text" id="deleteId" name="deleteId">
                    <span>Bạn có muốn xoá sinh viên : </span><span id="deleteName"></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </form>

    </div>
</div>
<script>
    function infoDelete ( id, name){
       document.getElementById("deleteName").innerText = name;
       document.getElementById("deleteId").value = id;
    }
</script>
<%--<div class="position-fixed top-0 end-5 p-3" style="z-index: 11;margin-left: 500px">--%>
<%--    <div id="liveToast" style="width: 230px; color: white; background:lightgreen ;border-radius:0%/0%;" class="toast"--%>
<%--         role="dialog" aria-live="assertive" aria-atomic="true">--%>
<%--        <div class="toast-body">--%>
<%--            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 48 48" width="30px" height="30px">--%>
<%--                <g id="surface1_4_">--%>
<%--                    <path style="fill:#4CAF50;"--%>
<%--                          d="M44,24c0,11.045-8.955,20-20,20S4,35.045,4,24S12.955,4,24,4S44,12.955,44,24z"/>--%>
<%--                    <path style="fill:#CCFF90;"--%>
<%--                          d="M34.602,14.602L21,28.199l-5.602-5.598l-2.797,2.797L21,33.801l16.398-16.402L34.602,14.602z"/>--%>
<%--                </g>--%>
<%--            </svg>--%>
<%--            <span id="toastContent">Nội dung hiển thị</span>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

</body>
</html>
