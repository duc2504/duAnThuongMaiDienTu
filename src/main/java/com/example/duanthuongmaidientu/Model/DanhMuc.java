package com.example.duanthuongmaidientu.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "DanhMuc")
public class DanhMuc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maDanhMuc;

    private String tenDanhMuc;

    private String moTa;

    @OneToMany(mappedBy = "danhMuc")
    private List<SanPham> sanPhams;
}
