package com.example.duanthuongmaidientu.Service;

import com.example.duanthuongmaidientu.Model.BienThe;
import com.example.duanthuongmaidientu.Model.DonHang;
import com.example.duanthuongmaidientu.Model.DonHangChiTiet;
import com.example.duanthuongmaidientu.Model.Users;
import com.example.duanthuongmaidientu.Repository.Repository_BienThe;
import com.example.duanthuongmaidientu.Repository.Repository_DonHang;
import com.example.duanthuongmaidientu.Repository.Repository_DonHangChiTiet;
import com.example.duanthuongmaidientu.Repository.Repository_Users;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class Service_DonHang {
    private final Repository_Users repository_users;

    private final Repository_DonHang repository_donHang;
    private final Service_BienThe service_bienThe;
    private final Repository_BienThe repository_bienThe ;
    private final Repository_DonHangChiTiet repository_donHangChiTiet;




    private final Repository_Users usersRepository;




    public void datHangDayDu(String maSKU, int soLuong, String diaChi, String soDienThoai, String phuongThuc, Integer userId) {
        BienThe bienThe = repository_bienThe.findByMaSKU(maSKU);
        Users user = repository_users.findById(userId).orElse(null);

        if (bienThe == null || user == null) return;

        BigDecimal donGia = bienThe.getGia();


        BigDecimal tongTien = donGia.multiply(BigDecimal.valueOf(soLuong));

        // Tạo đơn hàng
        DonHang donHang = new DonHang();
        donHang.setUser(user);
        donHang.setNgayDat(LocalDate.now());
        donHang.setTongTien(tongTien);
        donHang.setDiaChiNhanHang(diaChi);
        donHang.setSoDienThoai(soDienThoai);
        donHang.setPhuongThucThanhToan(phuongThuc);
        donHang.setTrangThai(0); // mặc định chưa xử lý
        repository_donHang.save(donHang);

        // Tạo chi tiết đơn hàng
        DonHangChiTiet chiTiet = new DonHangChiTiet();
        chiTiet.setDonHang(donHang);
        chiTiet.setBienThe(bienThe);
        chiTiet.setSoLuong(soLuong);
        chiTiet.setDonGia(donGia);
        repository_donHangChiTiet.save(chiTiet);

        // Gán vào đơn hàng để lưu bidirectional (không bắt buộc nếu cascade)
        donHang.setChiTietDonHangs(Collections.singletonList(chiTiet));
    }

}
