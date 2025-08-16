package com.example.duanthuongmaidientu.Controller;

import com.example.duanthuongmaidientu.Model.Users;
import com.example.duanthuongmaidientu.Repository.Repository_Users;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
@RequestMapping("/login")
public class Controller_login {
    private final Repository_Users repository_users;

    // Hiển thị trang login
    @GetMapping
    public String showLoginForm() {
        return "login/trangchu";  // Tên file HTML: login.html
    }

    // Xử lý đăng nhập
    @PostMapping
    public String doLogin(@RequestParam String username,
                          @RequestParam String password,
                          HttpSession session) {
        Users user = repository_users.findByUsername(username);

        if (user != null && user.getPasswords().equals(password)) {
            session.setAttribute("userId", user.getId());
            session.setAttribute("currentUser", user); // ⚠️ BẮT BUỘC PHẢI CÓ
            return "redirect:/sanpham";
        }

        return "redirect:/login";
    }

//    @GetMapping("/403")
//    public String accessDenied() {
//        return "sanpham/403";
//    }

}



