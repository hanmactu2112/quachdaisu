package ptit.suwoo.sanphamdto;

import lombok.Data;
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
}
