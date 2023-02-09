package ptit.suwoo.Dto.hoadondto;

import lombok.Data;
import ptit.suwoo.Dto.magiamgiaDto.MaGiamGiaDto;
import ptit.suwoo.model.KhachHang;

import ptit.suwoo.model.maGiamGia.MaGiamGia;


import java.sql.Date;
import java.util.List;

@Data
public class HoaDonDTO {
    private Long id;
    private String nguoiNhan;
    private String sdt;
    private String email;
    private String diaChi;
    private String shipping;
    private String ghiChu;
    private boolean xuatHD;
    private Date ngayTao;
    private String tinhTrang;
    private KhachHang khachHang;
    private MaGiamGiaDto maGiamGiaDto;
    private List<SanPhamHoaDonDTO> sanPhamHoaDons;
    private String tong;
    private String tongtien;
}
