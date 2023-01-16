package ptit.suwoo.model;

import lombok.Data;
import ptit.suwoo.sanphamdto.CameraDto;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "camera")
public class Camera  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "loai")
    private String loai;
    @Column(name = "dophangiaicamera")
    private String doPhanGiaiCamera;
    @Column(name = "tinhnang")
    private String tinhNang;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dienthoai_id")
    private DienThoai dienThoai;

    public CameraDto convertToDto(){
        CameraDto c = new CameraDto();
        c.setId(this.id);
        c.setLoai(this.loai);
        c.setTinhNang(this.tinhNang);
        c.setDoPhanGiaiCamera(this.doPhanGiaiCamera);
        return c;
    }
}
