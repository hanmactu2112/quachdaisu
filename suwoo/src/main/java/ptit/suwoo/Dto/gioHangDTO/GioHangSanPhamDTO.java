package ptit.suwoo.Dto.gioHangDTO;

import lombok.Data;
import ptit.suwoo.sanphamdto.SanPhamDto;

@Data
public class GioHangSanPhamDTO {
    private Long id;

    private GioHangDTO gioHangDTO;

    private SanPhamDto sanPhamDTO;

    private int soLuong;

    private String tongTien;
}
