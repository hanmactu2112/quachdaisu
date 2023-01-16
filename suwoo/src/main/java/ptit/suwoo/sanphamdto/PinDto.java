package ptit.suwoo.sanphamdto;

import lombok.Data;
import ptit.suwoo.model.Pin;


@Data
public class PinDto {
    private Long id;
    private String dungLuong;
    private String loaiPin;
    private String congNghe;

    public Pin convertToEntity(){
        Pin p = new Pin();
        p.setId(this.id);
        p.setDungLuong(this.dungLuong);
        p.setLoaiPin(this.loaiPin);
        p.setCongNghe(this.congNghe);
        return p;
    }
}
