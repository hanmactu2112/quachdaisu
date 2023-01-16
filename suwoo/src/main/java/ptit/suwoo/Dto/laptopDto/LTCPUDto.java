package ptit.suwoo.Dto.laptopDto;

import lombok.Data;
import ptit.suwoo.model.laptopmodel.LTCPU;

import javax.persistence.Column;

@Data
public class LTCPUDto {
    private Long id;
    private String tenCpu;
    private String soNhan;
    private String soLuong;
    private String congNghe;
    private String tocDo;
    private String tocDoToiDa;
    private String boNhoDem;

    public LTCPU convertToEntity(){
        LTCPU a = new LTCPU();
        a.setId(this.id);
        a.setTenCpu(this.tenCpu);
        a.setSoNhan(this.soNhan);
        a.setCongNghe(this.congNghe);
        a.setSoLuong(this.soLuong);
        a.setTocDo(tocDo);
        a.setTocDoToiDa(this.tocDoToiDa);
        a.setBoNhoDem(this.boNhoDem);
        return a;
    }
}
