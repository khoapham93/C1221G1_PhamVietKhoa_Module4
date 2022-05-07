<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>--%>
<html>
<head>
    <title>To Khai Y Te</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

</head>
<body>
<div class="container-fluid px-3 py-3">
    <h5 class="text-center"> TỜ KHAI Y TẾ </h5>
    <h6 class="text-center"> ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH BỆNH
        TRUYỀN NHIỄM </h6>
    <P class=" text-center text-danger"> Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể bị xử lý hình sự</P>
    <form:form action="save" method="post" modelAttribute="healthDeclaration">
    <div>
        <div class="form-group">
            <label>Họ tên(IN HOA)</label> <span class="text-danger font-italic">(*)</span>
            <form:input cssClass="form-control" path="name" value="${healthDeclaration.name}"/>
        </div>
        <div class="form-row">
            <div class="form-group col-md-4">
                <label>Năm sinh </label> <span class="text-danger font-italic">(*)</span>
                <form:select path="birthday" items="${years}" cssClass="form-control" value="${healthDeclaration.birthday}">
                </form:select>
            </div>
            <div class="form-group col-md-4">
                <label>Giới tính </label> <span class="text-danger font-italic">(*)</span>
                <form:select path="gender" items="${genders}" cssClass="form-control" value="${healthDeclaration.gender}">
                </form:select>
            </div>
            <div class="form-group col-md-4">
                <label>Quốc tịch </label> <span class="text-danger font-italic">(*)</span>
                <form:select path="national" items="${nations}" cssClass="form-control" value="${healthDeclaration.national}">
                </form:select>
            </div>
        </div>
        <div class="form-group">
            <label>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác</label> <span class="text-danger font-italic">(*)</span>
            <form:input cssClass="form-control" path="idCard" value="${healthDeclaration.idCard}"/>
        </div>
        <div class="form-group">
            <label>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác</label> <span class="text-danger font-italic">(*)</span>
            <div class="form-row d-flex justify-content-around">
                <form:radiobuttons items="${vehicles}" path="vehicle" value="${healthDeclaration.vehicle}"/>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label>Số hiệu phương tiện </label>
                <form:input path="licensePlate" cssClass="form-control" value="${healthDeclaration.licensePlate}"/>
            </div>
            <div class="form-group col-md-6">
                <label>Số ghế </label>
                <form:input path="numberOfSeat" cssClass="form-control" value="${healthDeclaration.numberOfSeat}"/>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label>Ngày khởi hành </label><span class="text-danger font-italic">(*)</span>
                <form:input type="date" path="dateStart" cssClass="form-control" value="${healthDeclaration.dateStart}"/>
            </div>
            <div class="form-group col-md-6">
                <label>Ngày kết thúc</label><span class="text-danger font-italic">(*)</span>
                <form:input type="date" path="dateEnd" cssClass="form-control" value="${healthDeclaration.dateEnd}"/>
            </div>
        </div>
        <div class="form-group">
            <label>Trong vòng 14 ngày qua, Anh/Chị có đến Tỉnh/Thành phố nào?</label> <span class="text-danger font-italic">(*)</span>
            <form:textarea class="form-control" path="cityArrived" rows="3" value="${healthDeclaration.cityArrived}"></form:textarea>
        </div>
            <input type="submit" class="btn btn-success mb-2" value="Gửi tờ khai">
    </div>
</div>
</form:form>
</div>
</body>
</html>
