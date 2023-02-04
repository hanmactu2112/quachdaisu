package ptit.suwoo.model.giohang;

import lombok.Data;
import ptit.suwoo.Dto.gioHangDTO.GioHangDTO;
import ptit.suwoo.Dto.gioHangDTO.GioHangSanPhamDTO;
import ptit.suwoo.model.KhachHang;
import ptit.suwoo.model.maGiamGia.KhachHangMaGiamGia;

import javax.persistence.*;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Data
@Entity
@Table(name="giohang")
public class GioHang implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "khachhang_id",unique = true)
    private KhachHang khachHang;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "giohang_id")
    private List<GioHangSanPham> gioHangSanPhams;

    public GioHangDTO convertToDto(){
        GioHangDTO g = new GioHangDTO();
        g.setId(this.getId());
        g.setKhachHangDTO(this.khachHang.convertToDto());
        List<GioHangSanPhamDTO>gioHangSanPhamDTOS = new ArrayList<>();
        double tongTien = 0.0;
        for (GioHangSanPham a: this.gioHangSanPhams){
            if (a.getSanPham().getKhuyenMai()!=null){
                tongTien += Math.round((a.getSanPham().getGia()-a.getSanPham().getGia()*(a.getSanPham().getKhuyenMai().getTiLe()/100))*a.getSoLuong());
            }else {
                tongTien += Math.round(a.getSanPham().getGia()*a.getSoLuong());
            }
            gioHangSanPhamDTOS.add(a.convertToDto());
        }
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String str1 = currencyVN.format(tongTien);
        g.setTongTien(str1);
        g.setGioHangSanPhamDTOS(gioHangSanPhamDTOS);
        return g;
    }
    public GioHangDTO convertToDto(KhachHangMaGiamGia khmgg){
        GioHangDTO g = new GioHangDTO();
        g.setId(this.getId());
        g.setKhachHangDTO(this.khachHang.convertToDto());
        List<GioHangSanPhamDTO>gioHangSanPhamDTOS = new ArrayList<>();
        double tongTien = 0.0;
        for (GioHangSanPham a: this.gioHangSanPhams){
            if (a.getSanPham().getKhuyenMai()!=null){
                tongTien += Math.round((a.getSanPham().getGia()-a.getSanPham().getGia()*(a.getSanPham().getKhuyenMai().getTiLe()/100))*a.getSoLuong());
            }else {
                tongTien += Math.round(a.getSanPham().getGia()*a.getSoLuong());
            }
            gioHangSanPhamDTOS.add(a.convertToDto());
        }
        double tientru = khmgg.getMaGiamGia().getGiamToiDa();

        tientru = Math.min(tientru,tongTien*(khmgg.getMaGiamGia().getGiaTri()/100));
        double tongcong = tongTien - tientru;
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String str1 = currencyVN.format(tongTien);
        String str2 = currencyVN.format(tongcong);
        g.setTongTien(str1);
        g.setTongCong(str2);
        g.setGioHangSanPhamDTOS(gioHangSanPhamDTOS);
        return g;
    }
    public GioHangDTO convertToDto1(){
        GioHangDTO g = new GioHangDTO();
        g.setId(this.getId());
        g.setKhachHangDTO(this.khachHang.convertToDto());
        return g;
    }
}
