package ptit.suwoo.sanphamdto;

import lombok.Data;
import ptit.suwoo.model.KhuyenMai;

import javax.persistence.Column;
import java.sql.Date;

@Data
public class KhuyenMaiDto {
    private Long id;
    private String maKm;
    private String tiLe;
    private String ngayBd;
    private String ngayKt;
    private boolean trangThai;

    public KhuyenMai convertToEntity(){
        KhuyenMai khuyenMai = new KhuyenMai();
        khuyenMai.setId(this.id);
        khuyenMai.setMaKm(this.maKm);
        khuyenMai.setTiLe(Float.parseFloat(this.tiLe));
        khuyenMai.setNgayBd(Date.valueOf(this.ngayBd));
        khuyenMai.setNgayKt(Date.valueOf(this.ngayKt));
        khuyenMai.setTrangThai(this.trangThai);
        return khuyenMai;
    }

}
