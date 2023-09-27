<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Medical Infnormation</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <style>
        label {
            font-weight: bold;
        }

        body {
            width: 90%;
            margin: 0 auto;
        }


        .form-title {
            text-align: center;
            font-size: 24px;
            margin-bottom: 20px;
        }


        /* Custom Styles for Buttons */
        .custom-btn {
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
        }

        .custom-btn:hover {
            background-color: #0056b3;
        }
    </style>

</head>
<body>

<div class="text-center">
    <h1 class="form-title"> TỜ KHAI Y TẾ </h1>
    <h4> ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP ANH CHỊ LIÊN LẠC KHI CẦN THIẾT ĐỂ TRÁNH DỊCH BỆNH
        TRUYỀN NHIỄM </h4>
    <p class="text-danger"> Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể bị xử phạt </p>
</div>

<%--@elvariable id="result" type=""--%>
<form:form method="post" modelAttribute="result" action="/">

<div class="mb-3 row">
    <label for="inputName" class="form-label col-sm-3">Ho va ten (ghi chu IN HOA) <span
            class="text-danger">(*)</span></label>
    <form:input path="fullName" class="form-control col-sm-9" id="inputName" required="required"/>
</div>

<div class="mb-3 row">
    <div class="col-sm-4">
        <label for="inputYear" class="form-label"> Năm sinh <span class="text-danger">(*)</span></label>
        <form:select path="yearBirth" class="form-control" id="inputYear">
            <form:option value="1990">1990</form:option>
            <form:option value="1991">1991</form:option>
            <form:option value="1992">1992</form:option>
            <form:option value="1993">1993</form:option>
        </form:select>
    </div>

    <div class="col-sm-4">
        <label for="inputGender" class="form-label"> Giới tính <span class="text-danger">(*)</span></label>
        <form:select path="gender" class="form-control" id="inputGender">
            <form:option value="Nam">Nam</form:option>
            <form:option value="Nu">Nu</form:option>
        </form:select>
    </div>

    <div class="col-sm-4">
        <label for="inputCountry" class="form-label"> Quốc tịch <span class="text-danger">(*)</span></label>
        <form:select path="country" class="form-control" id="inputCountry" aria-label="Default select example">
            <form:option value="Việt Nam">Việt Nam</form:option>
            <form:option value="USA">USA</form:option>
            <form:option value="Korea">Korea</form:option>
            <form:option value="Japan">Japan</form:option>
        </form:select>
    </div>
</div>

<div class="mb-3 row">
    <label for="ii" class="form-label"> Sổ hộ chiếu hoặc CMND hoặc giấy thông hành hợp pháp khác <span
            class="text-danger">(*)</span></label>
    <form:input path="identification" class="form-control col-sm-9" id="ii"/>
</div>


<div class="mb-3 row">
    <label class="form-label col-sm-3">Thông tin di lai <span class="text-danger">(*)</span></label>
    <div class="col-sm-9">
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="vehicle" value="Tau bay">
            <label class="form-check-label">Tàu bay</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="vehicle" value="Tau thuyen">
            <label class="form-check-label">Tàu thuyền</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="vehicle" value="Ô tô">
            <label class="form-check-label">Ô tô</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="vehicle" value="Khac">
            <label class="form-check-label">Khác (ghi rõ)</label>
        </div>
    </div>
</div>

<div class="mb-3 row">
    <div class="col-sm-6">
        <label class="form-label">Số hiệu phương tiện</label>
        <form:input path="numberPlate" class="form-control"/>
    </div>
    <div class="col-sm-6">
        <label class="form-label">Số ghế</label>
        <form:input path="numberSeat" class="form-control"/>
    </div>
</div>

