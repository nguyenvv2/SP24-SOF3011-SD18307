<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 15/03/2024
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>  <%--import thư viện vào jsp --%>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body class="container">

<form action="/sinh-vien/update" method="post">
    <div class="mb-3">
        <label class="form-label">Ma sinh vien</label>
        <input type="text" class="form-control" name="maSinhVien" value="${sinhVien.maSv}" readonly>
    </div>
    <div class="mb-3">
        <label class="form-label">Ten sinh vien</label>
        <input type="text" class="form-control" name="tenSinhVien" value="${sinhVien.tenSv}">
    </div>
    <div class="mb-3">
        <label class="form-label">Tuoi</label>
        <input type="text" class="form-control" name="tuoi" value="${sinhVien.tuoi}">
    </div>
    <div class="mb-3">
        <label class="form-label">Dia Chi</label>
        <input type="text" class="form-control" name="diaChi" value="${sinhVien.diaChi}">
    </div>
    <div class="mb-3">
        <label for="disabledSelect" class="form-label">Ten lop</label>
        <select id="disabledSelect" class="form-select" name="lop">
            <c:forEach items="${lops}" var="lop">
                <option value="${lop}"
                        <c:if test="${sinhVien.tenLop == lop }"> selected</c:if>
                >${lop}</option>
            </c:forEach>
        </select>
    </div>
    <div class="row">
        <p class="col-4"> Gioi tinh
        </p>
        <div class="form-check col-4">
            <input class="form-check-input" type="radio" value="Nam" name="gioiTinh"
            <c:if test="${sinhVien.gioiTinh == 'Nam'}">
                   checked
            </c:if>
            >
            <label class="form-check-label">
                Nam
            </label>
        </div>
        <div class="form-check col-4">
            <input class="form-check-input" type="radio" value="Nu" name="gioiTinh"
            <c:if test="${sinhVien.gioiTinh == 'Nu'}">
                   checked
            </c:if>
            >
            <label class="form-check-label">
                Nu
            </label>
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Cap nhat</button>
</form>
</body>
</html>
