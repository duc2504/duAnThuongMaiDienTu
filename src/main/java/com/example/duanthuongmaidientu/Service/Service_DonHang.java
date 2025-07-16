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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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




    public List<DonHang> getDonHangByUserIdAndTrangThai(Integer userId, int trangThai) {
        return donHangRepo.findByUser_IdAndTrangThai(userId, trangThai);
    }

    public List<DonHang> getDonHangByUser(Users user) {
        return donHangRepo.findByUser(user);
    }






    public List<DonHang> getDonHangsByShop(Integer shopId) {
        return chiTietRepo.findDonHangsChoDuyetByShopId(shopId);
    }

    public List<DonHang> getDonHangsByShopAll(Integer shopId) {
        return chiTietRepo.findDonHangsChoDuyetByShopIdALL(shopId);
    }



    public Optional<DonHang> findByMaDonHang(Integer maDonHang) {
        return donHangRepo.findByMaDonHang(maDonHang);
    }

    public DonHang save(DonHang donHang) {
        return donHangRepo.save(donHang);
    }

    public List<DonHang> getDonHangsByShopAndMonth(Integer shopId, int month) {
        return donHangRepo.findByShopIdAndMonth(shopId, month);
    }


    public List<DonHang> getDonHangsByShopAndMonthAndYear(Integer shopId, int month , int year) {
        return donHangRepo.findByShopIdAndMonthAndYear(shopId, month , year);
    }

    public List<DonHang> getDonHangsByShopYear(Integer shopId, int year) {
        return donHangRepo.findByShopIdAndYear(shopId,  year);
    }

    public List<DonHang> getAllDonHang() {
        return donHangRepo.findAll();
    }

    public List<DonHang> getDonHangByTrangThai(Integer trangThai) {
        return donHangRepo.findByTrangThai(trangThai);
    }
    public Optional<DonHang> findById(Integer maDon) {
        return donHangRepo.findById(maDon);
    }

}
