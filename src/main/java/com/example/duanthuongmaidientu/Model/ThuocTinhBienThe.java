package com.example.duanthuongmaidientu.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "ThuocTinhBienThe")
public class ThuocTinhBienThe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maThuocTinhBienThe;

    private String  tenThuocTinhBienThe;



    @ManyToOne
    @JoinColumn(name = "maThuocTinh")
    private ThuocTinh thuocTinh;
}
