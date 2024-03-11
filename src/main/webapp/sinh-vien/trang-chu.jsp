<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 08/03/2024
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>  <%--import thư viện vào jsp --%>
<html>
<head>
    <title>Sinh vien</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body class="container">

<h1>Day la trang chu</h1>
<h1>Ma sinh vien: ${sinhVien.getMaSv()}</h1>
<h1>Ho va ten sinh vien: ${sinhVien.tenSv}</h1>
<h1>Tuoi sinh vien: ${sinhVien.getTuoi()}</h1>
<h1>Dia chi sinh vien: ${sinhVien.getDiaChi()}</h1
<h1>Danh sach sinh vien</h1>


<table class="table">
    <thead>
    <tr>
        <td>STT</td>
        <td>Ma Sinh Vien</td>
        <td>Ho ten</td>
        <td>Dia chi</td>
        <td>Tuoi</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="s" items="${listSinhVien}" varStatus="i">
        <tr>
            <td>${i.index + 1}</td>
            <td>${s.maSv}</td>
            <td>${s.tenSv}</td>
            <td>${s.diaChi}</td>
            <td>${s.tuoi}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
