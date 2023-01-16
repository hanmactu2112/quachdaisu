package ptit.suwoo.Dto.laptopDto;

import lombok.Data;
import ptit.suwoo.model.Image;
import ptit.suwoo.model.TienIch;
import ptit.suwoo.model.laptopmodel.LTCardDoHoaAmThanhDto;
import ptit.suwoo.model.laptopmodel.Laptop;
import ptit.suwoo.sanphamdto.*;

import java.util.ArrayList;
import java.util.List;

@Data
public class LaptopDTO extends SanPhamDto {
    private KichThuocTrongLuongDto kichThuocTrongLuongDto;
    private CameraDto cameraDto;//
    private TienIchDto tienIchDto;
    private PinDto pinDto;
    private LTRamOCungDto ltRamOCungDto;//
    private LTCPUDto ltcpuDto;//
    private LTCardDoHoaAmThanhDto ltCardDoHoaAmThanhDto;//

    private ManHinhLTDto manHinhLTDto;//

    private KetNoiLTDto ketNoiLTDto;

    public Laptop ConvertToEntity() {
        Laptop a = new Laptop();
        if (super.getId() != null) a.setId(super.getId());
        a.setMasp(super.getMaSp());
        a.setTenSp(super.getTen());
        a.setGia(Double.parseDouble(super.getGia()));
        a.setSoLuong(super.getSoLuong());
        if (super.getImageDto() != null) {
            List<Image> ds = new ArrayList<>();
            for (ImageDto i : super.getImageDto()) {
                Image img = i.convertToEntity();
                ds.add(img);
            }
            a.setImages(ds);
        }

            a.setHang(super.getHang());
            if (super.getCategoryDto() != null) {
                a.setCategory(super.getCategoryDto().convertToEntity());
            }
            a.setColor(super.getColor());
            a.setNgayRaMat(super.getNgayRaMat());
            a.setChatLieu(super.getChatLieu());
            a.setMoTa(super.getMoTa());
            if (super.getKhuyenMaiDto() != null) {
                a.setKhuyenMai(super.getKhuyenMaiDto().convertToEntity());
            }
            a.setKichThuocTrongLuong(this.kichThuocTrongLuongDto.convertToEntity());
            a.setCamera(this.cameraDto.convertToEntity());
            a.setTienIch(this.tienIchDto.convertToEntity());
            a.setPin(this.pinDto.convertToEntity());
            a.setLtRamOCung(this.ltRamOCungDto.convertToEntity());
            a.setLtcpu(this.ltcpuDto.convertToEntity());
            a.setManHinhLT(this.manHinhLTDto.convertToEntity());
            a.setKetNoiLT(this.ketNoiLTDto.convertToEntity());
            a.setLtDoHoaVaAmThanh(this.ltCardDoHoaAmThanhDto.convertToEntity());
            a.setActive(super.isActive());
            return a;
        }
}
