package ptit.suwoo.sanphamdto;

import lombok.Data;
import ptit.suwoo.model.Image;

import java.nio.file.Path;

@Data
public class ImageDto {
    private Long id;
    private String urlImg;
    public Image convertToEntity(){
        Image a = new Image();
        a.setId(this.id);
        a.setUrlImg(this.urlImg);
        return a;
    }
}
