package ptit.suwoo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "dthedieuhanhcpu")
public class DTHeDieuHanhCPU {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "hedieuhanh")
    private String heDieuHanh;
    @Column(name = "cpu")
    private String cpu;
    @Column(name = "tocdocpu")
    private String tocDoCpu;
    @Column(name = "gpu")
    private String gpu;
}
