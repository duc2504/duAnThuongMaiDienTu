package com.example.duanthuongmaidientu.Service;

import com.example.duanthuongmaidientu.Model.DanhMuc;
import com.example.duanthuongmaidientu.Repository.Repository_DanhMuc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class Service_DanhMuc {

    private final Repository_DanhMuc repository_danhMuc;

    public List<DanhMuc> getAll() {
        return repository_danhMuc.findAll();
    }

    public DanhMuc getOne(Integer id) {
        Optional<DanhMuc> danhMuc = repository_danhMuc.findById(id);
        return danhMuc.orElse(null);
    }

    public void save(DanhMuc danhMuc) {
        repository_danhMuc.save(danhMuc);
    }

    public void delete(Integer id) {
        repository_danhMuc.deleteById(id);
    }
}
