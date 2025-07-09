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


    private  final Service_DonHang donHangService;
//
//    @GetMapping
//    public String xemLichSu(HttpSession session, Model model) {
//        Users currentUser = (Users) session.getAttribute("currentUser");
//
//        if (currentUser == null) {
//            return "redirect:/login";
//        }
//
//        List<DonHang> danhSachDonHang = donHangService.getDonHangDangGiaoByUserId(currentUser.getId());
//        model.addAttribute("danhSachDonHang", danhSachDonHang);
//
//        return "lichSuMuaHang/trangchu";
//
//    }
@GetMapping
public String xemLichSu(@RequestParam(defaultValue = "0") int trangThai,
                        HttpSession session,
                        Model model) {

    
    Users currentUser = (Users) session.getAttribute("currentUser");

    if (currentUser == null) {
        return "redirect:/login";
    }

    List<DonHang> danhSachDonHang = donHangService.getDonHangByUserIdAndTrangThai(currentUser.getId(), trangThai);

    model.addAttribute("danhSachDonHang", danhSachDonHang);
    model.addAttribute("trangThai", trangThai);
    return "lichSuMuaHang/trangchu";
}
}

