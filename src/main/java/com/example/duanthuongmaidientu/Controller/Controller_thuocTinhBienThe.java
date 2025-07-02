package com.example.duanthuongmaidientu.Controller;

import com.example.duanthuongmaidientu.Model.ThuocTinhBienThe;
import com.example.duanthuongmaidientu.Service.Service_ThuocTinhBienThe;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/thuoctinh")
public class Controller_thuocTinhBienThe {

    private final Service_ThuocTinhBienThe service_thuocTinhBienThe;

    @GetMapping
    public String getThuocTinhBySanPham(@RequestParam("sanphamId") Integer maSanPham, Model model) {
        List<ThuocTinhBienThe> list = service_thuocTinhBienThe.getByMaSanPham(maSanPham);

        // Danh sách ảnh riêng cho sản phẩm
        List<String> imageList = List.of(
                "/images/sanpham" + maSanPham + "_1.png",
                "/images/sanpham" + maSanPham + "_2.png",
                "/images/sanpham" + maSanPham + "_3.png",
                "/images/sanpham" + maSanPham + "_4.png"
        );

        model.addAttribute("thuocTinhs", list);
        model.addAttribute("imageList", imageList); // Gửi danh sách ảnh về view
        return "thuoctinh/trangchu";
    }



}
