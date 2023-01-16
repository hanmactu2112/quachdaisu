package ptit.suwoo.model;

import lombok.Data;
import ptit.suwoo.sanphamdto.PinDto;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "pin")
public class Pin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "dungluong")
    private String dungLuong;
    @Column(name = "loaipin")
    private String loaiPin;
    @Column(name = "congnghe")
    private String congNghe;

    public PinDto convertToDto(){
        PinDto p = new PinDto();
        p.setId(this.id);
        p.setDungLuong(this.dungLuong);
        p.setLoaiPin(this.loaiPin);
        p.setCongNghe(this.congNghe);
        return p;
    }
    public PinDto convertToDtoEdit(){
        PinDto p = new PinDto();
        p.setId(this.id);
        p.setDungLuong(this.dungLuong.toString());
        p.setLoaiPin(this.loaiPin);
        p.setCongNghe(this.congNghe);
        return p;
    }
}
