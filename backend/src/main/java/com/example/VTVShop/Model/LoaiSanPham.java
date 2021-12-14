package com.example.VTVShop.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table
public class LoaiSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int loaiSanPhamId;

    @Column
    @Size(max= 40, message = "Loại sản phẩm không quá 40 ký tự")
    private  String loaiSanPham;

    @OneToMany(mappedBy = "loaiSanPham")
    @JsonIgnoreProperties(value = "loaiSanPham")
    private List<SanPham> sanPhams;

    public int getLoaiSanPhamId() {
        return loaiSanPhamId;
    }

    public void setLoaiSanPhamId(int loaiSanPhamId) {
        this.loaiSanPhamId = loaiSanPhamId;
    }

    public String getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(String loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

    public List<SanPham> getSanPhams() {
        return sanPhams;
    }

    public void setSanPhams(List<SanPham> sanPhams) {
        this.sanPhams = sanPhams;
    }
}
