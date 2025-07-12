package com.example.duanthuongmaidientu.Service;

import com.example.duanthuongmaidientu.Model.BienThe;
import com.example.duanthuongmaidientu.Repository.Repository_BienThe;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class Service_BienThe {

    private final Repository_BienThe repository_bienThe;

    @Autowired
    public Service_BienThe(Repository_BienThe repository_bienThe) {
        this.repository_bienThe = repository_bienThe;
    }

    public List<BienThe> getAll() {
        return repository_bienThe.findAll();
    }

    public BienThe getOne(String maSKU) {
        Optional<BienThe> bienThe = repository_bienThe.findById(maSKU);
        return bienThe.orElse(null);
    }

    public void save(BienThe bienThe) {
        repository_bienThe.save(bienThe);
    }

    public void delete(String maSKU) {
        repository_bienThe.deleteById(maSKU);
    }


    public List<BienThe> findBySanPham_MaSanPham(Integer maSanPham) {
        return repository_bienThe.findBySanPham_MaSanPham(maSanPham);
    }

}
