package com.example.duanthuongmaidientu.Controller;

import com.example.duanthuongmaidientu.Model.BienThe;
import com.example.duanthuongmaidientu.Model.SanPham;
import com.example.duanthuongmaidientu.Model.ThuocTinhBienThe;
import com.example.duanthuongmaidientu.Model.Users;
import com.example.duanthuongmaidientu.Repository.Repository_Users;
import com.example.duanthuongmaidientu.Service.Service_BienThe;
import com.example.duanthuongmaidientu.Service.Service_DonHang;
import com.example.duanthuongmaidientu.Service.Service_SanPham;
import com.example.duanthuongmaidientu.Service.Service_ThuocTinhBienThe;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/muahang")
public class Controller_DatHang {
//        private final Service_ThuocTinhBienThe service_thuocTinhBienThe;
//        private final Service_DonHang service_donHang ;
//        private final Repository_Users repository_users ;
//        private final Service_SanPham service_sanPham;
//        private final Service_BienThe service_bienThe;
//
//        @PostMapping("/tam")
//        public String luuTamThoi(@RequestParam("maSKU") String maSKU,
//                                 @RequestParam("soLuong") int soLuong,
//                                 HttpSession session) {
//                session.setAttribute("maSKU", maSKU);
//                session.setAttribute("soLuong", soLuong);
//                return "redirect:/muahang";
//        }
//
//        @GetMapping
//        public String hienFormDatHang(HttpSession session, Model model) {
//                String maSKU = (String) session.getAttribute("maSKU");
//                Integer soLuong = (Integer) session.getAttribute("soLuong");
//
//                if (maSKU == null || soLuong == null) {
//                        return "redirect:/sanpham";
//                }
//
//                BienThe bienThe = service_bienThe.getOne(maSKU);
//                if (bienThe == null) {
//                        return "redirect:/sanpham";
//                }
//
//                SanPham sanPham = service_sanPham.getOne(bienThe.getSanPham().getMaSanPham());
//
//
//                List<ThuocTinhBienThe> thuocTinhs = service_thuocTinhBienThe.findByMaSKU(maSKU);
//
//                model.addAttribute("soLuong", soLuong);
//                model.addAttribute("bienThe", bienThe);
//                model.addAttribute("sanPham", sanPham);
//                model.addAttribute("thuocTinhs", thuocTinhs);
//
//                return "donhang/thongtin";
//        }
//
//
//        @PostMapping("/dat")
//        public String datHang(@RequestParam("diaChi") String diaChi,
//                              @RequestParam("soDienThoai") String soDienThoai,
//                              @RequestParam("phuongThucThanhToan") String phuongThuc,
//                              @RequestParam("soLuong") int soLuong,
//                              HttpSession session) {
//
//                Users currentUser = (Users) session.getAttribute("currentUser");
//                if (currentUser == null) {
//                        return "redirect:/login";
//                }
//                String maSKU = (String) session.getAttribute("maSKU");
//                service_donHang.datHangDayDu(maSKU, soLuong, diaChi, soDienThoai, phuongThuc, currentUser.getId());
//
//                // Xoá dữ liệu tạm
//                session.removeAttribute("maSKU");
//                session.removeAttribute("soLuong");
//
//                return "redirect:/sanpham";
//        }




}
