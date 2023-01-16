package ptit.suwoo.SanPhamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptit.suwoo.model.DienThoai;
import ptit.suwoo.model.SanPham;
import ptit.suwoo.sanphamRepository.SanPhamRepository;
import ptit.suwoo.sanphamRepository.SanphamRepository2;

import java.time.LocalDate;
import java.util.List;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    SanphamRepository2 sanPhamRepository;
    @Override
    public List<DienThoai> searhFlashSale() {
        return sanPhamRepository.searchFlashDeals();
    }
}
