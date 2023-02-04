package ptit.suwoo.model.hoadon;

import lombok.Data;
import lombok.NoArgsConstructor;
import ptit.suwoo.Dto.hoadondto.SanPhamHoaDonDTO;
import ptit.suwoo.model.Category;
import ptit.suwoo.model.Image;
import ptit.suwoo.model.KhuyenMai;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;


@Data
@Entity
@Table(name = "sanphamhd")
public class SanPhamHoaDon implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @Column(name = "masp")
    private String masp;
    @Column(name = "tensp")
    private String tenSp;
    @Column(name = "gia")
    private Double gia;
    @Column(name = "sl")
    private int soLuong;
    @Column(name = "hang")
    private String hang;
    @Column(name = "urlimg")
    private String images;
    @Column(name="color")
    private String color;
    @Column(name="tong")
    private Double tong;
    @ManyToOne
    @JoinColumn(name = "hoadon_id")
    private HoaDon hoaDon;

    public SanPhamHoaDonDTO convertToDTO(){
        SanPhamHoaDonDTO s = new SanPhamHoaDonDTO();
        s.setId(this.id);
        s.setMasp(this.masp);
        s.setTenSp(this.tenSp);
        Locale locale = new Locale("vi","VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        String str = numberFormat.format(this.gia);
        s.setGia(str);
        s.setSoLuong(this.soLuong);
        s.setHang(this.hang);
        s.setImages(this.images);
        s.setColor(this.color);
        s.setTong(numberFormat.format(this.tong));
        return s;
    }
}
