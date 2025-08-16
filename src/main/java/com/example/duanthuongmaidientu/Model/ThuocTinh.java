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
@Table(name = "ThuocTinh")
public class ThuocTinh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maThuocTinh;

    private String tenThuocTinh;

    private String tenThuocTinhBienThe;


    private Integer TrangThai  ;
    @ManyToOne
    @JoinColumn(name = "maSKU")
    private BienThe bienThe;
}
