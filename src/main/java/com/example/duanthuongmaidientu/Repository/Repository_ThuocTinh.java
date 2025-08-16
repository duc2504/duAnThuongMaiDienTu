package com.example.duanthuongmaidientu.Repository;

import com.example.duanthuongmaidientu.Model.ThuocTinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Repository_ThuocTinh extends JpaRepository<ThuocTinh , Integer> {
    @Query("SELECT DISTINCT t FROM ThuocTinh t " +
            "WHERE t.bienThe.sanPham.maSanPham = :maSanPham")
    List<ThuocTinh> findThuocTinhByMaSanPham(@Param("maSanPham") Integer maSanPham);
}
