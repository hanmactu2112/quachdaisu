package ptit.suwoo.model;

import lombok.Data;
import ptit.suwoo.Dto.KhachHangDto;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "khachhang")
@Entity
public class KhachHang extends NguoiDung implements Serializable {
    @Column(name = "ngaydangky")
    private String ngayDangKy;

    public KhachHangDto convertToDto(){
        KhachHangDto khachHangDto = new KhachHangDto();
        khachHangDto.setId(super.getId());
        khachHangDto.setName(super.getName());
        khachHangDto.setGioiTinh(super.isGioiTinh());
        khachHangDto.setNgaySinh(super.getNgaySinh());
        khachHangDto.setSdt(super.getSdt());
        khachHangDto.setDiaChi(super.getDiaChi());
        khachHangDto.setEmail(super.getEmail());
        khachHangDto.setUrlImg(super.getUrlImg());
        khachHangDto.setNgayDangKy(this.ngayDangKy);
        return khachHangDto;
    }
}
