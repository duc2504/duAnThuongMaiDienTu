package com.example.duanthuongmaidientu.Repository;

import com.example.duanthuongmaidientu.Model.SanPham;
import com.example.duanthuongmaidientu.Model.ThuocTinhBienThe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Repository_SanPham extends JpaRepository<SanPham, Integer> {
    List<SanPham> findByTenSanPhamContainingIgnoreCase(String tenSanPham);
}
