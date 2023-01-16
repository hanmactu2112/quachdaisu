package ptit.suwoo.model;

import lombok.Data;
import ptit.suwoo.sanphamdto.TienIchDto;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tienich")
public class TienIch implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "baomat")
    private String baoMat;
    @Column(name = "tinhnangdacbiet")
    private String tinhNangDacBiet;

    public TienIchDto convertToDto(){
        TienIchDto t = new TienIchDto();
        t.setId(this.id);
        t.setBaoMat(this.baoMat);
        t.setTinhNangDacBiet(this.tinhNangDacBiet);
        return t;
    }
}
