package com.example.sd18307.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor// khong tham so
@AllArgsConstructor // co tham so
public class SinhVien {

    private String maSv;

    private String tenSv;

    private Integer tuoi;

    private String diaChi;


}
