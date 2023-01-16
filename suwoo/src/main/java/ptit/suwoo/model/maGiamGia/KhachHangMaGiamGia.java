package ptit.suwoo.model.maGiamGia;

import lombok.Data;
import ptit.suwoo.Dto.magiamgiaDto.KhachHangMaGiamGiaDto;
import ptit.suwoo.model.Category;
import ptit.suwoo.model.KhachHang;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "khachhang_magiamgia")
public class KhachHangMaGiamGia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "khachhang_id")
    private KhachHang khachHang;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "magiamgia_id")
    private MaGiamGia maGiamGia;

    @Column(name = "trangthai")
    private boolean trangThai;

    public KhachHangMaGiamGiaDto khachHangMaGiamGiaDto(){
        KhachHangMaGiamGiaDto khachHangMaGiamGiaDto = new KhachHangMaGiamGiaDto();
        khachHangMaGiamGiaDto.setId(this.id);
        khachHangMaGiamGiaDto.setKhachHangDto(this.khachHang.convertToDto());
        khachHangMaGiamGiaDto.setMaGiamGiaDto(this.maGiamGia.convertToDto());
        khachHangMaGiamGiaDto.setTrangThai(this.trangThai);
        return khachHangMaGiamGiaDto;
    }

}
