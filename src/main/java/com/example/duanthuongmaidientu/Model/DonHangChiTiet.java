package com.example.duanthuongmaidientu.Model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "DonHangChiTiet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DonHangChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "maDonHang")
    private DonHang donHang;

    @ManyToOne
    @JoinColumn(name = "maSKU")
    private BienThe bienThe;

    private int soLuong;

    private BigDecimal donGia;




    @Transient
    public String getDonGiaHienThi() {
        if (donGia == null) return "0 đ";
        java.text.DecimalFormat formatter = new java.text.DecimalFormat("#,###");
        formatter.setGroupingUsed(true);
        formatter.setGroupingSize(3);
        // Thay dấu phẩy bằng dấu chấm
        return formatter.format(donGia).replace(",", ".") + " đ";
    }
}
