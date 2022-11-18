package ptit.suwoo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ptit.suwoo.Dto.AdminDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class NguoiDung implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "gioitinh")
    private boolean gioiTinh;
    @Column(name = "ngaysinh")
    private Date ngaySinh;
    @Column(name = "sdt")
    private int sdt;
    @Column(name = "diachi")
    private String diaChi;
    @Column(name = "email")
    private String email;
    @Column(name = "matkhau")
    private String matKhau;
    @Column(name = "urlimg")
    private String urlImg;

    public NguoiDung(AdminDTO a) {
        this.id = Long.parseLong(a.getId());
        this.name = a.getName();
        this.gioiTinh = a.isGioiTinh();
        this.ngaySinh = Date.valueOf(a.getNgaySinh());
        this.sdt = Integer.parseInt(a.getSdt());
        this.diaChi = a.getDiaChi();
        this.email = a.getEmail();
        this.urlImg = a.getUrlImg();
    }
}
