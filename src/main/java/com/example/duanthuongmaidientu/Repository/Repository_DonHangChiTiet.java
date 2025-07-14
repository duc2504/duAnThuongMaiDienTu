package com.example.duanthuongmaidientu.Repository;

import com.example.duanthuongmaidientu.Model.DonHang;
import com.example.duanthuongmaidientu.Model.DonHangChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Repository_DonHangChiTiet extends JpaRepository<DonHangChiTiet, Integer> {


    List<DonHangChiTiet> findByDonHang_MaDonHang(Integer maDonHang);



    @Query("""
    SELECT DISTINCT ct.donHang 
    FROM DonHangChiTiet ct 
    WHERE ct.bienThe.sanPham.user.id = :shopId
      AND ct.donHang.trangThai = 0
    ORDER BY ct.donHang.ngayDat DESC
""")
    List<DonHang> findDonHangsChoDuyetByShopId(@Param("shopId") Integer shopId);


    @Query("""
    SELECT DISTINCT ct.donHang 
    FROM DonHangChiTiet ct 
    WHERE ct.bienThe.sanPham.user.id = :shopId
    
    ORDER BY ct.donHang.ngayDat DESC
""")
    List<DonHang> findDonHangsChoDuyetByShopIdALL(@Param("shopId") Integer shopId);
}

