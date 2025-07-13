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


    @Transient
    public String getGiaHienThi() {
        if (tongTien == null) return "0 đ";
        java.text.DecimalFormat formatter = new java.text.DecimalFormat("#,###");
        formatter.setGroupingUsed(true);
        formatter.setGroupingSize(3);
        // Thay dấu phẩy bằng dấu chấm
        return formatter.format(tongTien).replace(",", ".") + " đ";
    }

    @Transient
    public String getTrangThaiHienThi() {
        if (trangThai == null) return "Không xác định";
        return switch (trangThai) {
            case 0 -> "Chờ duyệt";
            case 1 -> "Chờ lấy hàng";
            case 2 -> "Đang giao hàng";
            case 3 -> "Hoàn thành";
            case 4 -> "Đã hủy";
            default -> "Không xác định";
        };
    }

}
