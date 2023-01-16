package ptit.suwoo.model.laptopmodel;


import lombok.Data;
import ptit.suwoo.Dto.laptopDto.KetNoiLTDto;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ketnoilt")
public class KetNoiLT {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "conggiaotiep")
    private String congGiaoTiep;
    @Column(name = "ketnoikhongday")
    private String ketNoiKhongDay;
    @Column(name = "denbanphim")
    private String denBanPhim;

    public KetNoiLTDto convertToDto(){
        KetNoiLTDto k = new KetNoiLTDto();
        k.setId(this.id);
        k.setCongGiaoTiep(this.congGiaoTiep);
        k.setKetNoiKhongDay(this.ketNoiKhongDay);
        k.setDenBanPhim(this.denBanPhim);
        return k;
    }

}
