package ptit.suwoo.sanphamdto;

import lombok.Data;
import ptit.suwoo.model.Camera;
import ptit.suwoo.model.DienThoai;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class CameraDto {
    private Long id;
    private String loai;
    private String doPhanGiaiCamera;
    private String tinhNang;
    private DienThoaiDto dienThoaiDto;
    public Camera convertToEntity(){
        Camera c = new Camera();
        c.setId(this.id);
        c.setLoai(this.loai);
        c.setDoPhanGiaiCamera(this.doPhanGiaiCamera);
        c.setTinhNang(this.tinhNang);
        return c;
    }
}
