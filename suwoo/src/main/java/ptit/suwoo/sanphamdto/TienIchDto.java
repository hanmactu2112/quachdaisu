package ptit.suwoo.sanphamdto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class TienIchDto {
    private Long id;
    private String baoMat;
    private String tinhNangDacBiet;
}
