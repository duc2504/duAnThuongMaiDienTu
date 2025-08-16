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
@Table(name = "BienTheSanPham")
public class BienThe {




    @Id
    private String maSKU;


    private BigDecimal gia;

    private Integer soLuong;


    private Integer TrangThai;
    @ManyToOne
    @JoinColumn(name = "maSanPham")
    private SanPham sanPham;

    @OneToMany(mappedBy = "bienThe")
    private List<ThuocTinh> thuocTinhs;

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
