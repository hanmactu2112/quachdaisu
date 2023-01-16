package ptit.suwoo.model.laptopmodel;

import lombok.Data;

import javax.persistence.Column;

@Data
public class LTCardDoHoaAmThanhDto {
    private Long id;
    private String cardDoHoa;
    private String cardAmThanh;

    public LTDoHoaVaAmThanh convertToEntity(){
        LTDoHoaVaAmThanh a = new LTDoHoaVaAmThanh();
        a.setId(this.id);
        a.setCardAmThanh(this.cardAmThanh);
        a.setCardDoHoa(this.cardDoHoa);
        return a;
    }
}
