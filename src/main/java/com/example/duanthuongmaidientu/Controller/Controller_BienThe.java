package com.example.duanthuongmaidientu.Controller;

import com.example.duanthuongmaidientu.Model.BienThe;
import com.example.duanthuongmaidientu.Model.SanPham;
import com.example.duanthuongmaidientu.Model.ThuocTinh;
import com.example.duanthuongmaidientu.Service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/thuoctinh")
@RequiredArgsConstructor
public class Controller_BienThe {

    private final Service_ThuocTinh service_thuocTinh;
    private final Service_SanPham service_sanPham;
    private final Service_BienThe service_bienThe;

    @GetMapping("/{maSanPham}")
    public String getChiTietSanPham(@PathVariable("maSanPham") Integer maSanPham, Model model) {
        // Lấy sản phẩm và danh sách biến thể
        SanPham sanPham = service_sanPham.getOne(maSanPham);
        List<BienThe> bienThes = service_bienThe.findBySanPham_MaSanPham(maSanPham);

        // Tạo Map: <Tên thuộc tính, Set giá trị không trùng>
        Map<String, Set<String>> thuocTinhMap = new LinkedHashMap<>();
        for (BienThe bt : bienThes) {
            for (ThuocTinh tt : bt.getThuocTinhs()) {
                thuocTinhMap
                        .computeIfAbsent(tt.getTenThuocTinh(), k -> new LinkedHashSet<>())
                        .add(tt.getTenThuocTinhBienThe());
            }
        }
        List<String> imageList = bienThes.stream()
                .map(BienThe::getMaSKU)
                .map(maSKU -> "/images/" + maSanPham + "/" + maSKU + "-1.png")
                .collect(Collectors.toList());


//        List<String> imageList = bienThes.stream()
//                .map(BienThe::getMaSKU)
//                .map(maSKU -> List.of(
//                        "/images/" + maSanPham + "/" + maSKU + "-1.png",
//                        "/images/" + maSanPham + "/" + maSKU + "-2.png"
//                ))
//                .flatMap(List::stream) // chuyển List<List<String>> thành List<String>
//                .collect(Collectors.toList());

        model.addAttribute("imageList", imageList);


        // Gửi dữ liệu ra view
        model.addAttribute("sanPham", sanPham);
        model.addAttribute("bienThes", bienThes); // để JS xử lý logic SKU
        model.addAttribute("thuocTinhMap", thuocTinhMap); // dùng để render thuộc tính không trùng
        return "thuoctinh/trangchu";
    }
}
