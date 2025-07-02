package com.example.duanthuongmaidientu.Model;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "DonHang")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DonHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maDonHang;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Users user;

    private LocalDate ngayDat;

    private BigDecimal tongTien;

    private String diaChiNhanHang;

    private String soDienThoai;

    private String phuongThucThanhToan;

    private Integer trangThai;

    @OneToMany(mappedBy = "donHang", cascade = CascadeType.ALL)
    private List<DonHangChiTiet> chiTietDonHangs;
}
