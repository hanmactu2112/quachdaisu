package ptit.suwoo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import ptit.suwoo.sanphamdto.ImageDto;
import ptit.suwoo.sanphamdto.SanPhamDto;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Data
@Entity
@NoArgsConstructor
@Table(name = "sanpham")
@Inheritance(strategy = InheritanceType.JOINED)
public class SanPham implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "masp",nullable = false,unique = true)
    private String masp;
    @Column(name = "tensp")
    private String tenSp;
    @Column(name = "gia")
    private Double gia;
    @Column(name = "sl")
    private int soLuong;
    @Column(name = "hang")
    private String hang;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "sanpham_id")
    private List<Image> images;
    @Column(name="color")
    private String color;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;
    @Column(name = "ngayramat")
    private String ngayRaMat;
    @Column(name = "chatlieu")
    private String chatLieu;
    @Column(name = "mota",length=1000)
    private String moTa;
    @Column(name = "active")
    private boolean active;
    @Column(name = "ngayDangSP")
    private Date ngayDangSP;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "khuyenmai_id",referencedColumnName = "id")
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
        if (this.khuyenMai!=null){
            float giaKm = Math.round((this.gia-this.gia*(this.khuyenMai.getTiLe()/100)));
            a.setGiaKm(currencyVN.format(giaKm));
        }
        a.setSoLuong(this.soLuong);
        List<ImageDto> ds = new ArrayList<>();
        if (this instanceof DienThoai){
            for (Image i:this.images){
                ImageDto img = i.convertToDtoDt();
                ds.add(img);
            }
        }
        else {
            for (Image i:this.images){
                ImageDto img = i.convertToDtoLt();
                ds.add(img);
            }
        }
        a.setImageDto(ds);
        a.setHang(this.hang);
        a.setCategoryDto(this.category.convertToDto());
        a.setColor(this.color);
        a.setNgayRaMat(this.ngayRaMat);
        a.setChatLieu(this.chatLieu);
        a.setMoTa(this.moTa);
        if (this.khuyenMai!=null) {
            a.setKhuyenMaiDto(this.khuyenMai.convertToDto());
        }
        a.setActive(this.active);
        return a;
    }
}
