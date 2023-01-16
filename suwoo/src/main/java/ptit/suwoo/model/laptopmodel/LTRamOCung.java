package ptit.suwoo.model.laptopmodel;

import lombok.Data;
import ptit.suwoo.Dto.laptopDto.LTRamOCungDto;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ram_ocung")
public class LTRamOCung implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "dungluongram")
    private String dungLuongRam;
    @Column(name = "loairam")
    private String loaiRam;
    @Column(name = "tocdobus")
    private String tocDoBus;
    @Column(name = "hotrotoida")
    private String hoTroToiDa;
    @Column(name = "ocung")
    private String oCung;

    public LTRamOCungDto convertToDtoEdit(){
        LTRamOCungDto a = new LTRamOCungDto();
        a.setId(this.id);
        a.setDungLuongRam(String.valueOf(this.dungLuongRam));
        a.setLoaiRam(this.loaiRam);
        a.setTocDoBus(String.valueOf(this.tocDoBus));
        a.setHoTroToiDa(this.hoTroToiDa);
        a.setOCung(this.oCung);
        return a;
    }
}
