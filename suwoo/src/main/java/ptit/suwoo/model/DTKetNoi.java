package ptit.suwoo.model;

import lombok.Data;
import ptit.suwoo.sanphamdto.DTKetNoiDto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "dtketnoi")
public class DTKetNoi implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "mangdidong")
    private String mangDiDong;
    @Column(name = "wifi")
    private String wifi;
    @Column(name = "gps")
    private String gps;
    @Column(name = "bluetooth")
    private String bluetooth;
    @Column(name = "congsac")
    private String congSac;
    @Column(name = "tainghe")
    private String taiNghe;
    @Column(name = "ketnoikhac")
    private String ketNoiKhac;

    public DTKetNoiDto convertToDto(){
        DTKetNoiDto d = new DTKetNoiDto();
        d.setId(this.id);
        d.setMangDiDong(this.mangDiDong);
        d.setWifi(this.wifi);
        d.setGps(this.gps);
        d.setBluetooth(this.bluetooth);
        d.setCongSac(this.congSac);
        d.setTaiNghe(this.taiNghe);
        d.setKetNoiKhac(this.ketNoiKhac);
        return d;
    }
}
