package ptit.suwoo.model.laptopmodel;

import lombok.Data;
import org.springframework.validation.annotation.Validated;
import ptit.suwoo.Dto.laptopDto.LTCPUDto;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ltcpu")
public class LTCPU implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "tencpu")
    private String tenCpu;
    @Column(name = "sonhan")
    private String soNhan;
    @Column(name = "soluong")
    private String soLuong;
    @Column(name = "congnghe")
    private String congNghe;
    @Column(name = "tocdo")
    private String tocDo;
    @Column(name = "tocdotoida")
    private String tocDoToiDa;
    @Column(name = "bonhodem")
    private String boNhoDem;

    public LTCPUDto convertToDto(){
        LTCPUDto a = new LTCPUDto();
        a.setId(this.id);
        a.setTenCpu(this.tenCpu);
        a.setSoNhan(this.soNhan);
        a.setSoLuong(this.soLuong);
        a.setCongNghe(this.congNghe);
        a.setTocDo(this.tocDo);
        a.setTocDoToiDa(this.tocDoToiDa);
        a.setBoNhoDem(this.boNhoDem);
        return a;
    }
}
