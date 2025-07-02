package com.example.duanthuongmaidientu.Repository;

import com.example.duanthuongmaidientu.Model.DonHang;
import com.example.duanthuongmaidientu.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Repository_DonHang extends JpaRepository<DonHang, Integer> {
    List<DonHang> findByUserId(Integer userId);



    List<DonHang> findByUser(Users user);
}

