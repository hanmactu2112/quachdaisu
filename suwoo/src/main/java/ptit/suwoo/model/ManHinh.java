package ptit.suwoo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "manhinh")
public class ManHinh {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "congnghemanhinh")
    private String congNgheManHinh;
    @Column(name = "dophangiai")
    private String doPhanGiai;
    @Column(name = "kichthuoc")
    private double kichThuoc;
    @Column(name = "dosangtoida")
    private double doSangToiDa;
    @Column(name = "matkinhcamung")
    private String matKinhCamUng;
    @Column(name = "tansoquet")
    private double tanSoQuet;
}
