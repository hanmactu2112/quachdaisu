package ptit.suwoo.model.giohang;

import lombok.Data;
import ptit.suwoo.Dto.gioHangDTO.GioHangSanPhamDTO;
import ptit.suwoo.model.DienThoai;
import ptit.suwoo.model.SanPham;
import ptit.suwoo.model.hoadon.SanPhamHoaDon;
import ptit.suwoo.model.laptopmodel.Laptop;

import javax.persistence.*;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

@Data
@Entity
@Table(name = "giohangsp")
public class GioHangSanPham implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "giohang_id")
    private GioHang gioHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sanpham_id")
    private SanPham sanPham;

    @Column(name = "soluong")
    private int soLuong;

    @Column(name = "active")
    private boolean active;



    public GioHangSanPhamDTO convertToDto(){
        GioHangSanPhamDTO g = new GioHangSanPhamDTO();
        g.setId(this.getId());
        g.setGioHangDTO(this.gioHang.convertToDto1());
        g.setSanPhamDTO(this.sanPham.convertToDTOClient());
        g.setSoLuong(this.soLuong);
        double tong;
        if (this.sanPham.getKhuyenMai()!=null){
            tong = Math.round((this.sanPham.getGia()-this.sanPham.getGia()*(this.sanPham.getKhuyenMai().getTiLe()/100))*this.soLuong);
        }else {
            tong = this.sanPham.getGia()*this.soLuong;
        }
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String str1 = currencyVN.format(tong);
        g.setTongTien(str1);
        return g;
    }
    public SanPhamHoaDon convertToSPHD(){
        SanPhamHoaDon g = new SanPhamHoaDon();
        g.setSoLuong(this.soLuong);
        g.setMasp(this.sanPham.getMasp());
        g.setImages(this.sanPham.convertToDTOClient().getImageDto().get(0).getUrlImg());
        double tong;
        if (this.sanPham.getKhuyenMai()!=null){
            g.setGia(this.sanPham.getGia()-this.sanPham.getGia()*(this.sanPham.getKhuyenMai().getTiLe()/100));
            tong = Math.round((this.sanPham.getGia()-this.sanPham.getGia()*(this.sanPham.getKhuyenMai().getTiLe()/100))*this.soLuong);
        }else {
            g.setGia(this.sanPham.getGia());
            tong = this.sanPham.getGia()*this.soLuong;
        }
        g.setColor(this.sanPham.getColor());
        g.setHang(this.sanPham.getHang());
        g.setTenSp(this.sanPham.getTenSp());
        g.setTong(tong);
        return g;
    }
}
