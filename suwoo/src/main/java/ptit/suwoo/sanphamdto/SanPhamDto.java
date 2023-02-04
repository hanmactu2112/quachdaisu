package ptit.suwoo.sanphamdto;

import lombok.Data;
import ptit.suwoo.model.Image;
import ptit.suwoo.model.SanPham;

import java.util.ArrayList;
import java.util.List;

@Data
public class SanPhamDto {
    private Long id;
    private String maSp;
    private String ten;
    private String gia;

    private String giaKm;
    private int soLuong;
    private List<ImageDto> imageDto;
    private String hang;
    private CategoryDto categoryDto;
    private String color;
    private String ngayRaMat;
    private String chatLieu;
    private String moTa;
    private KhuyenMaiDto khuyenMaiDto;
    private boolean active;

    public SanPham convertToEntity(){
        SanPham a = new SanPham();
        a.setId(this.id);
        a.setMasp(this.maSp);
        a.setTenSp(this.ten);
        a.setGia(Double.parseDouble(this.gia));
        a.setSoLuong(this.soLuong);
        List<Image> ds = new ArrayList<>();
        for (ImageDto i:this.imageDto){
            Image img = i.convertToEntity();
            ds.add(img);
        }
        a.setImages(ds);
        a.setHang(this.hang);
        a.setCategory(this.categoryDto.convertToEntity());
        a.setColor(this.color);
        a.setNgayRaMat(this.ngayRaMat);
        a.setChatLieu(this.chatLieu);
        a.setMoTa(this.moTa);
        a.setKhuyenMai(this.khuyenMaiDto.convertToEntity());
        a.setActive(this.active);
        return a;
    }

}
