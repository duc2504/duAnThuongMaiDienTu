package com.example.duanthuongmaidientu.Controller;

import com.example.duanthuongmaidientu.Model.BienThe;
import com.example.duanthuongmaidientu.Model.DonHang;
import com.example.duanthuongmaidientu.Service.Service_BienThe;
import com.example.duanthuongmaidientu.Service.Service_DonHang;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/donhang")
@RequiredArgsConstructor
public class Controller_DonHang {

    private final Service_BienThe service_bienThe;
    private final Service_DonHang service_donHang;

    // Hiển thị form đặt hàng (gộp hiển thị sản phẩm, số lượng, địa chỉ, sđt, thanh toán)
    @GetMapping("/nhapthongtin")
    public String hienThiForm(@RequestParam("sku") String maSKU,
                              @RequestParam("soluong") Integer soLuong,
                              Model model) {


        List<String> imageList = List.of(
                "/images/sanpham" + maSKU + "_1.png"
        );
        model.addAttribute("imageList", imageList);
        BienThe bienThe = service_bienThe.getBienTheBySKU(maSKU).orElse(null);
        if (bienThe == null) return "redirect:/sanpham";

        model.addAttribute("bienThe", bienThe);
        model.addAttribute("soLuong", soLuong);
        return "donhang/thongtin"; // HTML xử lý tất cả tại đây
    }

    // Đặt hàng sau khi điền đầy đủ thông tin
    @PostMapping("/dat")
    public String datHang(@RequestParam String maSKU,
                          @RequestParam Integer soLuong,
                          @RequestParam String diaChi,
                          @RequestParam String sdt,
                          @RequestParam String pttt,
                          HttpSession session,
                          Model model) {

        DonHang dh = service_donHang.taoDonHang(maSKU, soLuong, diaChi, sdt, pttt, session);

        if (dh == null) {
            session.invalidate(); // Xoá session nếu user null (bảo mật nhẹ)
            return "redirect:/login";
        }

        model.addAttribute("donHang", dh);
        return "redirect:/sanpham"; // Giao diện xác nhận đơn hàng
    }
}
