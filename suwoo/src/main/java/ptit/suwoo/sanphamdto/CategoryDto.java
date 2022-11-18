package ptit.suwoo.sanphamdto;


import lombok.Data;

@Data
public class CategoryDto {
    private Long id;
    private String ten;
    private String moTa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
