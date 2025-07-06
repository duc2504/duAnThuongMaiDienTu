package com.example.duanthuongmaidientu.Service;

import com.example.duanthuongmaidientu.Model.ThuocTinh;
import com.example.duanthuongmaidientu.Repository.Repository_ThuocTinh;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Service_ThuocTinh {
    private final Repository_ThuocTinh repository_thuocTinh ;
    public List<ThuocTinh> getThuocTinhBySanPham(Integer maSanPham) {
        return repository_thuocTinh.findThuocTinhByMaSanPham(maSanPham);
    }
}
