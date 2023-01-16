package ptit.suwoo.model.laptopmodel;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ltdohoavaamthanh")
public class LTDoHoaVaAmThanh implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "carddohoa",length = 500)
    private String cardDoHoa;
    @Column(name = "cardamthanh",length = 500)
    private String cardAmThanh;
    public LTCardDoHoaAmThanhDto convertToDto(){
        LTCardDoHoaAmThanhDto a = new LTCardDoHoaAmThanhDto();
        a.setId(this.id);
        a.setCardAmThanh(this.cardAmThanh);
        a.setCardDoHoa(this.cardDoHoa);
        return a;
    }
}

