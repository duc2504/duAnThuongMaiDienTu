INSERT INTO Users (username, passwords, email, trangThai)
VALUES ('1', '1', 'test@gmail.com', 1);
-- INSERT INTO DanhMuc

INSERT INTO DanhMuc (tenDanhMuc, moTa) VALUES (N'Smartphones', N'Điện thoại thông minh');
INSERT INTO DanhMuc (tenDanhMuc, moTa) VALUES (N'Laptops', N'Máy tính xách tay');
INSERT INTO DanhMuc (tenDanhMuc, moTa) VALUES (N'Smartwatches', N'Đồng hồ thông minh');
INSERT INTO DanhMuc (tenDanhMuc, moTa) VALUES (N'Tablets', N'Máy tính bảng');
INSERT INTO DanhMuc (tenDanhMuc, moTa) VALUES (N'Accessories', N'Phụ kiện công nghệ');
INSERT INTO DanhMuc (tenDanhMuc, moTa) VALUES (N'Menswear', N'Thời trang nam');
INSERT INTO DanhMuc (tenDanhMuc, moTa) VALUES (N'Womenswear', N'Thời trang nữ');
INSERT INTO DanhMuc (tenDanhMuc, moTa) VALUES (N'Footwear', N'Giày dép');
INSERT INTO DanhMuc (tenDanhMuc, moTa) VALUES (N'Bags', N'Túi xách');
INSERT INTO DanhMuc (tenDanhMuc, moTa) VALUES (N'Watches', N'Đồng hồ thời trang');

-- INSERT INTO SanPham
INSERT INTO SanPham (tenSanPham, moTa, thuongHieu, maDanhMuc, soLuong, gia) VALUES (N'SanPham1', N'Mô tả sản phẩm 1', N'Brand2', 1, 51, 110.5);
INSERT INTO SanPham (tenSanPham, moTa, thuongHieu, maDanhMuc, soLuong, gia) VALUES (N'SanPham2', N'Mô tả sản phẩm 2', N'Brand3', 2, 52, 121.0);
INSERT INTO SanPham (tenSanPham, moTa, thuongHieu, maDanhMuc, soLuong, gia) VALUES (N'SanPham3', N'Mô tả sản phẩm 3', N'Brand4', 3, 53, 131.5);
INSERT INTO SanPham (tenSanPham, moTa, thuongHieu, maDanhMuc, soLuong, gia) VALUES (N'SanPham4', N'Mô tả sản phẩm 4', N'Brand5', 4, 54, 142.0);
INSERT INTO SanPham (tenSanPham, moTa, thuongHieu, maDanhMuc, soLuong, gia) VALUES (N'SanPham5', N'Mô tả sản phẩm 5', N'Brand1', 5, 55, 152.5);
INSERT INTO SanPham (tenSanPham, moTa, thuongHieu, maDanhMuc, soLuong, gia) VALUES (N'SanPham6', N'Mô tả sản phẩm 6', N'Brand2', 6, 56, 163.0);
INSERT INTO SanPham (tenSanPham, moTa, thuongHieu, maDanhMuc, soLuong, gia) VALUES (N'SanPham7', N'Mô tả sản phẩm 7', N'Brand3', 7, 57, 173.5);
INSERT INTO SanPham (tenSanPham, moTa, thuongHieu, maDanhMuc, soLuong, gia) VALUES (N'SanPham8', N'Mô tả sản phẩm 8', N'Brand4', 8, 58, 184.0);
INSERT INTO SanPham (tenSanPham, moTa, thuongHieu, maDanhMuc, soLuong, gia) VALUES (N'SanPham9', N'Mô tả sản phẩm 9', N'Brand5', 9, 59, 194.5);
INSERT INTO SanPham (tenSanPham, moTa, thuongHieu, maDanhMuc, soLuong, gia) VALUES (N'SanPham10', N'Mô tả sản phẩm 10', N'Brand1', 10, 60, 205.0);
INSERT INTO SanPham (tenSanPham, moTa, thuongHieu, maDanhMuc, soLuong, gia) VALUES (N'SanPham11', N'Mô tả sản phẩm 11', N'Brand2', 1, 61, 215.5);
INSERT INTO SanPham (tenSanPham, moTa, thuongHieu, maDanhMuc, soLuong, gia) VALUES (N'SanPham12', N'Mô tả sản phẩm 12', N'Brand3', 2, 62, 226.0);
INSERT INTO SanPham (tenSanPham, moTa, thuongHieu, maDanhMuc, soLuong, gia) VALUES (N'SanPham13', N'Mô tả sản phẩm 13', N'Brand4', 3, 63, 236.5);
INSERT INTO SanPham (tenSanPham, moTa, thuongHieu, maDanhMuc, soLuong, gia) VALUES (N'SanPham14', N'Mô tả sản phẩm 14', N'Brand5', 4, 64, 247.0);
INSERT INTO SanPham (tenSanPham, moTa, thuongHieu, maDanhMuc, soLuong, gia) VALUES (N'SanPham15', N'Mô tả sản phẩm 15', N'Brand1', 5, 65, 257.5);

