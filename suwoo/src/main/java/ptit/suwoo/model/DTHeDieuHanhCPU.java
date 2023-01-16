package ptit.suwoo.model;

import lombok.Data;
import ptit.suwoo.sanphamdto.DTHeDieuHanhCpuDto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "dthedieuhanhcpu")
public class DTHeDieuHanhCPU  implements Serializable {
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

    public DTHeDieuHanhCpuDto convertToDto(){
        DTHeDieuHanhCpuDto d = new DTHeDieuHanhCpuDto();
        d.setId(this.id);
        d.setHeDieuHanh(this.heDieuHanh);
        d.setCpu(this.cpu);
        d.setTocDoCpu(this.tocDoCpu);
        d.setGpu(this.gpu);
        return d;
    }
}
