package com.example.duanthuongmaidientu.Service;

import com.example.duanthuongmaidientu.Model.BienThe;
import com.example.duanthuongmaidientu.Model.DonHang;
import com.example.duanthuongmaidientu.Model.DonHangChiTiet;
import com.example.duanthuongmaidientu.Model.Users;
import com.example.duanthuongmaidientu.Repository.Repository_BienThe;
import com.example.duanthuongmaidientu.Repository.Repository_DonHang;
import com.example.duanthuongmaidientu.Repository.Repository_DonHangChiTiet;
import com.example.duanthuongmaidientu.Repository.Repository_Users;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class Service_DonHang {
    private final Repository_DonHang donHangRepo;
    private final Repository_DonHangChiTiet chiTietRepo;
    private final Repository_BienThe bienTheRepo;

    public DonHang taoDonHang(String maSKU, Integer soLuong, String diaChi, String sdt, String pttt, HttpSession session) {
        BienThe bienThe = bienTheRepo.findById(maSKU).orElse(null);
        if (bienThe == null) return null;

        Users currentUser = (Users) session.getAttribute("currentUser");
        if (currentUser == null) return null;

        // Tạo đơn hàng
        DonHang dh = new DonHang();
        dh.setUser(currentUser);
        dh.setNgayDat(LocalDate.now());
        dh.setDiaChiNhanHang(diaChi);
        dh.setSoDienThoai(sdt);
        dh.setPhuongThucThanhToan(pttt);
        dh.setTrangThai(0);
        dh.setTongTien(bienThe.getGia().multiply(BigDecimal.valueOf(soLuong)));
        donHangRepo.save(dh);

        // Tạo chi tiết đơn hàng
        DonHangChiTiet ct = new DonHangChiTiet();
        ct.setDonHang(dh);
        ct.setBienThe(bienThe);
        ct.setSoLuong(soLuong);
        ct.setDonGia(bienThe.getGia());
        chiTietRepo.save(ct);

        return dh;
    }

}
