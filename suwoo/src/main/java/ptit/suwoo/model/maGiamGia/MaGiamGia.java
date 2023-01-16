package ptit.suwoo.model.maGiamGia;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ptit.suwoo.Dto.magiamgiaDto.MaGiamGiaDto;
import ptit.suwoo.model.Category;
import ptit.suwoo.model.DienThoai;
import ptit.suwoo.sanphamdto.KhuyenMaiDto;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.Locale;

@Entity
@Data
@Table(name = "magiamgia")

public class MaGiamGia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "code")
    private String code;

    @Column(name = "loaima")
    private String loaiMa;

    @Column(name = "ngaybd")
    private Date ngayBd;

    @Column(name = "ngaykt")
    private Date ngayKt;

    @Column(name = "giatri")
    private Float giaTri;

    @Column(name = "giamtoida")
    private Float giamToiDa;

    @Column(name = "donhangtu")
    private Float donHangTu;

    @Column(name = "mota")
    private String moTa;

    @Column(name = "trangthai")
    private boolean trangThai;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    public MaGiamGiaDto convertToDto(){
        MaGiamGiaDto maGiamGiaDto = new MaGiamGiaDto();
        maGiamGiaDto.setId(this.id);
        maGiamGiaDto.setTen(this.ten);
        maGiamGiaDto.setCode(this.code);
        maGiamGiaDto.setLoaiMa(this.loaiMa);
        maGiamGiaDto.setNgayBd(this.ngayBd.toString());
        maGiamGiaDto.setNgayKt(this.ngayKt.toString());
        maGiamGiaDto.setGiaTri(this.giaTri.toString());
        maGiamGiaDto.setMoTa(this.moTa);
        maGiamGiaDto.setTrangThai(this.trangThai);
        maGiamGiaDto.setCategoryDto(this.category.convertToDto());
        maGiamGiaDto.setGiamToiDa(this.giamToiDa.toString());
        maGiamGiaDto.setDonHangTu(this.donHangTu.toString());
        return maGiamGiaDto;
    }
    public MaGiamGiaDto convertToDtoView(){
        MaGiamGiaDto maGiamGiaDto = new MaGiamGiaDto();
        maGiamGiaDto.setId(this.id);
        maGiamGiaDto.setTen(this.ten);
        maGiamGiaDto.setCode(this.code);
        maGiamGiaDto.setNgayBd(this.ngayBd.toString());
        maGiamGiaDto.setNgayKt(this.ngayKt.toString());
        maGiamGiaDto.setLoaiMa(this.loaiMa);
        if (this.loaiMa.equals("0")){
            maGiamGiaDto.setGiaTri(this.giaTri.toString()+"%");
        }
        else {
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String str = currencyVN.format(this.giaTri);
            maGiamGiaDto.setGiaTri(str);
        }
        maGiamGiaDto.setMoTa(this.moTa);
        maGiamGiaDto.setTrangThai(this.trangThai);
        maGiamGiaDto.setCategoryDto(this.category.convertToDto());
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String str1 = currencyVN.format(this.giamToiDa);
        String str2 = currencyVN.format(this.donHangTu);
        maGiamGiaDto.setGiamToiDa(str1);
        maGiamGiaDto.setDonHangTu(str2);
        return maGiamGiaDto;
    }

}
