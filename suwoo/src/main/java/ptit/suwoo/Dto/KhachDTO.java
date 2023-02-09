package ptit.suwoo.Dto;

import lombok.Data;
import ptit.suwoo.annotation.*;
import ptit.suwoo.model.KhachHang;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
public class KhachDTO {
    @Name
    private String name;
    @NotNull(message = "*Vui lòng chọn giới tính.")
    private boolean gioiTinh;
    @BirthDate
    private String ngaySinh;
    @Phone
    private String sdt;
    @NotNull(message = "*Không để trống trường thông tin.")
    private String diaChi;
    @Email
    private String email;
    @Password
    private String matKhau;
    private String urlImg;
    private String ngayDangKy;

    public KhachHang convertToEntity(){
        KhachHang khachHang = new KhachHang();
        khachHang.setName(this.name);
        khachHang.setGioiTinh(this.gioiTinh);
        khachHang.setNgaySinh(Date.valueOf(this.ngaySinh));
        khachHang.setSdt(this.sdt);
        khachHang.setDiaChi(this.diaChi);
        khachHang.setEmail(this.email);
        khachHang.setMatKhau(this.matKhau);
        khachHang.setUrlImg(this.urlImg);
        khachHang.setNgayDangKy(this.ngayDangKy);
        return khachHang;
    }
}
