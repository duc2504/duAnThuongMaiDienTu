package com.example.duanthuongmaidientu.Repository;

import com.example.duanthuongmaidientu.Model.BienThe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Repository_BienThe extends JpaRepository<BienThe, String> {
    List<BienThe> findBySanPham_MaSanPham(Integer maSanPham);

    BienThe findByMaSKU(String maSKU);  //






}
