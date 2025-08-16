package com.example.duanthuongmaidientu.Controller;

import com.example.duanthuongmaidientu.Model.BienThe;
import com.example.duanthuongmaidientu.Model.DanhMuc;
import com.example.duanthuongmaidientu.Model.SanPham;
import com.example.duanthuongmaidientu.Model.Users;
import com.example.duanthuongmaidientu.Service.Service_DanhMuc;
import com.example.duanthuongmaidientu.Service.Service_SanPham;
import com.example.duanthuongmaidientu.Service.Service_Users;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sanpham")
@RequiredArgsConstructor
public class Controller_SanPham {

    private final Service_SanPham serviceSanPham;
    private final Service_DanhMuc serviceDanhMuc;
    private final Service_DanhMuc service_danhMuc;
    /**
     * Danh sách sản phẩm: có hỗ trợ tìm kiếm + phân trang
     */
    @GetMapping
    public String listSanPham(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(required = false) String tenSanPham,
            HttpSession session,
            Model model) {
        Users user = (Users) session.getAttribute("currentUser");
        if (user != null) {
            model.addAttribute("fullname", user.getUsername()); // hoặc user.getFullname() nếu có
        } else {
            model.addAttribute("fullname", "Khách");
        }

        int size = 10;
        Page<SanPham> sanPhamPage;

        if (tenSanPham != null && !tenSanPham.trim().isEmpty()) {
            sanPhamPage = serviceSanPham.searchByTen(tenSanPham, PageRequest.of(page, size));
            model.addAttribute("searchMode", true);
            model.addAttribute("searchName", tenSanPham);
        } else {
            sanPhamPage = serviceSanPham.getAll(PageRequest.of(page, size));
            model.addAttribute("searchMode", false);
        }

        List<SanPham> sanPhamList = sanPhamPage.getContent();

        // Map<maSanPham, String>: mỗi sản phẩm 1 ảnh
        Map<Integer, String> imageMap = new HashMap<>();

        for (SanPham sp : sanPhamList) {
            Integer maSanPham = sp.getMaSanPham();

            List<BienThe> bienThes = sp.getBienThes(); // hoặc gọi từ service nếu cần
            if (bienThes != null && !bienThes.isEmpty()) {
                String maSKU = bienThes.get(0).getMaSKU(); // lấy biến thể đầu tiên
                String imagePath = "/images/" + maSanPham + "/" + "1.png";
                imageMap.put(maSanPham, imagePath);
            }
        }
        List<DanhMuc> danhMucList = service_danhMuc.getAll();
        model.addAttribute("danhMucList", danhMucList);



        model.addAttribute("sanpham", sanPhamPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", sanPhamPage.getTotalPages());
        model.addAttribute("imageMap", imageMap); // gửi map ảnh ra view


        return "sanpham/trangchu";
    }



//    @GetMapping
//    public String listSanPham(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(required = false) String tenSanPham,
//            HttpSession session,
//            Model model,
//            Authentication authentication) {
//
//        // Lấy user từ session
//        Users currentUser = (Users) session.getAttribute("currentUser");
//        model.addAttribute("fullname", currentUser != null ? currentUser.getUsername() : "Khách");
//
//        // Lấy thông tin đăng nhập (nếu có)
//        if (authentication != null) {
//            if (authentication instanceof OAuth2AuthenticationToken oauth2) {
//                OAuth2User oauthUser = oauth2.getPrincipal();
//                model.addAttribute("userEmail", oauthUser.getAttribute("email"));
//                model.addAttribute("userName", oauthUser.getAttribute("name"));
//            } else if (authentication.getPrincipal() instanceof UserDetails userDetails) {
//                model.addAttribute("userEmail", userDetails.getUsername());
//                model.addAttribute("userName", ""); // Có thể thay bằng tên thật nếu entity User có
//            }
//        }
//
//        int size = 10;
//        Page<SanPham> sanPhamPage;
//
//        if (tenSanPham != null && !tenSanPham.trim().isEmpty()) {
//            sanPhamPage = serviceSanPham.searchByTen(tenSanPham, PageRequest.of(page, size));
//            model.addAttribute("searchMode", true);
//            model.addAttribute("searchName", tenSanPham);
//        } else {
//            sanPhamPage = serviceSanPham.getAll(PageRequest.of(page, size));
//            model.addAttribute("searchMode", false);
//        }
//
//        // Tạo map ảnh cho sản phẩm
//        Map<Integer, String> imageMap = new HashMap<>();
//        for (SanPham sp : sanPhamPage.getContent()) {
//            List<BienThe> bienThes = sp.getBienThes();
//            if (bienThes != null && !bienThes.isEmpty()) {
//                String imagePath = "/images/" + sp.getMaSanPham() + "/1.png";
//                imageMap.put(sp.getMaSanPham(), imagePath);
//            }
//        }
//
//        // Lấy danh mục sản phẩm
//        List<DanhMuc> danhMucList = service_danhMuc.getAll();
//
//        // Truyền dữ liệu ra view
//        model.addAttribute("danhMucList", danhMucList);
//        model.addAttribute("sanpham", sanPhamPage.getContent());
//        model.addAttribute("currentPage", page);
//        model.addAttribute("totalPages", sanPhamPage.getTotalPages());
//        model.addAttribute("imageMap", imageMap);
//
//        return "sanpham/trangchu";
//    }



    /**
     * Hiển thị form thêm sản phẩm
     */
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("sanpham", new SanPham());
        model.addAttribute("danhmuc", serviceDanhMuc.getAll());
        return "sanpham/add";
    }

    /**
     * Xử lý thêm sản phẩm
     */
    @PostMapping("/add")
    public String addSubmit(@ModelAttribute("sanpham") SanPham sanPham) {
        serviceSanPham.save(sanPham);
        return "redirect:/sanpham";
    }

    /**
     * Hiển thị form cập nhật sản phẩm
     */
    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Integer id, Model model) {
        model.addAttribute("sanpham", serviceSanPham.getOne(id));
        model.addAttribute("danhmuc", serviceDanhMuc.getAll());
        return "sanpham/update";
    }

    /**
     * Xử lý cập nhật sản phẩm
     */
    @PostMapping("/update/{id}")
    public String updateSubmit(@PathVariable Integer id, @ModelAttribute SanPham sanPham) {
        sanPham.setMaSanPham(id);
        serviceSanPham.save(sanPham);
        return "redirect:/sanpham";
    }

    /**
     * Xóa sản phẩm
     */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        serviceSanPham.delete(id);
        return "redirect:/sanpham";
    }
}
