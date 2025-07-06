package com.example.duanthuongmaidientu.Service;

import com.example.duanthuongmaidientu.Model.ThuocTinhBienThe;
import com.example.duanthuongmaidientu.Repository.Repository_ThuocTinhBienThe;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Service_ThuocTinhBienThe {

    private final Repository_ThuocTinhBienThe repository_thuocTinh;


    public List<ThuocTinhBienThe> getAll() {
        return repository_thuocTinh.findAll();
    }

    public ThuocTinhBienThe getOne(Integer id) {
        Optional<ThuocTinhBienThe> tt = repository_thuocTinh.findById(id);
        return tt.orElse(null);
    }

    public void save(ThuocTinhBienThe thuocTinh) {
        repository_thuocTinh.save(thuocTinh);
    }

    public void delete(Integer id) {
        repository_thuocTinh.deleteById(id);
    }
//    public List<ThuocTinhBienThe> getByMaSanPham(Integer maSanPham) {
//        return repository_thuocTinh.findByMaSanPham(maSanPham);
//    }
//
//    public List<ThuocTinhBienThe> getByMaSKU(String maSKU) {
//        return repository_thuocTinh.findByBienThe_MaSKU(maSKU);
//    }
//
//
//    public List<ThuocTinhBienThe> findByMaSKU(String maSKU) {
//        return repository_thuocTinh.findByBienThe_MaSKU(maSKU);
//    }
}
