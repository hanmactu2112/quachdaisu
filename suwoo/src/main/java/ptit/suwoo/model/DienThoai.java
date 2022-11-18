package ptit.suwoo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "dienthoai")
public class DienThoai  extends SanPham{
    @Column(name = "thietKe")
    private String thietKe;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "dthedieuhanhcpu_id",insertable = true)
    private DTHeDieuHanhCPU dtHeDieuHanhCPU;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "dtketnoi_id",insertable = true)
    private DTKetNoi dtKetNoi;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "manhinh_id",insertable = true)
    private ManHinh manHinh;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "dtbonho_id",insertable = true)
    private DTBoNho dtBoNho;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "dienthoai_id",insertable = true)
    private List<Camera> cameras;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "kichthuoctrongluong_id",insertable = true)
    private KichThuocTrongLuong kichThuocTrongLuong;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "pin_id",insertable = true)
    private Pin pin;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "tienich_id",insertable = true)
    private TienIch tienIch;
}
