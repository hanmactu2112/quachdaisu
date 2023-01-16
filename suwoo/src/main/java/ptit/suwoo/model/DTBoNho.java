package ptit.suwoo.model;

import lombok.Data;
import ptit.suwoo.sanphamdto.DTBoNhoDto;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "dtbonho")
public class DTBoNho  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "ram")
    private String ram;
    @Column(name = "rom")
    private String rom;

    public DTBoNhoDto convertToDto(){
        DTBoNhoDto d = new DTBoNhoDto();
        d.setId(this.id);
        d.setRam(this.ram);
        d.setRom(this.rom);
        return d;
    }
}
