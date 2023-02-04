package ptit.suwoo.model;

import lombok.Data;
import ptit.suwoo.sanphamdto.*;

import javax.persistence.*;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.*;

@Data
@Entity
@Table(name = "dienthoai")
public class DienThoai  extends SanPham implements Serializable {
    @Column(name = "thietKe")
    private String thietKe;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "dthedieuhanhcpu_id",insertable = true)
    private DTHeDieuHanhCPU dtHeDieuHanhCPU;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "dtketnoi_id",insertable = true)
    private DTKetNoi dtKetNoi;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "manhinh_id",insertable = true)
    private ManHinh manHinh;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "dtbonho_id",insertable = true)
    private DTBoNho dtBoNho;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "dienthoai_id",insertable = true)
    private List<Camera> cameras;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "kichthuoctrongluong_id",insertable = true)
    private KichThuocTrongLuong kichThuocTrongLuong;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "pin_id",insertable = true)
    private Pin pin;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "tienich_id",insertable = true)
    private TienIch tienIch;

    public SanPhamDto convertToDTOClient(){
        SanPhamDto a = new SanPhamDto();
        a.setId(super.getId());
        a.setMaSp(super.getMasp());
        a.setTen(super.getTenSp());
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String str1 = currencyVN.format(super.getGia());
        a.setGia(str1);
        if (super.getKhuyenMai()!=null){
            float giaKm = Math.round((super.getGia()-super.getGia()*(super.getKhuyenMai().getTiLe()/100)));
            a.setGiaKm(currencyVN.format(giaKm));
        }

        a.setSoLuong(super.getSoLuong());
        List<ImageDto> ds = new ArrayList<>();
        for (Image i:super.getImages()){
            ImageDto img = i.convertToDtoDt();
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
        a.setActive(super.isActive());
        return a;
    }
    public DienThoaiDto convertToDtDTOClient(){
        DienThoaiDto a = new DienThoaiDto();
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
            ImageDto img = i.convertToDtoDt();
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
        a.setActive(super.isActive());
        return a;
    }
    public DienThoaiDto convertToDtDTOClientDetails(){
        DienThoaiDto a = new DienThoaiDto();
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
            ImageDto img = i.convertToDtoDt();
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
        a.setActive(super.isActive());
        if (this.thietKe!=null) a.setThietKe(this.thietKe);
        if (this.dtHeDieuHanhCPU!=null)  a.setDtHeDieuHanhCpuDto(this.dtHeDieuHanhCPU.convertToDto());
        if (this.dtKetNoi!=null)  a.setDtKetNoiDto(this.dtKetNoi.convertToDto());
        if (this.manHinh!=null) a.setManHinhDto(this.manHinh.convertToDto());
        if (this.dtBoNho!=null) a.setDtBoNhoDto(this.dtBoNho.convertToDto());
        if (!this.cameras.isEmpty()) {
            List<CameraDto> listC = new ArrayList<>();
            this.cameras.forEach((e)->{
                CameraDto c = e.convertToDto();
                listC.add(c);
            });
            a.setCameraDtoList(listC);
        }
        if (this.kichThuocTrongLuong!=null){
            a.setKichThuocTrongLuongDto(this.kichThuocTrongLuong.convertToDto());
        }
        if (this.pin!=null){
            a.setPinDto(this.pin.convertToDtoEdit());
        }
        if (this.tienIch!=null) a.setTienIchDto(this.tienIch.convertToDto());
        return a;
    }
}
