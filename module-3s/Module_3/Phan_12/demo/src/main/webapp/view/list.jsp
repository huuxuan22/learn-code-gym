<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: XUAN
  Date: 21/02/2024
  Time: 2:27 CH
  To change this template use File | Settings | File Templates.

--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <style>
        tr {
            text-align: center;
        }
    </style>
</head>
<body>
<form action="/user?action=search" method="post">
    <input type="text" name="name">
    <input type="submit" role="button" value="Tìm kiếm">
</form>
<table class="table table-striped-columns">
    <tr>
        <th>Mã khách hàng</th>
        <th>Tên Khách hàng</th>
        <th>Email</th>
        <th>Country</th>
        <th>action</th>
    </tr>
    <%
        String mess = request.getParameter("mess");
        if (mess==null){
            mess ="";
        }
    %>
    <p>${mess}</p>
    <c:forEach var="users" items="${userList}"  varStatus="status">
        <tr>
           <td>${users.getId()}</td>
           <td>${users.getName()}</td>
           <td>${users.getEmail()}</td>
           <td>${users.getCountry()}</td>
           <td>

               <form action="view/update.jsp" method="post">
                   <input type="hidden" name="id" id="idUpdate" value="${users.id}">
                   <input type="submit" role="button" value="UPDATE"   class="btn btn-primary">
               </form>
<%--               <a href="view/update.jsp" type="button" class="btn btn-primary" onclick="updateI('${users.id}')">UPDATE</a>--%>
           </td>
           <td>
                <button type="button" class="btn btn-primary" onclick="deleteI('${users.id}', '${users.name}')"  data-bs-toggle="modal" data-bs-target="#exampleModal">
                    DELETE
                </button>
           </td>

       </tr>
    </c:forEach>
</table>
<a class="btn btn-primary" role="button" href="/user?action=add">Them moi user</a>

<!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <form action="/user?action=delete" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Delete one user !</h1>
                </div>
                <div class="modal-body">
                    <input name="idDelete" id="idDelete" type="hidden">
                    <p><span id="nameDelete"></span></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Rời khỏi</button>
                    <button type="submit" class="btn btn-secondary" data-bs-dismiss="modal">Lưu thay đổi</button>
                </div>
            </div>
            </form>
        </div>
    </div>
</body>
<script>
    function deleteI(id, name) {
        document.getElementById("idDelete").value = id;
        document.getElementById("nameDelete").innerText ="Bạn có muốn xóa khách hàng " + name;


    };

    // function getNameDelete() {
    //     let name = document.getElementById("nameDelete").innerText;
    //
    //     return name;
    // }



</script>
</html>
