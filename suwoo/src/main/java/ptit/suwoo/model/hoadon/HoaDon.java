package ptit.suwoo.model.hoadon;

import lombok.Data;
import ptit.suwoo.Dto.hoadondto.HoaDonDTO;
import ptit.suwoo.Dto.hoadondto.SanPhamHoaDonDTO;
import ptit.suwoo.model.KhachHang;
import ptit.suwoo.model.maGiamGia.MaGiamGia;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Data
@Entity
@Table(name = "hoadon")
public class HoaDon implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nguoinhan")
    private String nguoiNhan;
    @Column(name = "sdt")
    private String sdt;
    @Column(name = "email")
    private String email;
    @Column(name = "diachi")
    private String diaChi;
    @Column(name = "shipping")
    private String shipping;
    @Column(name = "ghichu",length = 500)
    private String ghiChu;
    @Column(name = "xuathd")
    private boolean xuatHD;
    @Column(name ="ngayTao")
    private Date ngayTao;
    @Column(name ="tinhtrang")
    private String tinhTrang;
    @ManyToOne
    @JoinColumn(name = "khachhang_id")
    private KhachHang khachHang;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "magiamgia_id")
    private MaGiamGia maGiamGia;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "hoadon_id")
    private List<SanPhamHoaDon> sanPhamHoaDons;

    public HoaDonDTO convertToDTO(){
        HoaDonDTO h = new HoaDonDTO();
        h.setId(this.id);
        h.setNguoiNhan(this.nguoiNhan);
        h.setSdt(this.sdt);
        h.setEmail(this.email);
        h.setDiaChi(this.diaChi);
        h.setShipping(this.shipping);
        h.setGhiChu(this.ghiChu);
        h.setXuatHD(this.xuatHD);
        h.setNgayTao(this.ngayTao);
        h.setTinhTrang(this.tinhTrang);
        if (this.maGiamGia!=null){
            h.setMaGiamGiaDto(this.maGiamGia.convertToDtoView());
        }
        List<SanPhamHoaDonDTO> list = new ArrayList<>();
        double tongTien = 0.0;
        for(SanPhamHoaDon e:this.sanPhamHoaDons){
            list.add(e.convertToDTO());
            tongTien+=e.getTong();
        }
        Locale locale = new Locale("vi","VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        h.setTongtien(numberFormat.format(tongTien));
        h.setSanPhamHoaDons(list);
        return h;
    }
}
