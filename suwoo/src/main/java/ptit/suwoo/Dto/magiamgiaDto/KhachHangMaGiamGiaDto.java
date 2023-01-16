package ptit.suwoo.Dto.magiamgiaDto;

import lombok.Data;
import ptit.suwoo.Dto.KhachHangDto;
import ptit.suwoo.model.maGiamGia.KhachHangMaGiamGia;
import ptit.suwoo.model.maGiamGia.MaGiamGia;

@Data
public class KhachHangMaGiamGiaDto {

    private Long id;

    private KhachHangDto khachHangDto;

    private MaGiamGiaDto maGiamGiaDto;

    private boolean trangThai;

    public KhachHangMaGiamGia convertToEntity(){
        KhachHangMaGiamGia khachHangMaGiamGia = new KhachHangMaGiamGia();
        khachHangMaGiamGia.setId(this.id);
        khachHangMaGiamGia.setKhachHang(this.khachHangDto.convertToEntity());
        khachHangMaGiamGia.setMaGiamGia(this.maGiamGiaDto.convertToEntity());
        khachHangMaGiamGia.setTrangThai(this.trangThai);
        return khachHangMaGiamGia;
    }
}
