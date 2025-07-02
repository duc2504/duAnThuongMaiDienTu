package com.example.duanthuongmaidientu.Repository;

import com.example.duanthuongmaidientu.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository_Users extends JpaRepository<Users, Integer> {
    // Bạn có thể thêm các hàm tìm kiếm tùy chỉnh ở đây nếu cần
    Users findByUsername(String username);


}
