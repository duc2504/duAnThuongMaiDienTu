package com.example.duanthuongmaidientu.Repository;

import com.example.duanthuongmaidientu.Model.SanPham;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface Repository_SanPham extends JpaRepository<SanPham, Integer> {
    List<SanPham> findByTenSanPhamContainingIgnoreCase(String tenSanPham);

    Page<SanPham> findByTenSanPhamContainingIgnoreCaseAndTrangThai(String tenSanPham, int trangThai, Pageable pageable);

    // Lấy tất cả sản phẩm có trangThai = 0
    Page<SanPham> findByTrangThai(int trangThai, Pageable pageable);
//    List<SanPham> findByUser_Id(Integer userId);

//    List<SanPham> findByUser_IdAndTrangThai(Integer userId, int trangThai);
Page<SanPham> findByUser_IdAndTrangThai(Integer userId, Integer trangThai, Pageable pageable);

}



