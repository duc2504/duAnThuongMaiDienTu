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

@RequiredArgsConstructor
@Controller
@RequestMapping("/sanpham")
public class Controller_SanPham {
    private final Service_SanPham serviceSanPham;
    private final Service_DanhMuc serviceDanhMuc;

    @GetMapping
    public String list(@RequestParam(defaultValue = "0") int page, Model model) {
        int size = 5;
        Page<SanPham> sanPhamPage = serviceSanPham.getAll(PageRequest.of(page, size));
        model.addAttribute("sanpham", sanPhamPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", sanPhamPage.getTotalPages());
        return "sanpham/trangchu";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("sanpham", new SanPham());
        model.addAttribute("danhmuc", serviceDanhMuc.getAll());
        return "sanpham/add";
    }

    @PostMapping("/add")
    public String addSubmit(@ModelAttribute("sanpham") SanPham sanPham) {
        serviceSanPham.save(sanPham);
        return "redirect:/sanpham";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Integer id, Model model) {
        model.addAttribute("sanpham", serviceSanPham.getOne(id));
        model.addAttribute("danhmuc", serviceDanhMuc.getAll());
        return "sanpham/update";
    }

    @PostMapping("/update/{id}")
    public String updateSubmit(@PathVariable Integer id, @ModelAttribute SanPham sanPham) {
        sanPham.setMaSanPham(id);
        serviceSanPham.save(sanPham);
        return "redirect:/sanpham";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        serviceSanPham.delete(id);
        return "redirect:/sanpham";
    }

    @GetMapping("/search")
    public String search(@RequestParam("tenSanPham") String tenSanPham, Model model) {
        model.addAttribute("sanpham", serviceSanPham.searchByTen(tenSanPham));
        model.addAttribute("searchMode", true);
        model.addAttribute("searchName", tenSanPham);
        return "sanpham/trangchu";
    }
}
