package ptit.suwoo.model.giohang;

import lombok.Data;
import ptit.suwoo.Dto.gioHangDTO.GioHangDTO;
import ptit.suwoo.model.KhachHang;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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
        return g;
    }
}
