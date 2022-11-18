package ptit.suwoo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "camera")
public class Camera {
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
}
