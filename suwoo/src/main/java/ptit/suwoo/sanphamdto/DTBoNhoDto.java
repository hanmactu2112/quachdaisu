package ptit.suwoo.sanphamdto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class DTBoNhoDto {
    private Long id;
    private String ram;
    private String rom;
}
