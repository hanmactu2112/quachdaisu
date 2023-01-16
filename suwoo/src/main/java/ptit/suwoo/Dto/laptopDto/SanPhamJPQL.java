package ptit.suwoo.Dto.laptopDto;

import lombok.Data;
import ptit.suwoo.model.Category;
import ptit.suwoo.model.Image;
import ptit.suwoo.model.KhuyenMai;
import ptit.suwoo.sanphamdto.ImageDto;
import ptit.suwoo.sanphamdto.SanPhamDto;

import javax.persistence.*;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Data
public class SanPhamJPQL {
    private long id;
    private String masp;
    private String tenSp;
    private Double gia;
    private int soLuong;
    private String hang;
    private List<Image> images;
    @Column(name="color")
    private String color;
    private Category category;
    private String ngayRaMat;
    private String chatLieu;
    private String moTa;
    private boolean active;
    private Date ngayDangSP;
    private KhuyenMai khuyenMai;

    public SanPhamDto convertToDTOClient(){
        SanPhamDto a = new SanPhamDto();
        a.setId(this.id);
        a.setMaSp(this.masp);
        a.setTen(this.tenSp);
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String str1 = currencyVN.format(this.gia);
        a.setGia(str1);
        float giaKm = Math.round((this.gia-this.gia*(this.khuyenMai.getTiLe())));
        a.setGiaKm(currencyVN.format(giaKm));
        a.setSoLuong(this.soLuong);
        List<ImageDto> ds = new ArrayList<>();
        for (Image i:this.images){
            ImageDto img = i.convertToDto();
            ds.add(img);
        }
        a.setImageDto(ds);
        a.setHang(this.hang);
        a.setCategoryDto(this.category.convertToDto());
        a.setColor(this.color);
        a.setNgayRaMat(this.ngayRaMat);
        a.setChatLieu(this.chatLieu);
        a.setMoTa(this.moTa);
        a.setKhuyenMaiDto(this.khuyenMai.convertToDto());
        a.setActive(this.active);
        return a;
    }
}
