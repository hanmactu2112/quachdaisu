package ptit.suwoo.model.laptopmodel;

import lombok.Data;
import ptit.suwoo.Dto.laptopDto.LaptopDTO;
import ptit.suwoo.model.*;
import ptit.suwoo.sanphamdto.DienThoaiDto;
import ptit.suwoo.sanphamdto.ImageDto;

import javax.persistence.*;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Entity
@Table(name = "laptop")
@Data
public class Laptop extends SanPham implements Serializable {
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "kich_thuoc_trong_luong_id")
    private KichThuocTrongLuong kichThuocTrongLuong;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "camera_id")
    private Camera camera;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "tienich_id")
    private TienIch tienIch;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "pin_id")
    private Pin pin;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "lt_ram_o_cung_id")
    private LTRamOCung ltRamOCung;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "ltcpu_id")
    private LTCPU ltcpu;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "lt_do_hoa_va_am_thanh_id")
    private LTDoHoaVaAmThanh ltDoHoaVaAmThanh;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "man_hinh_lt_id")
    private ManHinhLT manHinhLT;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "ket_noi_lt_id")
    private KetNoiLT ketNoiLT;
    public LaptopDTO convertToDto(){

        LaptopDTO a = new LaptopDTO();
        a.setId(super.getId());
        a.setMaSp(super.getMasp());
        a.setTen(super.getTenSp());
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String str1 = currencyVN.format(super.getGia());
        a.setGia(str1);
        a.setSoLuong(super.getSoLuong());
        List<ImageDto> ds = new ArrayList<>();
        for (Image i:super.getImages()){
            ImageDto img = i.convertToDto();
            ds.add(img);
        }
        a.setImageDto(ds);
        a.setHang(super.getHang());
        if(super.getCategory()!=null)a.setCategoryDto(super.getCategory().convertToDto());
        a.setColor(super.getColor());
        a.setNgayRaMat(super.getNgayRaMat());
        a.setChatLieu(super.getChatLieu());
        a.setMoTa(super.getMoTa());
        if(super.getKhuyenMai()!=null)a.setKhuyenMaiDto(super.getKhuyenMai().convertToDto());
        a.setKichThuocTrongLuongDto(this.kichThuocTrongLuong.convertToDto());
        a.setCameraDto(this.camera.convertToDto());
        a.setTienIchDto(this.tienIch.convertToDto());
        a.setPinDto(this.pin.convertToDto());
        a.setLtRamOCungDto(this.ltRamOCung.convertToDtoEdit());
        a.setLtcpuDto(this.ltcpu.convertToDto());
        if (this.manHinhLT!=null)a.setManHinhLTDto(this.manHinhLT.convertToDto());
        if (this.ketNoiLT!=null)a.setKetNoiLTDto(this.ketNoiLT.convertToDto());
        a.setLtCardDoHoaAmThanhDto(this.ltDoHoaVaAmThanh.convertToDto());
        return a;
    }
    public LaptopDTO convertToDtoEdit(){

        LaptopDTO a = new LaptopDTO();
        a.setId(super.getId());
        a.setMaSp(super.getMasp());
        a.setTen(super.getTenSp());
        a.setGia(String.format("%.0f",super.getGia()));
        a.setSoLuong(super.getSoLuong());
        List<ImageDto> ds = new ArrayList<>();
        for (Image i:super.getImages()){
            ImageDto img = i.convertToDto();
            ds.add(img);
        }
        a.setImageDto(ds);
        a.setHang(super.getHang());
        if(super.getCategory()!=null)a.setCategoryDto(super.getCategory().convertToDto());
        a.setColor(super.getColor());
        a.setNgayRaMat(super.getNgayRaMat());
        a.setChatLieu(super.getChatLieu());
        a.setMoTa(super.getMoTa());
        a.setKichThuocTrongLuongDto(this.kichThuocTrongLuong.convertToDtoEdit());
        a.setCameraDto(this.camera.convertToDto());
        a.setTienIchDto(this.tienIch.convertToDto());
        a.setPinDto(this.pin.convertToDtoEdit());
        a.setLtRamOCungDto(this.ltRamOCung.convertToDtoEdit());
        a.setLtcpuDto(this.ltcpu.convertToDto());
        if (this.manHinhLT!=null)a.setManHinhLTDto(this.manHinhLT.convertToDto());
        if (this.ketNoiLT!=null)a.setKetNoiLTDto(this.ketNoiLT.convertToDto());
        a.setLtCardDoHoaAmThanhDto(this.ltDoHoaVaAmThanh.convertToDto());
        a.setActive(super.isActive());
        return a;
    }
    public LaptopDTO convertToLtDTOClient(){
        LaptopDTO a = new LaptopDTO();
        a.setId(super.getId());
        a.setMaSp(super.getMasp());
        a.setTen(super.getTenSp());
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String str1 = currencyVN.format(super.getGia());
        a.setGia(str1);
        if(super.getKhuyenMai()!=null){
            float giaKm = Math.round((super.getGia()-super.getGia()*(super.getKhuyenMai().getTiLe()/100)));
            a.setGiaKm(currencyVN.format(giaKm));
        }
        a.setSoLuong(super.getSoLuong());
        List<ImageDto> ds = new ArrayList<>();
        for (Image i:super.getImages()){
            ImageDto img = i.convertToDtoLt();
            ds.add(img);
        }
        a.setImageDto(ds);
        a.setHang(super.getHang());
        a.setCategoryDto(super.getCategory().convertToDto());
        a.setColor(super.getColor());
        a.setNgayRaMat(super.getNgayRaMat());
        a.setChatLieu(super.getChatLieu());
        a.setMoTa(super.getMoTa());
        if (super.getKhuyenMai()!=null){
            a.setKhuyenMaiDto(super.getKhuyenMai().convertToDto());
        }
        a.setKichThuocTrongLuongDto(this.kichThuocTrongLuong.convertToDto());
        if (this.camera!=null)a.setCameraDto(this.camera.convertToDto());
        if (this.tienIch!=null)a.setTienIchDto(this.tienIch.convertToDto());
        if (this.pin!=null)a.setPinDto(this.pin.convertToDto());
        if (this.ltRamOCung!=null)a.setLtRamOCungDto(this.ltRamOCung.convertToDtoEdit());
        if (this.ltcpu!=null)a.setLtcpuDto(this.ltcpu.convertToDto());
        if (this.manHinhLT!=null)a.setManHinhLTDto(this.manHinhLT.convertToDto());
        if (this.ketNoiLT!=null)a.setKetNoiLTDto(this.ketNoiLT.convertToDto());
        if (this.ltDoHoaVaAmThanh!=null)a.setLtCardDoHoaAmThanhDto(this.ltDoHoaVaAmThanh.convertToDto());
        a.setActive(super.isActive());
        return a;
    }
}
