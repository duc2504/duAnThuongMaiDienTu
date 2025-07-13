package com.example.duanthuongmaidientu.Controller;

import com.example.duanthuongmaidientu.Model.DonHang;
import com.example.duanthuongmaidientu.Model.Users;
import com.example.duanthuongmaidientu.Service.Service_DonHang;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/lichsumuahang")
@RequiredArgsConstructor
public class Controller_LichSuMuaHang {


    private final Service_DonHang donHangService;


    @GetMapping
    public String xemLichSu(@RequestParam(required = false) Integer trangThai,
                            HttpSession session,
                            Model model) {

        Users currentUser = (Users) session.getAttribute("currentUser");

        if (currentUser == null) {
            return "redirect:/login";
        }

        List<DonHang> danhSachDonHang;

        if (trangThai == null) {
            // Nếu không có trạng thái -> lấy tất cả đơn hàng theo user
            danhSachDonHang = donHangService.getDonHangByUser(currentUser);
        } else {
            // Nếu có trạng thái -> lọc theo trạng thái
            danhSachDonHang = donHangService.getDonHangByUserIdAndTrangThai(currentUser.getId(), trangThai);
            model.addAttribute("trangThai", trangThai);
        }

        model.addAttribute("danhSachDonHang", danhSachDonHang);
        return "lichSuMuaHang/trangchu";
    }

    @GetMapping("/shop")
    public String duyetDonHang(Model model, HttpSession session) {
        Users currentShop = (Users) session.getAttribute("currentUser");

        if (currentShop == null) {
            return "redirect:/login";
        }

        List<DonHang> donHangList = donHangService.getDonHangsByShop(currentShop.getId());
        model.addAttribute("donHangList", donHangList);

        return "lichSuMuaHang/shop"; // trỏ tới file donhang.html
    }
}
