package ptit.suwoo.model;

import lombok.Data;
import ptit.suwoo.sanphamdto.CategoryDto;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "category")
public class Category  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ten;
    @Column(name = "loai")
    private String loai;
    @Column(name = "mota")
    private String moTa;

    public CategoryDto convertToDto(){
        CategoryDto c = new CategoryDto();
        c.setId(id);
        c.setTen(this.ten);
        c.setLoai(this.loai);
        c.setMoTa(this.moTa);
        return c;
    }
}
