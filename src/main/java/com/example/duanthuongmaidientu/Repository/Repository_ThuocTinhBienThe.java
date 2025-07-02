package com.example.duanthuongmaidientu.Repository;

import com.example.duanthuongmaidientu.Model.ThuocTinhBienThe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface  Repository_ThuocTinhBienThe extends JpaRepository<ThuocTinhBienThe , Integer> {

    List<ThuocTinhBienThe> findByBienThe_MaSKU(String maSKU);
   // ✅ Truy cập qua object BienThe



    @Query("SELECT t FROM ThuocTinhBienThe t WHERE t.bienThe.sanPham.maSanPham = :maSanPham")
    List<ThuocTinhBienThe> findByMaSanPham(@Param("maSanPham") Integer maSanPham);
}
