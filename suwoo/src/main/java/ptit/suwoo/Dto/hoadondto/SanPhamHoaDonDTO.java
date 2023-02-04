package ptit.suwoo.Dto.hoadondto;

import lombok.Data;
import ptit.suwoo.model.hoadon.HoaDon;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class SanPhamHoaDonDTO {
    private long id;

    private String masp;

    private String tenSp;

    private String gia;

    private int soLuong;

    private String hang;

    private String images;

    private String color;

    private String tong;

    private HoaDon hoaDon;
}
