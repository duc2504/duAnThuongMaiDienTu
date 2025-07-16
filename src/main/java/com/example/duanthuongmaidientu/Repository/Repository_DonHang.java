package com.example.duanthuongmaidientu.Repository;

import com.example.duanthuongmaidientu.Model.DonHang;
import com.example.duanthuongmaidientu.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface Repository_DonHang extends JpaRepository<DonHang, Integer> {
    List<DonHang> findByUserId(Integer userId);





    List<DonHang> findByUser_IdAndTrangThai(Integer userId, Integer trangThai);


    List<DonHang> findByUser(Users users);

    Optional<DonHang> findByMaDonHang(Integer maDonHang);


    @Query("SELECT d FROM DonHang d WHERE MONTH(d.ngayDat) = :month AND EXISTS (" +
            "SELECT 1 FROM DonHangChiTiet ct WHERE ct.donHang = d AND ct.bienThe.sanPham.user.id = :shopId)")
    List<DonHang> findByShopIdAndMonth(@Param("shopId") Integer shopId, @Param("month") int month);


    @Query("SELECT d FROM DonHang d WHERE MONTH(d.ngayDat) = :month AND YEAR(d.ngayDat) = :year AND EXISTS (" +
            "SELECT 1 FROM DonHangChiTiet ct WHERE ct.donHang = d AND ct.bienThe.sanPham.user.id = :shopId)")
    List<DonHang> findByShopIdAndMonthAndYear(@Param("shopId") Integer shopId, @Param("month") int month, @Param("year") int year);



    @Query("SELECT d FROM DonHang d WHERE YEAR(d.ngayDat) = :year AND EXISTS (" +
            "SELECT 1 FROM DonHangChiTiet ct WHERE ct.donHang = d AND ct.bienThe.sanPham.user.id = :shopId)")
    List<DonHang> findByShopIdAndYear(@Param("shopId") Integer shopId, @Param("year") int year);

    List<DonHang> findByTrangThai(Integer trangThai);

}