<div class="mb-3 row">
    <div class="col-sm-6">
        <label class="form-label">Ngày khởi hành <span class="text-danger">(*)</span></label>
        <div class="row">
            <div class="col">
                <select name="startDay" class="form-select" aria-label="Default select example">
                    <option value="1990">01</option>
                    <option value="1991">02</option>
                    <option value="1992">03</option>
                    <option value="1993">04</option>
                    <option value="1994">05</option>
                </select>
            </div>
            <div class="col">
                <select name="startMonth" class="form-select" aria-label="Default select example">
                    <option value="1990">01</option>
                    <option value="1991">02</option>
                    <option value="1992">03</option>
                    <option value="1993">04</option>
                    <option value="1994">05</option>
                </select>
            </div>
            <div class="col">
                <select name="startYear" class="form-select" aria-label="Default select example">
                    <option value="1990">1990</option>
                    <option value="1991">1991</option>
                    <option value="1992">1992</option>
                    <option value="1993">1993</option>
                    <option value="1994">1994</option>
                </select>
            </div>
        </div>
    </div>
    <div class="col-sm-6">
        <label class="form-label">Ngay ket thuc <span class="text-danger">(*)</span></label>
        <div class="row">
            <div class="col">
                <select name="endDay" class="form-select" aria-label="Default select example">
                    <option value="1990">01</option>
                    <option value="1991">02</option>
                    <option value="1992">03</option>
                    <option value="1993">04</option>
                    <option value="1994">05</option>
                </select>
            </div>
            <div class="col">
                <select name="endMonth" class="form-select" aria-label="Default select example">
                    <option value="1990">01</option>
                    <option value="1991">02</option>
                    <option value="1992">03</option>
                    <option value="1993">04</option>
                    <option value="1994">05</option>
                </select>
            </div>
            <div class="col">
                <select name="endYear" class="form-select" aria-label="Default select example">
                    <option value="1990">1990</option>
                    <option value="1991">1991</option>
                    <option value="1992">1992</option>
                    <option value="1993">1993</option>
                    <option value="1994">1994</option>
                </select>
            </div>
        </div>
    </div>
</div>

</div>


<div class="mb-3 row">
    <label class="form-label" for="14"> Trong vòng 14 ngày, Anh/Chị có đến thành phố nào? <span
            class="text-danger">(*)</span> </label>
    <textarea class="form-control col-sm-9" name="infoWithin14days" rows="3" id="14"></textarea>
</div>

