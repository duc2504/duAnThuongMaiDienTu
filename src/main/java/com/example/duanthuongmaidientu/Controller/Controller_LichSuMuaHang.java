package com.example.duanthuongmaidientu.Controller;

import com.example.duanthuongmaidientu.Model.DonHang;
import com.example.duanthuongmaidientu.Model.Users;
import com.example.duanthuongmaidientu.Service.Service_DonHang;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        Users user = (Users) session.getAttribute("currentUser");
        if (user != null) {
            model.addAttribute("fullname", user.getUsername()); // hoặc user.getFullname() nếu có
        } else {
            model.addAttribute("fullname", "Khách");
        }
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
//
//    @GetMapping("/shop")
//    public String duyetDonHang(Model model, HttpSession session) {
//        Users currentShop = (Users) session.getAttribute("currentUser");
//
//        if (currentShop == null) {
//            return "redirect:/login";
//        }
//        List<DonHang> donHangChoDuyet = donHangService.getDonHangsByShop(currentShop.getId());
//        List<DonHang> donHangList = donHangService.getDonHangsByShopAll(currentShop.getId());
//
//        model.addAttribute("donHangList", donHangList); // tất cả đơn
//        model.addAttribute("donHangChoDuyet", donHangChoDuyet); // đơn chờ duyệt
//        return "lichSuMuaHang/shop"; // trỏ tới file donhang.html
//    }


//    @GetMapping("/shop")
//    public String duyetDonHang(
//            @RequestParam(name = "thang", required = false) Integer thang,
//
//
//            Model model, HttpSession session) {
//
//        Users currentShop = (Users) session.getAttribute("currentUser");
//        if (currentShop == null) {
//            return "redirect:/login";
//        }
//
//
//        // Danh sách đơn hàng đang chờ duyệt (trạng thái = 0)
//        List<DonHang> donHangChoDuyet = donHangService.getDonHangsByShop(currentShop.getId())
//                .stream()
//                .filter(d -> d.getTrangThai() == 0)
//                .collect(Collectors.toList());
//
//        // Danh sách tất cả đơn hàng (lọc theo tháng nếu có)
//        List<DonHang> donHangList = (thang != null)
//                ? donHangService.getDonHangsByShopAndMonth(currentShop.getId(), thang)
//                : donHangService.getDonHangsByShopAll(currentShop.getId());
//
//        model.addAttribute("donHangList", donHangList);
//        model.addAttribute("donHangChoDuyet", donHangChoDuyet);
//        model.addAttribute("thang", thang); // giữ lại tháng đã chọn
//
//        return "lichSuMuaHang/shop";
//    }



    @GetMapping("/shop")
    public String duyetDonHang(
            @RequestParam(name = "thang", required = false) Integer thang,
            @RequestParam(name = "nam", required = false) Integer nam,
            Model model,
            HttpSession session) {

        Users currentShop = (Users) session.getAttribute("currentUser");
        if (currentShop == null) {
            return "redirect:/login";
        }
        Users user = (Users) session.getAttribute("currentUser");
        if (user != null) {
            model.addAttribute("fullname", user.getUsername()); // hoặc user.getFullname() nếu có
        } else {
            model.addAttribute("fullname", "Khách");
        }

        // Danh sách đơn hàng đang chờ duyệt (trạng thái = 0)
        List<DonHang> donHangChoDuyet = donHangService.getDonHangsByShop(currentShop.getId())
                .stream()
                .filter(d -> d.getTrangThai() == 0)
                .collect(Collectors.toList());

        // Danh sách tất cả đơn hàng (lọc linh hoạt theo tháng, năm)
        List<DonHang> donHangList;
        if (thang != null && nam != null) {
            donHangList = donHangService.getDonHangsByShopAndMonthAndYear(currentShop.getId(), thang, nam);
        } else if (thang != null) {
            donHangList = donHangService.getDonHangsByShopAndMonth(currentShop.getId(), thang);
        } else if (nam != null) {
            donHangList = donHangService.getDonHangsByShopYear(currentShop.getId(), nam);
        } else {
            donHangList = donHangService.getDonHangsByShopAll(currentShop.getId());
        }

        model.addAttribute("donHangList", donHangList);
        model.addAttribute("donHangChoDuyet", donHangChoDuyet);
        model.addAttribute("thang", thang);
        model.addAttribute("nam", nam);

        return "lichSuMuaHang/shop";
    }






    @PostMapping("/shop/duyet/{maDonHang}")
    public String duyetDonHangPost(@PathVariable("maDonHang") Integer maDonHang, HttpSession session) {
        Users currentShop = (Users) session.getAttribute("currentUser");

        if (currentShop == null) {
            return "redirect:/login";
        }

        // Lấy đơn hàng theo mã (Integer)
        Optional<DonHang> optionalDonHang = donHangService.findByMaDonHang(maDonHang);

        if (optionalDonHang.isPresent()) {
            DonHang donHang = optionalDonHang.get();

            // Cập nhật trạng thái đơn hàng
            donHang.setTrangThai(1); // Trạng thái 1 = Đã duyệt
            donHangService.save(donHang); // Lưu lại

            System.out.println("✅ Đã duyệt đơn hàng: " + maDonHang);
        }

        return "redirect:/lichsumuahang/shop";
    }


}
