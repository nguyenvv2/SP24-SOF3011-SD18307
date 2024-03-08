package com.example.sd18307.model;

public class SinhVien {

    private String maSv;

    private String tenSv;

    private Integer tuoi;

    private String diaChi;

    public SinhVien() {
    }

    public SinhVien(String maSv, String tenSv, Integer tuoi, String diaChi) {
        this.maSv = maSv;
        this.tenSv = tenSv;
        this.tuoi = tuoi;
        this.diaChi = diaChi;
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getTenSv() {
        return tenSv;
    }

    public void setTenSv(String tenSv) {
        this.tenSv = tenSv;
    }

    public Integer getTuoi() {
        return tuoi;
    }

    public void setTuoi(Integer tuoi) {
        this.tuoi = tuoi;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
