package com.example.duanthuongmaidientu.Controller;

import com.example.duanthuongmaidientu.Model.DanhMuc;
import com.example.duanthuongmaidientu.Model.SanPham;
import com.example.duanthuongmaidientu.Model.Users;
import com.example.duanthuongmaidientu.Repository.Repository_DanhMuc;
import com.example.duanthuongmaidientu.Repository.Repository_Users;
import com.example.duanthuongmaidientu.Service.Service_SanPham;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/nguoiban")
@RequiredArgsConstructor
public class Controller_NguoiBan {


    private  final Service_SanPham sanPhamService;
    @Autowired
    private Repository_DanhMuc danhMucRepository;

    @Autowired
    private Repository_Users usersRepository;


    @GetMapping
    public String hienThiDanhSachSanPham(
            Model model,
            HttpSession session,
            @RequestParam(defaultValue = "0") int page // trang hiện tại
    ) {
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }

        int size = 9; // số sản phẩm mỗi trang
        Pageable pageable = PageRequest.of(page, size);
        Page<SanPham> danhSachPage = sanPhamService.getSanPhamByUserId(userId, pageable);

        model.addAttribute("sanPhams", danhSachPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", danhSachPage.getTotalPages());
        List<DanhMuc> listDanhMuc = danhMucRepository.findAll();
        model.addAttribute("listDanhMuc", listDanhMuc);
        // Thêm các dữ liệu khác nếu cần cho trang

        return "nguoiban/trangchu";
    }


    @GetMapping("/loc")
    public String hienThiDanhSachSanPhamNgungBan(
            Model model,
            HttpSession session,
            @RequestParam(defaultValue = "0") int page // trang hiện tại
    ) {
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }

        int size = 9; // số sản phẩm mỗi trang
        Pageable pageable = PageRequest.of(page, size);
        Page<SanPham> danhSachPage = sanPhamService.getSanPhamByUserIdLoc(userId, pageable);

        model.addAttribute("sanPhams", danhSachPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", danhSachPage.getTotalPages());
        List<DanhMuc> listDanhMuc = danhMucRepository.findAll();
        model.addAttribute("listDanhMuc", listDanhMuc);
        // Thêm các dữ liệu khác nếu cần cho trang

        return "nguoiban/trangchu";
    }


    @PostMapping("/add")
    public String addSanPham(@RequestParam String tenSanPham,
                             @RequestParam String moTa,
                             @RequestParam String thuongHieu,
                             @RequestParam Integer maDanhMuc,
                             HttpSession session) {

        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }

        SanPham sp = new SanPham();
        sp.setTenSanPham(tenSanPham);
        sp.setMoTa(moTa);
        sp.setThuongHieu(thuongHieu);
        sp.setTrangThai(1); // mặc định trạng thái = 1

        // Gán danh mục
        DanhMuc danhMuc = danhMucRepository.findById(maDanhMuc)
                .orElseThrow(() -> new RuntimeException("Danh mục không tồn tại"));
        sp.setDanhMuc(danhMuc);

        // Gán user từ session
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User không tồn tại"));
        sp.setUser(user);

        sanPhamService.save(sp);

        return "redirect:/nguoiban";
    }



}
