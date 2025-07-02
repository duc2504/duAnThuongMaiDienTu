package com.example.duanthuongmaidientu.Service;

import com.example.duanthuongmaidientu.Model.SanPham;
import com.example.duanthuongmaidientu.Repository.Repository_SanPham;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Service_SanPham {

    private final Repository_SanPham repository_sanPham;

    // Lấy toàn bộ sản phẩm có phân trang
    public Page<SanPham> getAll(Pageable pageable) {
        return repository_sanPham.findAll(pageable);
    }

    // Lấy toàn bộ sản phẩm (không phân trang)
    public List<SanPham> getAll() {
        return repository_sanPham.findAll();
    }

    public SanPham getOne(Integer id) {
        Optional<SanPham> sanPham = repository_sanPham.findById(id);
        return sanPham.orElse(null);
    }

    public void save(SanPham sanPham) {
        repository_sanPham.save(sanPham);
    }

    public void delete(Integer id) {
        repository_sanPham.deleteById(id);
    }

    // Tìm kiếm theo tên sản phẩm (ignore case)
    public List<SanPham> searchByTen(String tenSanPham) {
        return repository_sanPham.findByTenSanPhamContainingIgnoreCase(tenSanPham);
    }
}
