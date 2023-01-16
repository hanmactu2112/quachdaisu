package ptit.suwoo.model;

import lombok.Data;
import ptit.suwoo.sanphamdto.ManHinhDto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "manhinh")
public class ManHinh implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "congnghemanhinh")
    private String congNgheManHinh;
    @Column(name = "dophangiai")
    private String doPhanGiai;
    @Column(name = "kichthuoc")
    private String kichThuoc;
    @Column(name = "dosangtoida")
    private String doSangToiDa;
    @Column(name = "matkinhcamung")
    private String matKinhCamUng;
    @Column(name = "tansoquet")
    private String tanSoQuet;

    public ManHinhDto convertToDto(){
        ManHinhDto m = new ManHinhDto();
        m.setId(this.id.toString());
        m.setCongNgheManHinh(this.congNgheManHinh);
        m.setDoPhanGiai(this.doPhanGiai);
        m.setKichThuoc(this.kichThuoc);
        m.setDoSangToiDa(this.doSangToiDa);
        m.setMatKinhCamUng(this.matKinhCamUng);
        m.setTanSoQuet(this.tanSoQuet);
        return m;
    }
}