-- INSERT INTO BienTheSanPham
INSERT INTO BienTheSanPham (maSKU, maSanPham, gia, soLuong) VALUES ('SKU11', 1, 112000.5, 21);
INSERT INTO BienTheSanPham (maSKU, maSanPham, gia, soLuong) VALUES ('SKU12', 1, 115000000.0, 22);
INSERT INTO BienTheSanPham (maSKU, maSanPham, gia, soLuong) VALUES ('SKU13', 1, 117000.5, 23);
INSERT INTO BienTheSanPham (maSKU, maSanPham, gia, soLuong) VALUES ('SKU14', 1, 1200000.0, 24);
INSERT INTO BienTheSanPham (maSKU, maSanPham, gia, soLuong) VALUES ('SKU21', 2, 122000.5, 21);
INSERT INTO BienTheSanPham (maSKU, maSanPham, gia, soLuong) VALUES ('SKU22', 2, 125000.0, 22);
INSERT INTO BienTheSanPham (maSKU, maSanPham, gia, soLuong) VALUES ('SKU23', 2, 127000.5, 23);
INSERT INTO BienTheSanPham (maSKU, maSanPham, gia, soLuong) VALUES ('SKU24', 2, 130000.0, 24);
INSERT INTO BienTheSanPham (maSKU, maSanPham, gia, soLuong) VALUES ('SKU31', 3, 132000000.5, 21);
INSERT INTO BienTheSanPham (maSKU, maSanPham, gia, soLuong) VALUES ('SKU32', 3, 135000.0, 22);
INSERT INTO BienTheSanPham (maSKU, maSanPham, gia, soLuong) VALUES ('SKU33', 3, 1370.5, 23);
INSERT INTO BienTheSanPham (maSKU, maSanPham, gia, soLuong) VALUES ('SKU34', 3, 1400.0, 24);
INSERT INTO BienTheSanPham (maSKU, maSanPham, gia, soLuong) VALUES ('SKU41', 4, 1420.5, 21);
INSERT INTO BienTheSanPham (maSKU, maSanPham, gia, soLuong) VALUES ('SKU42', 4, 145.0, 22);
INSERT INTO BienTheSanPham (maSKU, maSanPham, gia, soLuong) VALUES ('SKU43', 4, 147.5, 23);
INSERT INTO BienTheSanPham (maSKU, maSanPham, gia, soLuong) VALUES ('SKU44', 4, 150.0, 24);
INSERT INTO BienTheSanPham (maSKU, maSanPham, gia, soLuong) VALUES ('SKU51', 5, 152.5, 21);
INSERT INTO BienTheSanPham (maSKU, maSanPham, gia, soLuong) VALUES ('SKU52', 5, 155.0, 22);
INSERT INTO BienTheSanPham (maSKU, maSanPham, gia, soLuong) VALUES ('SKU53', 5, 157.5, 23);
INSERT INTO BienTheSanPham (maSKU, maSanPham, gia, soLuong) VALUES ('SKU54', 5, 160.0, 24);

-- INSERT INTO ThuocTinhBienThe
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU11', N'Màu sắc', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU11', N'Dung lượng', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU12', N'Màu sắc', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU12', N'Dung lượng', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU13', N'Màu sắc', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU13', N'Dung lượng', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU14', N'Màu sắc', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU14', N'Dung lượng', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU21', N'Màu sắc', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU21', N'Dung lượng', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU22', N'Màu sắc', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU22', N'Dung lượng', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU23', N'Màu sắc', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU23', N'Dung lượng', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU24', N'Màu sắc', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU24', N'Dung lượng', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU31', N'Màu sắc', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU31', N'Dung lượng', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU32', N'Màu sắc', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU32', N'Dung lượng', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU33', N'Màu sắc', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU33', N'Dung lượng', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU34', N'Màu sắc', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU34', N'Dung lượng', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU41', N'Màu sắc', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU41', N'Dung lượng', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU42', N'Màu sắc', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU42', N'Dung lượng', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU43', N'Màu sắc', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU43', N'Dung lượng', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU44', N'Màu sắc', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU44', N'Dung lượng', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU51', N'Màu sắc', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU51', N'Dung lượng', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU52', N'Màu sắc', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU52', N'Dung lượng', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU53', N'Màu sắc', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU53', N'Dung lượng', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU54', N'Màu sắc', 1);
INSERT INTO ThuocTinhBienThe (maSKU, tenThuocTinh, TrangThai) VALUES ('SKU54', N'Dung lượng', 1);