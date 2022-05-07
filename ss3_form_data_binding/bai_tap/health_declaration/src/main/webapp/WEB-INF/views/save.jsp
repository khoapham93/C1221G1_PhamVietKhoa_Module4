<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Khai báo thành công</title>
</head>
<body>
<h3>Thông tin khai báo y tế</h3>
<div>
    Tên: ${healthDeclaration.name}
</div>
<div>
    Năm sinh: ${healthDeclaration.birthday}
</div>
<div>
    Giới tính: ${healthDeclaration.gender}
</div>
<div>
    Quốc tịch: ${healthDeclaration.national}
</div>
<div>
    CMND: ${healthDeclaration.idCard}
</div>
<div>
    Phương tiện: ${healthDeclaration.vehicle}
</div>
<div>
    Số hiệu: ${healthDeclaration.licensePlate}
</div>
<div>
    Số ghế: ${healthDeclaration.numberOfSeat}
</div>
<div>
    Ngày khởi hành: ${healthDeclaration.dateStart}
</div>
<div>
    Ngày kết thúc: ${healthDeclaration.dateEnd}
</div>
<div>
    Tỉnh/Thành phố đã đến trong vòng 14 ngày qua: ${healthDeclaration.cityArrived}
</div>
<p>
    <a href="/">
        Sửa đổi thông tin
    </a>
</p>

</body>
</html>
