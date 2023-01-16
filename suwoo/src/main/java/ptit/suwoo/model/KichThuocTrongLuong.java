package ptit.suwoo.model;

import lombok.Data;
import ptit.suwoo.sanphamdto.KichThuocTrongLuongDto;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "kichthuoctrongluong")
public class KichThuocTrongLuong implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "dodai")
    private String doDai;
    @Column(name = "dorong")
    private String doRong;
    @Column(name = "domong")
    private String doMong;
    @Column(name = "trongluong")
    private String trongLuong;
    public KichThuocTrongLuongDto convertToDto(){
        KichThuocTrongLuongDto b = new KichThuocTrongLuongDto();
        b.setId(this.id);
        b.setTrongLuong(this.trongLuong);
        b.setDoRong(this.doRong);
        b.setDoMong(this.doMong);
        b.setDoDai(this.doDai);
        return b;
    }
    public KichThuocTrongLuongDto convertToDtoEdit(){
        KichThuocTrongLuongDto b = new KichThuocTrongLuongDto();
        b.setId(this.id);
        b.setTrongLuong(this.trongLuong.toString());
        b.setDoRong(this.doRong.toString());
        b.setDoMong(this.doMong.toString());
        b.setDoDai(this.doDai.toString());
        return b;
    }
}
