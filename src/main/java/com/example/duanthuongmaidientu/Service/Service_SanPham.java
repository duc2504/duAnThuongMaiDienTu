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



//     Lấy toàn bộ sản phẩm không phân trang
    public List<SanPham> getAll() {
        return repository_sanPham.findAll();
    }

    // Lấy 1 sản phẩm theo ID
    public SanPham getOne(Integer id) {
        Optional<SanPham> sanPham = repository_sanPham.findById(id);
        return sanPham.orElse(null);
    }

    // Lưu hoặc cập nhật sản phẩm
    public void save(SanPham sanPham) {
        repository_sanPham.save(sanPham);
    }

    // Xóa sản phẩm theo ID
    public void delete(Integer id) {
        repository_sanPham.deleteById(id);
    }

    // Tìm kiếm sản phẩm theo tên (không phân trang)
    public List<SanPham> searchByTen(String tenSanPham) {
        return repository_sanPham.findByTenSanPhamContainingIgnoreCase(tenSanPham);
    }





    public Page<SanPham> getAll(Pageable pageable) {
        return repository_sanPham.findByTrangThai(0, pageable); // Chỉ lấy sản phẩm có trangThai = 0
    }

    public Page<SanPham> searchByTen(String tenSanPham, Pageable pageable) {
        return repository_sanPham.findByTenSanPhamContainingIgnoreCaseAndTrangThai(tenSanPham, 0, pageable);
    }

//    public List<SanPham> getSanPhamByUserId(Integer userId) {
//        return repository_sanPham.findByUser_Id(userId);
//    }

//    public List<SanPham> getSanPhamByUserId(Integer userId) {
//        return repository_sanPham.findByUser_IdAndTrangThai(userId, 0);
//    }


    public Page<SanPham> getSanPhamByUserId(Integer userId, Pageable pageable) {
        if (userId == null) {
            return Page.empty(pageable);
        }
        return repository_sanPham.findByUser_IdAndTrangThai(userId, 0, pageable);
    }

    public Page<SanPham> getSanPhamByUserIdLoc(Integer userId, Pageable pageable) {
        if (userId == null) {
            return Page.empty(pageable);
        }
        return repository_sanPham.findByUser_IdAndTrangThai(userId, 1, pageable);
    }

}
