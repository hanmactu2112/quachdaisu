package ptit.suwoo.sanphamdto;


import lombok.Data;
import ptit.suwoo.model.Category;

@Data
public class CategoryDto {
    private Long id;
    private String ten;
    private String moTa;
    private String loai;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Category convertToEntity(){
        Category c = new Category();
        c.setId(this.id);
        c.setTen(this.ten);
        c.setLoai(this.loai);
        c.setMoTa(this.moTa);
        return c;
    }
}
