package com.example.duanthuongmaidientu.Repository;

import com.example.duanthuongmaidientu.Model.DonHang;
import com.example.duanthuongmaidientu.Model.DonHangChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Repository_DonHangChiTiet extends JpaRepository<DonHangChiTiet, Integer> {


    List<DonHangChiTiet> findByDonHang_MaDonHang(Integer maDonHang);


}

