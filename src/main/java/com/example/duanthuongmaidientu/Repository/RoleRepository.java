package com.example.duanthuongmaidientu.Repository;

import com.example.duanthuongmaidientu.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRoleName(String roleName);
}
