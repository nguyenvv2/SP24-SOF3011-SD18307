<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 25/03/2024
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>  <%--import thư viện vào jsp --%>
<html>
<head>
    <title>Danh muc</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<h1>Danh sach san pham</h1>
<table class="table">
    <thead>
    <tr>
        <td>ID</td>
        <td>Ma San Pham</td>
        <td>Ten San Pham</td>
        <td>Ten Danh Muc</td>
        <td>Trang Thai</td>
        <td>Ngay Tao</td>
        <td>Ngay Sua</td>
        <td>Chuc nang</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="s" items="${list}" varStatus="i">
        <tr>
            <td>${s.id}</td>
            <td>${s.maSanPham}</td>
            <td>${s.tenSanPham}</td>
            <td>${s.danhMuc.tenDanhMuc}</td>
            <td>${s.trangThai}</td>
            <td>${s.ngayTao}</td>
            <td>${s.ngaySua}</td>
            <td>
                <a href="#" class="btn btn-primary">Chi tiet</a>
                <a href="#" class="btn btn-primary">Xoa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
