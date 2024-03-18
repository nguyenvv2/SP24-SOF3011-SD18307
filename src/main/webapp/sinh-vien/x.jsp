<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 18/03/2024
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<form action="/sinh-vien/add" method="post">
    <div class="mb-3">
        <label class="form-label">Ma nhan vien</label>
        <input type="text" class="form-control">
    </div>
    <div class="mb-3">
        <label class="form-label">Ten nhan vien</label>
        <input type="text" class="form-control">
    </div>
    <div class="mb-3">
        <label class="form-label">Tuoi</label>
        <input type="text" class="form-control">
    </div>
    <div class="mb-3">
        <label class="form-label">Dia Chi</label>
        <input type="text" class="form-control">
    </div>
    <div class="mb-3">
        <label for="disabledSelect" class="form-label">Phong ban</label>
        <select id="disabledSelect" class="form-select">
            <c:forEach items="${lops}" var="lop">
                <option value="${lop}">${lop}</option>
            </c:forEach>
        </select>
    </div>
    <div class="row">
        <p class="col-4"> Gioi tinh
        </p>
        <div class="form-check col-4">
            <input class="form-check-input" type="radio" value="Nam">
            <label class="form-check-label">
                Nam
            </label>
        </div>
        <div class="form-check col-4">
            <input class="form-check-input" type="radio" value="Nu">
            <label class="form-check-label">
                Nu
            </label>
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
<h1>Chuc nang tim kiem</h1>
<div class="mb-3">
    <label class="form-label">Ten Nhan Vien</label>
    <input type="text" class="form-control">

</div>
<button type="submit" class="btn btn-primary">Submit</button>
<h1>Danh sach nhan vien</h1>
<table class="table">
    <thead>
    <tr>
        <td>STT</td>
        <td>Ma Nhan Vien</td>
        <td>Ho ten</td>
        <td>Dia chi</td>
        <td>Tuoi</td>
        <td>Gioi tinh</td>
        <td>Phong ban</td>
        <td>Chuc nang</td>
    </tr>
    </thead>
    <tbody>

    </tbody>
</table>
</body>
</html>
