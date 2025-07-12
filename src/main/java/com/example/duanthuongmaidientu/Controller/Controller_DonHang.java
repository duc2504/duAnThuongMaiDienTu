package com.example.duanthuongmaidientu.Controller;

import com.example.duanthuongmaidientu.Model.BienThe;
import com.example.duanthuongmaidientu.Model.DonHang;
import com.example.duanthuongmaidientu.Model.SanPham;
import com.example.duanthuongmaidientu.Service.Service_BienThe;
import com.example.duanthuongmaidientu.Service.Service_DonHang;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/donhang")
@RequiredArgsConstructor
public class Controller_DonHang {

    private final Service_BienThe service_bienThe;
    private final Service_DonHang service_donHang;

    @GetMapping("/nhapthongtin")
    public String hienThiForm(@RequestParam("maSKU") String maSKU,
                              @RequestParam("soLuong") Integer soLuong,
                              Model model) {

        BienThe bienThe = service_bienThe.getOne(maSKU);

        if (bienThe == null || bienThe.getSanPham() == null) {
            return "redirect:/sanpham";
        }

        Integer maSanPham = bienThe.getSanPham().getMaSanPham();

        // Nếu số lượng vượt quá tồn kho
        if (soLuong <= 0 || soLuong > bienThe.getSoLuong()) {
            soLuong = 1; // Hoặc return lỗi
        }

        // Thay vì tạo imageList cho tất cả biến thể
        String mainImage = "/images/" + maSanPham + "/" + bienThe.getMaSKU() + "-1.png";
        model.addAttribute("mainImage", mainImage);



        model.addAttribute("bienThe", bienThe);
        model.addAttribute("soLuong", soLuong);
        model.addAttribute("thuocTinhs", bienThe.getThuocTinhs());
        model.addAttribute("sanPham", bienThe.getSanPham()); // Gửi thêm nếu cần

        return "donhang/thongtin";
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

        BienThe bienThe = service_bienThe.getOne(maSKU);
        if (bienThe == null || bienThe.getSoLuong() < soLuong) {
            model.addAttribute("error", "Số lượng không hợp lệ hoặc biến thể không tồn tại.");
            return "redirect:/sanpham";
        }

        DonHang dh = service_donHang.taoDonHang(maSKU, soLuong, diaChi, sdt, pttt, session);
        if (dh == null) {
            session.invalidate(); // Có thể giữ lại session nếu chỉ lỗi nhỏ
            return "redirect:/login";
        }

        return "redirect:/sanpham"; // Sau này có thể trả về trang xác nhận đơn hàng
    }

}
