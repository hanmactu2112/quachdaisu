package ptit.suwoo.Dto.magiamgiaDto;

import lombok.Data;
import ptit.suwoo.model.laptopmodel.ManHinhLT;
import ptit.suwoo.model.maGiamGia.MaGiamGia;
import ptit.suwoo.sanphamdto.CategoryDto;

import java.sql.Date;

@Data
public class MaGiamGiaDto {

    private Long id;

    private String ten;

    private String code;

    private String loaiMa;

    private String ngayBd;

    private String ngayKt;
    private String giamToiDa;
    private String donHangTu;
    private String giaTri;

    private String moTa;

    private boolean trangThai;

    private CategoryDto categoryDto;

    public MaGiamGia convertToEntity(){
        MaGiamGia maGiamGia = new MaGiamGia();
        maGiamGia.setId(this.id);
        maGiamGia.setTen(this.ten);
        maGiamGia.setLoaiMa(this.loaiMa);
        maGiamGia.setNgayBd(Date.valueOf(this.ngayBd));
        maGiamGia.setNgayKt(Date.valueOf(this.ngayKt));
        maGiamGia.setCode(this.code);
        maGiamGia.setGiaTri(Float.parseFloat(this.giaTri));
        maGiamGia.setMoTa(this.moTa);
        maGiamGia.setTrangThai(this.trangThai);
        if (this.categoryDto!=null)maGiamGia.setCategory(this.categoryDto.convertToEntity());
        maGiamGia.setGiamToiDa(Float.parseFloat(this.giamToiDa));
        maGiamGia.setDonHangTu(Float.parseFloat(this.donHangTu));
        return maGiamGia;
    }

}
