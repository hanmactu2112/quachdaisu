package ptit.suwoo.model.giohang;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import ptit.suwoo.Dto.gioHangDTO.GioHangSanPhamDTO;
import ptit.suwoo.model.KhachHang;
import ptit.suwoo.model.SanPham;
import ptit.suwoo.model.laptopmodel.Laptop;
import ptit.suwoo.sanphamRepository.DienThoaiRepository;
import ptit.suwoo.sanphamRepository.LaptopRepository;

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
        g.setGioHangDTO(this.gioHang.convertToDto());
        g.setSanPhamDTO(this.sanPham.convertToDTOClient());
        g.setSoLuong(this.soLuong);
        double tong = this.sanPham.getGia()*this.soLuong;
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String str1 = currencyVN.format(tong);
        g.setTongTien(str1);
        return g;
    }
}
