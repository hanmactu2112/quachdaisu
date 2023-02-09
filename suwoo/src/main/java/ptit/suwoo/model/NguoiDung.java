package ptit.suwoo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ptit.suwoo.Dto.AdminDTO;
import ptit.suwoo.annotation.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
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
    @Name
    private String name;
    @Column(name = "gioitinh")
    private boolean gioiTinh;
    @Column(name = "ngaysinh")
    private Date ngaySinh;
    @Column(name = "sdt")
    @Phone
    private String sdt;
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
        this.sdt = a.getSdt();
        this.diaChi = a.getDiaChi();
        this.email = a.getEmail();
        this.urlImg = a.getUrlImg();
    }
}
