package ptit.suwoo.model;

import lombok.Data;
import ptit.suwoo.sanphamdto.ImageDto;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "image")
public class Image implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "urlimg")
    private String urlImg;
    @ManyToOne
    @JoinColumn(name = "sanpham_id")
    private SanPham sanPham;
    public ImageDto convertToDto(){
        String imgDir = "/ltImages/";
        ImageDto a = new ImageDto();
        a.setId(this.id);
        a.setUrlImg(imgDir+this.urlImg);
        return a;
    }
    public ImageDto convertToDtoDt(){
        String imgDir = "/dtImages/";
        ImageDto a = new ImageDto();
        a.setId(this.id);
        a.setUrlImg(imgDir+this.urlImg);
        return a;
    }
    public ImageDto convertToDtoLt(){
        String imgDir = "/ltImages/";
        ImageDto a = new ImageDto();
        a.setId(this.id);
        a.setUrlImg(imgDir+this.urlImg);
        return a;
    }
}
