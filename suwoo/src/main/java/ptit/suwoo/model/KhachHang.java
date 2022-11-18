package ptit.suwoo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "khachhang")
@Entity
public class KhachHang extends NguoiDung implements Serializable {
    @Column(name = "ngaydangky")
    private String ngayDangKy;
}
