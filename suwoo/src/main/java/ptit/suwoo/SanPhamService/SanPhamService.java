package ptit.suwoo.SanPhamService;

import org.springframework.stereotype.Service;
import ptit.suwoo.model.DienThoai;
import ptit.suwoo.model.SanPham;

import java.util.List;

@Service
public interface SanPhamService {
    List<DienThoai> searhFlashSale();
}
