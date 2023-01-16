package ptit.suwoo.Dto.laptopDto;

import lombok.Data;
import ptit.suwoo.model.laptopmodel.ManHinhLT;

import javax.persistence.Column;

@Data
public class ManHinhLTDto {
    private Long id;
    private String kichThuoc;
    private String doPhanGiai;
    private String tanSoQuet;
    private String congNgheManHinh;

    public ManHinhLT convertToEntity(){
        ManHinhLT m = new ManHinhLT();
        m.setId(this.id);
        m.setKichThuoc(this.kichThuoc);
        m.setDoPhanGiai(this.doPhanGiai);
        m.setTanSoQuet(this.tanSoQuet);
        m.setCongNgheManHinh(this.congNgheManHinh);
        return m;
    }
}
