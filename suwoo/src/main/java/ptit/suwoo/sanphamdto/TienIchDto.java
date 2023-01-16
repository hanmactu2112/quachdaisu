package ptit.suwoo.sanphamdto;

import lombok.Data;
import ptit.suwoo.model.TienIch;

import javax.persistence.Column;

@Data
public class TienIchDto {
    private Long id;
    private String baoMat;
    private String tinhNangDacBiet;

    public TienIch convertToEntity(){
        TienIch t = new TienIch();
        t.setId(this.id);
        t.setBaoMat(this.baoMat);
        t.setTinhNangDacBiet(this.tinhNangDacBiet);
        return t;
    }
}
