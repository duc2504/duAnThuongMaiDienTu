package com.example.duanthuongmaidientu.Controller;

import com.example.duanthuongmaidientu.Model.DonHang;
import com.example.duanthuongmaidientu.Service.Service_DonHang;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class Controller_admin {
    private final Service_DonHang service_donHang ;

    @GetMapping
    public String xemTatCaDonHangTheoTrangThai(@RequestParam(required = false) Integer trangThai,
                                               Model model) {

        List<DonHang> danhSachDonHang;

        if (trangThai == null) {
            // Nếu không có trạng thái -> lấy tất cả đơn hàng
            danhSachDonHang = service_donHang.getAllDonHang();
        } else {
            // Lọc theo trạng thái
            danhSachDonHang = service_donHang.getDonHangByTrangThai(trangThai);
            model.addAttribute("trangThai", trangThai);
        }

        model.addAttribute("danhSachDonHang", danhSachDonHang);
        return "/admin/trangchu";
    }

    // POST: Giao hàng -> cập nhật trạng thái = 2
    @PostMapping("/giaohang/{maDon}")
    public String capNhatGiaoHang(@PathVariable Integer  maDon) {
        Optional<DonHang> opt = service_donHang.findById(maDon);
        if (opt.isPresent()) {
            DonHang donHang = opt.get();
            donHang.setTrangThai(2); // Trạng thái đang giao
            service_donHang.save(donHang);
        }
        return "redirect:/admin?trangThai=1"; // Quay lại tab "Chờ lấy hàng"
    }

    // POST: Hoàn thành -> cập nhật trạng thái = 3
    @PostMapping("/hoanthanh/{maDon}")
    public String capNhatHoanThanh(@PathVariable Integer maDon) {
        Optional<DonHang> opt = service_donHang.findById(maDon);
        if (opt.isPresent()) {
            DonHang donHang = opt.get();
            donHang.setTrangThai(3); // Trạng thái hoàn thành
            service_donHang.save(donHang);
        }
        return "redirect:/admin?trangThai=2"; // Quay lại tab "Đang giao"
    }

    @PostMapping("/huy/{maDon}")
    public String huyDonHang(@PathVariable Integer maDon) {
        Optional<DonHang> opt = service_donHang.findById(maDon);
        if (opt.isPresent()) {
            DonHang donHang = opt.get();
            donHang.setTrangThai(4); // Đã hủy
            service_donHang.save(donHang);
        }

        // Điều hướng về đúng tab theo trạng thái ban đầu
        return "redirect:/admin?trangThai=4"; // hoặc `2`, tùy vào logic
    }


}
