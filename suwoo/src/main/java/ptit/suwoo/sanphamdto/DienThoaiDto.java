package ptit.suwoo.sanphamdto;

import lombok.Data;

import java.util.List;

@Data
public class DienThoaiDto extends SanPhamDto{
    private String thietKe;
    private DTHeDieuHanhCpuDto dtHeDieuHanhCpuDto;
    private DTKetNoiDto dtKetNoiDto;
    private ManHinhDto manHinhDto;
    private DTBoNhoDto dtBoNhoDto;
    private List<CameraDto> cameraDtoList;
    private KichThuocTrongLuongDto kichThuocTrongLuongDto;
    private PinDto pinDto;
    private TienIchDto tienIchDto;

    public DienThoaiDto() {
        super();
    }
}
