package ptit.suwoo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tienich")
public class TienIch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "baomat")
    private String baoMat;
    @Column(name = "tinhnangdacbiet")
    private String tinhNangDacBiet;
}
