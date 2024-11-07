<%-- Created by IntelliJ IDEA. User: Home Date: 1/31/2024 Time: 6:15 PM To change this template use File | Settings |
    File Templates. --%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<c:import url="../layout/head.jsp"></c:import>
<c:import url="../layout/navbar.jsp"></c:import>
                <html>
                <body>
                    <h1>Trang danh sách</h1>
                    <a href="/student?action=add">Thêm mới</a>
                    <% String mess=request.getParameter("mess"); if (mess==null){ mess="" ; } %>

                        <p>
                            <%=mess%>
                        </p>
                        <table class="table table-striped">
                            <tr>
                                <th>STT</th>
                                <th>Name</th>
                                <th>gender</th>
                                <th>point</th>
                                <th>Rank</th>
                                <th>class id</th>
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
                                    <%-- <td>
                                        <c:out value="${student.getClassId()}"></c:out>
                                        </td>--%>
                                </tr>
                            </c:forEach>

                        </table>
                </body>

                </html>