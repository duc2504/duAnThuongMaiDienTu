package com.example.duanthuongmaidientu.Controller;

        import com.example.duanthuongmaidientu.Model.BienThe;
        import com.example.duanthuongmaidientu.Model.SanPham;
        import com.example.duanthuongmaidientu.Model.ThuocTinh;
        import com.example.duanthuongmaidientu.Model.ThuocTinhBienThe;
        import com.example.duanthuongmaidientu.Service.Service_BienThe;
        import com.example.duanthuongmaidientu.Service.Service_SanPham;
        import com.example.duanthuongmaidientu.Service.Service_ThuocTinh;
        import com.example.duanthuongmaidientu.Service.Service_ThuocTinhBienThe;
        import lombok.RequiredArgsConstructor;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestParam;

        import java.util.ArrayList;
        import java.util.LinkedHashMap;
        import java.util.List;
        import java.util.Map;
        import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
@RequestMapping("/thuoctinh")
public class Controller_thuocTinhBienThe {

    private final Service_ThuocTinhBienThe service_thuocTinhBienThe;
    private final Service_SanPham service_sanPham;


    private final Service_BienThe service_bienThe ;
    private final Service_ThuocTinh service_thuocTinh ;



    @GetMapping("/{maSanPham}")
    public String getThuocTinhBySanPham(@PathVariable("maSanPham") Integer maSanPham, Model model) {

        List<String> imageList = List.of(
                "/images/sanpham" + maSanPham + "_1.png",
                "/images/sanpham" + maSanPham + "_2.png",
                "/images/sanpham" + maSanPham + "_3.png",
                "/images/sanpham" + maSanPham + "_4.png"
        );
        model.addAttribute("imageList", imageList);

        List<ThuocTinh> list = service_thuocTinh.getThuocTinhBySanPham(maSanPham);

        Map<String, List<String>> grouped = new LinkedHashMap<>();

        for (ThuocTinh tt : list) {
            String key = tt.getTenThuocTinh();

            // ✅ Danh sách biến thể con có thể addAll
            List<String> values = tt.getThuocTinhBienTheList()
                    .stream()
                    .map(ThuocTinhBienThe::getTenThuocTinhBienThe)
                    .collect(Collectors.toCollection(ArrayList::new));

            grouped.merge(key, values, (oldList, newList) -> {
                oldList.addAll(newList);
                return oldList;
            });
        }

//        Gia san pham

        SanPham sanPham = service_sanPham.getOne(maSanPham);
        model.addAttribute("sanPham", sanPham);
        // Lấy danh sách biến thể
        List<BienThe> bienTheList = service_bienThe.getBienTheBySanPham(maSanPham);
        model.addAttribute("bienTheList", bienTheList);
        model.addAttribute("groupedThuocTinh", grouped);

        return "thuoctinh/trangchu";
    }




}
