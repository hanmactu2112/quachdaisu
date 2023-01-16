package ptit.suwoo.Dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import ptit.suwoo.model.KhachHang;
import ptit.suwoo.model.NguoiDung;

import java.sql.Date;
import java.util.Collection;

@Data
public class KhachHangDto extends NguoiDung {
    private String ngayDangKy;

    public KhachHang convertToEntity(){
        KhachHang khachHang = new KhachHang();
        khachHang.setId(super.getId());
        khachHang.setName(super.getName());
        khachHang.setGioiTinh(super.isGioiTinh());
        khachHang.setNgaySinh(super.getNgaySinh());
        khachHang.setSdt(super.getSdt());
        khachHang.setDiaChi(super.getDiaChi());
        khachHang.setEmail(super.getEmail());
        khachHang.setUrlImg(super.getUrlImg());
        khachHang.setNgayDangKy(this.ngayDangKy);
        return khachHang;
    }
}
