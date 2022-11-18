package ptit.suwoo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "dtketnoi")
public class DTKetNoi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "mangdidong")
    private String mangDiDong;
    @Column(name = "wifi")
    private String wifi;
    @Column(name = "gps")
    private String gps;
    @Column(name = "bluetooth")
    private String bluetooth;
    @Column(name = "congsac")
    private String congSac;
    @Column(name = "tainghe")
    private String taiNghe;
    @Column(name = "ketnoikhac")
    private String ketNoiKhac;

}
