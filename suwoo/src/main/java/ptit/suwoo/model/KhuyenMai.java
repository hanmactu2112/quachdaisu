package ptit.suwoo.model;

import lombok.Data;
import ptit.suwoo.sanphamdto.KhuyenMaiDto;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
@Table(name = "khuyenmai")
public class KhuyenMai implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "makm")
    private String maKm;
    @Column(name = "tile")
    private float tiLe;
    @Column(name = "ngaybd")
    private Date ngayBd;
    @Column(name = "ngaykt")
    private Date ngayKt;
    @Column(name = "trangthai")
    private boolean trangThai;

    public KhuyenMaiDto convertToDto(){
        KhuyenMaiDto khuyenMaiDto = new KhuyenMaiDto();
        khuyenMaiDto.setId(this.id);
        khuyenMaiDto.setMaKm(this.maKm);
        khuyenMaiDto.setTiLe(String.valueOf(Math.round(this.tiLe))+"%");
        khuyenMaiDto.setNgayBd(this.ngayBd.toString());
        khuyenMaiDto.setNgayKt(this.ngayKt.toString());
        khuyenMaiDto.setTrangThai(this.trangThai);
        return khuyenMaiDto;
    }
}
