package ptit.suwoo.model.laptopmodel;


import lombok.Data;
import ptit.suwoo.Dto.laptopDto.ManHinhLTDto;

import javax.persistence.*;

@Data
@Entity
@Table(name = "manhinhlt")
public class ManHinhLT {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "kichthuoc")
    private String kichThuoc;
    @Column(name = "dophangiai")
    private String doPhanGiai;
    @Column(name = "tansoquet")
    private String tanSoQuet;
    @Column(name = "congnghemanhinh",length = 500)
    private String congNgheManHinh;

    public ManHinhLTDto convertToDto(){
        ManHinhLTDto m = new ManHinhLTDto();
        m.setId(this.id);
        m.setKichThuoc(this.kichThuoc);
        m.setDoPhanGiai(this.doPhanGiai);
        m.setTanSoQuet(this.tanSoQuet);
        m.setCongNgheManHinh(this.congNgheManHinh);
        return m;
    }
}
