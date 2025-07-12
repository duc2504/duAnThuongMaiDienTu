package com.example.duanthuongmaidientu.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "SanPham")
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maSanPham;

    private String tenSanPham;

    private String moTa;

    private String thuongHieu;

    private Integer soLuong;

    private BigDecimal gia;

    private Integer trangThai ;

    @ManyToOne
    @JoinColumn(name = "maDanhMuc")
    private DanhMuc danhMuc;

    @OneToMany(mappedBy = "sanPham")
    private List<BienThe> bienThes;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Users user;

    @Transient
    public String getGiaHienThi() {
        if (gia == null) return "0 đ";
        java.text.DecimalFormat formatter = new java.text.DecimalFormat("#,###");
        formatter.setGroupingUsed(true);
        formatter.setGroupingSize(3);
        // Thay dấu phẩy bằng dấu chấm
        return formatter.format(gia).replace(",", ".") + " đ";
    }

}
