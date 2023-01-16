package ptit.suwoo.sanphamdto;

import lombok.Data;
import ptit.suwoo.model.KichThuocTrongLuong;

@Data
public class KichThuocTrongLuongDto {
    private Long id;
    private String doDai;
    private String doRong;
    private String doMong;
    private String trongLuong;

    public KichThuocTrongLuong convertToEntity(){
        KichThuocTrongLuong b = new KichThuocTrongLuong();
        b.setId(this.id);
        b.setTrongLuong(this.trongLuong);
        b.setDoRong(this.doRong);
        b.setDoMong(this.doMong);
        b.setDoDai(this.doDai);
        return b;
    }
}
