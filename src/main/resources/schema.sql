CREATE TABLE DanhMuc (
                         maDanhMuc INT PRIMARY KEY identity(1,1),
                         tenDanhMuc NVARCHAR(100),
                         moTa NVARCHAR(100)
);

-- Tạo bảng SanPham
CREATE TABLE SanPham (
                         maSanPham INT PRIMARY KEY identity(1,1),
                         tenSanPham VARCHAR(255),
                         moTa NVARCHAR(100),
                         thuongHieu VARCHAR(100),
                         maDanhMuc INT,
                         soLuong INT,
                         gia DECIMAL(10,1),
                         FOREIGN KEY (maDanhMuc) REFERENCES DanhMuc(maDanhMuc)
);

-- Tạo bảng BienTheSanPham
CREATE TABLE BienTheSanPham (
                                STT INT identity(1,1),
                                maSKU VARCHAR(50) PRIMARY KEY ,
                                maSanPham int,
                                gia DECIMAL(10,1),
                                soLuong INT,
                                FOREIGN KEY (maSanPham) REFERENCES SanPham(maSanPham)
);


-- Tạo bảng ThuocTinhBienThe
CREATE TABLE ThuocTinhBienThe (
                                  maThuocTinh INT PRIMARY KEY identity(1,1),
                                  maSKU  VARCHAR(50),
                                  tenThuocTinh VARCHAR(100),
                                  TrangThai int ,
                                  FOREIGN KEY (maSKU) REFERENCES BienTheSanPham(maSKU)

);

CREATE TABLE Users (
                       id INT PRIMARY KEY IDENTITY(1,1),
                       username VARCHAR(100),
                       passwords VARCHAR(255),
                       email VARCHAR(100),
                       trangThai int
    -- Thêm các thông tin khác nếu cần
);



CREATE TABLE DonHang (
                         maDonHang INT PRIMARY KEY IDENTITY(1,1),
                         userId INT,
                         ngayDat DATE,
                         tongTien DECIMAL(10,1),
                         diaChiNhanHang NVARCHAR(255),
                         soDienThoai VARCHAR(20),
                         phuongThucThanhToan VARCHAR(50),
                         trangThai INT,
                         FOREIGN KEY (userId) REFERENCES Users(id)
);
CREATE TABLE DonHangChiTiet (
                                id INT PRIMARY KEY IDENTITY(1,1),
                                maDonHang INT,
                                maSKU VARCHAR(50),
                                soLuong INT,
                                donGia DECIMAL(10,1),
                                FOREIGN KEY (maDonHang) REFERENCES DonHang(maDonHang),
                                FOREIGN KEY (maSKU) REFERENCES BienTheSanPham(maSKU)
);
