// Controller: Controller_thuocTinhBienThe.java
package com.example.duanthuongmaidientu.Controller;

import com.example.duanthuongmaidientu.Model.*;
import com.example.duanthuongmaidientu.Service.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/thuoctinh")
@RequiredArgsConstructor
public class Controller_thuocTinhBienThe {

    private final Service_ThuocTinh service_thuocTinh;
    private final Service_SanPham service_sanPham;
    private final Service_BienThe service_bienThe;

    @GetMapping("/{maSanPham}")
    public String getThuocTinhBySanPham(@PathVariable("maSanPham") Integer maSanPham, Model model) {
        // Image giả định
        List<String> imageList = List.of(
                "/images/sanpham" + maSanPham + "_1.png",
                "/images/sanpham" + maSanPham + "_2.png",
                "/images/sanpham" + maSanPham + "_3.png",
                "/images/sanpham" + maSanPham + "_4.png",
                "/images/sanpham" + maSanPham + "_5.png"
        );
        model.addAttribute("imageList", imageList);
        SanPham sanPhamName = service_sanPham.getOne(maSanPham) ;
        model.addAttribute("nameSP" , sanPhamName);
        // Group thuộc tính theo key
        List<ThuocTinh> thuocTinhList = service_thuocTinh.getThuocTinhBySanPham(maSanPham);
        Map<String, Set<String>> grouped = new LinkedHashMap<>();
        for (ThuocTinh tt : thuocTinhList) {
            grouped.computeIfAbsent(tt.getTenThuocTinh(), k -> new LinkedHashSet<>())
                    .addAll(tt.getThuocTinhBienTheList().stream()
                            .map(ThuocTinhBienThe::getTenThuocTinhBienThe).collect(Collectors.toSet()));
        }
        model.addAttribute("groupedThuocTinh", grouped);

        // Lấy sản phẩm + biến thể
        SanPham sanPham = service_sanPham.getOne(maSanPham);
        List<BienThe> bienTheList = service_bienThe.getBienTheBySanPham(maSanPham);

        List<BienTheDTO> dtoList = new ArrayList<>();
        for (BienThe bt : bienTheList) {
            BienTheDTO dto = new BienTheDTO();
            dto.setMaSKU(bt.getMaSKU());
            dto.setGia(bt.getGia());

            Map<String, String> map = new LinkedHashMap<>();
            for (ThuocTinh tt : bt.getThuocTinhs()) {
                for (ThuocTinhBienThe ttb : tt.getThuocTinhBienTheList()) {
                    map.put(tt.getTenThuocTinh(), ttb.getTenThuocTinhBienThe());
                }
            }
            dto.setThuocTinh(map);
            dtoList.add(dto);
        }

        model.addAttribute("sanPham", sanPham);
        model.addAttribute("bienTheList", dtoList);

        return "thuoctinh/trangchu";
    }

    @Data
    public static class BienTheDTO {
        private String maSKU;
        private java.math.BigDecimal gia;
        private Map<String, String> thuocTinh;
    }
}