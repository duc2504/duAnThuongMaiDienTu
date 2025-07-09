package com.example.duanthuongmaidientu.Controller;

import com.example.duanthuongmaidientu.Model.SanPham;
import com.example.duanthuongmaidientu.Service.Service_DanhMuc;
import com.example.duanthuongmaidientu.Service.Service_SanPham;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sanpham")
@RequiredArgsConstructor
public class Controller_SanPham {

    private final Service_SanPham serviceSanPham;
    private final Service_DanhMuc serviceDanhMuc;

    /**
     * Danh sách sản phẩm: có hỗ trợ tìm kiếm + phân trang
     */
    @GetMapping
    public String listSanPham(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(required = false) String tenSanPham,
            Model model) {

        int size = 5;
        Page<SanPham> sanPhamPage;

        if (tenSanPham != null && !tenSanPham.trim().isEmpty()) {
            sanPhamPage = serviceSanPham.searchByTen(tenSanPham, PageRequest.of(page, size));
            model.addAttribute("searchMode", true);
            model.addAttribute("searchName", tenSanPham);
        } else {
            sanPhamPage = serviceSanPham.getAll(PageRequest.of(page, size));
            model.addAttribute("searchMode", false);
        }

        model.addAttribute("sanpham", sanPhamPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", sanPhamPage.getTotalPages());

        return "sanpham/trangchu";
    }


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
