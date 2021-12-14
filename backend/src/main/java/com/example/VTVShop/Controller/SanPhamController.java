package com.example.VTVShop.Controller;


import com.example.VTVShop.Model.LoaiSanPham;
import com.example.VTVShop.Model.SanPham;
import com.example.VTVShop.Repository.LoaiSanPhamRepository;
import com.example.VTVShop.Repository.SanPhamRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@RestController
@RequestMapping(value = "/sanPham")
public class SanPhamController  {
    @Autowired
    SanPhamRepository sanPhamRepository;

    @Autowired
    LoaiSanPhamRepository loaiSanPhamRepository;



    @CrossOrigin
    @GetMapping(value = "/dsSanPham", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SanPham> getSanPham() {
        return sanPhamRepository.findAll();
    }
    @CrossOrigin
    @PostMapping(value = "/themSanPham")
    public ResponseEntity<String> ThemSanPham(@RequestBody String sanPham) {
        Gson gson= new Gson();
        SanPham sanPhamMoi= gson.fromJson(sanPham, SanPham.class);

        ValidatorFactory valFac=Validation.buildDefaultValidatorFactory();
        Validator val=valFac.getValidator();
        Set<ConstraintViolation<SanPham>> validations=val.validate(sanPhamMoi);
        for(ConstraintViolation<SanPham> validation : validations)	{
            System.out.println(validation.getMessage());
        }

        Optional<LoaiSanPham> op= Optional.empty();
        if(validations.size()==0 &&loaiSanPhamRepository.findById(sanPhamMoi.getLoaiSanPham().getLoaiSanPhamId()) !=op )   {
            sanPhamRepository.save(sanPhamMoi);
            return new ResponseEntity<>(
                    "Thêm sản phẩm thành công",
                    HttpStatus.OK);
        }

        return new ResponseEntity<>(
                "Thêm sản phẩm thất bại",
                HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin
    @PutMapping(value = "/suaSanPham")
    public  ResponseEntity<String> SuaSanPham(@RequestBody String sanPham)  {
        Gson gson= new Gson();
        SanPham sanPhamMoi= gson.fromJson(sanPham, SanPham.class);
        SanPham sanPhamCurrent= sanPhamRepository.findById(sanPhamMoi.getSanPhamId()).get();

        if(sanPhamCurrent == null)  {
            return new ResponseEntity<>(
                    "Sản phẩm trống",
                    HttpStatus.BAD_REQUEST);
        }
        else {
            sanPhamCurrent.setTenSanPham(sanPhamMoi.getTenSanPham());
            sanPhamCurrent.setHinhAnh(sanPhamMoi.getHinhAnh());
            sanPhamCurrent.setMoTa(sanPhamMoi.getMoTa());
            sanPhamCurrent.setGiaSanPham(sanPhamMoi.getGiaSanPham());
            sanPhamCurrent.setSoLuong(sanPhamMoi.getSoLuong());
            int loaiSp= sanPhamMoi.getLoaiSanPham().getLoaiSanPhamId();
            sanPhamCurrent.getLoaiSanPham().setLoaiSanPhamId(loaiSp);


            ValidatorFactory valFac=Validation.buildDefaultValidatorFactory();
            Validator val=valFac.getValidator();
            Set<ConstraintViolation<SanPham>> validations=val.validate(sanPhamMoi);
            for(ConstraintViolation<SanPham> validation : validations)	{
                System.out.println(validation.getMessage());
            }

            Optional<LoaiSanPham> op= Optional.empty();
            if(validations.size()==0 &&loaiSanPhamRepository.findById(sanPhamMoi.getLoaiSanPham().getLoaiSanPhamId()) !=op )   {
                sanPhamRepository.save(sanPhamCurrent);
                return new ResponseEntity<>(
                        "Sửa sản phẩm thành công",
                        HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(
                "Sửa sản phẩm thất bại",
                HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin
    @DeleteMapping(value = "/xoaSanPham")
    public  ResponseEntity<String> XoaSanPham(@RequestParam int sanPhamId) {
        Optional<SanPham> op= Optional.empty();
        SanPham sanPham= sanPhamRepository.findById(sanPhamId).get();

        if(sanPhamRepository.findById(sanPhamId)==op) {
            return new ResponseEntity<>(
                    "Sản phảm không tồn tại",
                    HttpStatus.BAD_REQUEST);
        }
        else
        {
            sanPhamRepository.delete(sanPham);
            return new ResponseEntity<>(
                    "Xóa sản phẩm thành công",
                    HttpStatus.OK);
        }
    }
    @CrossOrigin
    @GetMapping(value = "/chitietSanPham", produces = MediaType.APPLICATION_JSON_VALUE)
    public SanPham TimKiemSp(@RequestParam int maSp)	{
        return  sanPhamRepository.findById(maSp).get();
    }



}


