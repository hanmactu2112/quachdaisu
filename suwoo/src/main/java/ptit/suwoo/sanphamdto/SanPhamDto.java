package ptit.suwoo.sanphamdto;

import lombok.Data;

import java.util.List;

@Data
public class SanPhamDto {
    private Long id;
    private String maSp;
    private String ten;
    private String gia;
    private String soLuong;
    private List<ImageDto> imageDto;
    private String hang;
    private CategoryDto categoryDto;
    private String color;
    private String ngayRaMat;
    private String chatLieu;
    private String moTa;

}
