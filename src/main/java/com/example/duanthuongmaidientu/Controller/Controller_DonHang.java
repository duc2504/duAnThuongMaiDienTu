package com.example.duanthuongmaidientu.Controller;

import com.example.duanthuongmaidientu.Model.DonHang;
import com.example.duanthuongmaidientu.Model.Users;
import com.example.duanthuongmaidientu.Repository.Repository_DonHang;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/donhang")
public class Controller_DonHang {

//    private final Repository_DonHang repositoryDonHang;
//
//    @GetMapping("/list")
//    public String getDonHangByUserId(HttpSession session, Model model) {
//        Users currentUser = (Users) session.getAttribute("currentUser");
//
//        if (currentUser == null) {
//            return "redirect:/login"; // nếu chưa login thì chuyển hướng
//        }
//
//        List<DonHang> danhSachDonHang = repositoryDonHang.findByUser(currentUser);
//        model.addAttribute("donHangs", danhSachDonHang);
//
//        return "donhang/donHangHienTai"; // Trang hiển thị danh sách đơn hàng
//    }
}
