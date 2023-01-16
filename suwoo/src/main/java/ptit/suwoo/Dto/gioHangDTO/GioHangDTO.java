package ptit.suwoo.Dto.gioHangDTO;

import lombok.Data;
import ptit.suwoo.Dto.KhachHangDto;

import java.util.List;

@Data
public class GioHangDTO {
    private Long id;

    private KhachHangDto khachHangDTO;

    private List<GioHangSanPhamDTO> gioHangSanPhamDTOS;

    private String tongTien;
}