<div class="mb-3 row">
    <div class="row">
        <label class="form-label"><strong>Địa chỉ liên lạc</strong></label>
    </div>
    <div class="row">
        <div class="col-sm-4">
            <label class="form-label">Tỉnh/thành <span class="text-danger">(*)</span></label>
            <select name="city" class="form-select" aria-label="Default select example">
                <option>-Chọn-</option>
                <option value="Đà Nẵng">Đà Nẵng</option>
                <option value="HCM">HCM</option>
                <option value="Hà Nội">Hà Nội</option>
            </select>
        </div>
        <div class="col-sm-4">
            <label class="form-label">Quận/huyện <span class="text-danger">(*)</span></label>
            <select name="district" class="form-select" aria-label="Default select example">
                <option selected>Chọn</option>
                <option value="Cẩm Lệ">Cẩm Lệ</option>
                <option value="Thanh Khê">Thanh Khê</option>
                <option value="Sơn Trà">Sơn Trà</option>
            </select>
        </div>
        <div class="col-sm-4">
            <label class="form-label">Phường/xã <span class="text-danger">(*)</span></label>
            <select name="ward" class="form-select" aria-label="Default select example">
                <option value="Khuê Trung">Khuê Trung</option>
                <option value="Hòa Xuân">Hòa Xuân</option>
            </select>
        </div>
    </div>

    <div class="mb-3 row">
        <label class="form-label col-sm-3">Địa chỉ nơi ở <span class="text-danger">(*)</span></label>
        <form:input path="address" class="form-control col-sm-9"/>
    </div>

    <div class="mb-3 row">
        <div class="col">
            <label class="form-label">Điện thoại <span class="text-danger">(*)</span></label>
            <form:input path="phone" class="form-control"/>
        </div>
        <div class="col">
            <label class="form-label">Email</label>
            <form:input path="email" class="form-control"/>
        </div>
    </div>

    <div class="mb-3 row">
        <label class="form-label col-sm-12" style="font-weight: bolder; font-size:larger">Trong vong 14 ngay qua,
            anh/chi co thay xuat hien dau hieu nao sau day: <span class="text-danger">(*)</span></label>
        <div class="row">
            <div class="col-sm-6">
                <table class="table">
                    <thead class="table-light">
                    <th>Triệu chứng</th>
                    <th>Có</th>
                    <th>Không</th>
                    </thead>
                    <tbody>
                    <tr>
                        <th>Sốt <span class="text-danger">(*)</span></th>
                        <td><input class="form-check-input" type="radio" name="sot" value="y"></td>
                        <td><input class="form-check-input" type="radio" name="sot" value="n"></td>
                    </tr>
                    <tr>
                        <th>Ho <span class="text-danger">(*)</span></th>
                        <td><input class="form-check-input" type="radio" name="ho" value="y"></td>
                        <td><input class="form-check-input" type="radio" name="ho" value="n"></td>
                    </tr>
                    <tr>
                        <th>Khó thở <span class="text-danger">(*)</span></th>
                        <td><input class="form-check-input" type="radio" name="khotho" value="y"></td>
                        <td><input class="form-check-input" type="radio" name="khotho" value="n"></td>
                    </tr>
                    <tr>
                        <th>Đau họng <span class="text-danger">(*)</span></th>
                        <td><input class="form-check-input" type="radio" name="dauhong" value="y"></td>
                        <td><input class="form-check-input" type="radio" name="dauhong" value="n"></td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="col-sm-6">
                <table class="table">
                    <thead class="table-light">
                    <tr>
                        <th> Triệu chứng</th>
                        <th>Có</th>
                        <th>Không</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th>Nôn/buồn nôn <span class="text-danger">(*)</span></th>
                        <td><input type="radio" name="non" value="y"></td>
                        <td><input type="radio" name="non" value="n"></td>
                    </tr>
                    <tr>
                        <th>Tiêu chảy <span class="text-danger">(*)</span></th>
                        <td><input type="radio" name="tieuchay" value="y"></td>
                        <td><input type="radio" name="tieuchay" value="n"></td>
                    </tr>
                    <tr>
                        <th>Xuất huyết ngoài da <span class="text-danger">(*)</span></th>
                        <td><input type="radio" name="xuathuyet" value="y"></td>
                        <td><input type="radio" name="xuathuyet" value="n"></td>
                    </tr>
                    <tr>
                        <th>Nổi ban ngoài da <span class="text-danger">(*)</span></th>
                        <td><input type="radio" name="noiban" value="y"></td>
                        <td><input type="radio" name="noiban" value="n"></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <div class="mb-3 row">
        <label class="form-label col-sm-12" style="font-weight: bolder; font-size:larger">Lich su phoi nhiem. Trong vong
            14 ngay qua, anh/chi co <span class="text-danger">(*)</span></label>
        <div class="col-sm-12">
            <table class="table ">
                <thead class="table-light">
                <tr>
                    <th></th>
                    <th>Co</th>
                    <th>Khong</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th>Den trang trai chan nuoi/ cho buon ban dong vat song/ co so giet mo dong vat/ tiep xuc dong vat
                        <span class="text-danger">(*)</span></th>
                    <td><input type="radio" name="dentrangtrai" value="y"></td>
                    <td><input type="radio" name="dentrangtrai" value="n"></td>
                </tr>
                <tr>
                    <th>Tiep xuc gan (<2m) voi nguoi mac benh vien duong ho hap do nCoV <span
                            class="text-danger">(*)</span>
                    </th>
                    <td><input type="radio" name="tiepxucgan" value="y"></td>
                    <td><input type="radio" name="tiepxucgan" value="n"></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Disclaimer -->
    <div class="mb-3 row text-danger">
        Du lieu ban cung cap hoan toan bao mat va chi phuc vu cho viec phong chong dich, thuoc quan ly cua ban chi dao
        quoc gia va phong chong dich Covid-19. Khi ban nhan nut "Gui" la ban da hieu va dong y
    </div>

    <!-- Submit Button -->
    <div class="mb-3 row">
        <label class="col-sm-6"></label>
        <div class="col-sm-6">
            <button type="submit" class="btn btn-success custom-btn"> Gửi tờ khai</button>
        </div>
    </div>

    </form:form>

</body>
</html>