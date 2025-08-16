package com.example.duanthuongmaidientu.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String passwords;

    private String email;



    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<DonHang> donHangs;

    @ManyToOne
    @JoinColumn(name = "roleID")
    private Role role;

}
