package ptit.suwoo.SanPhamService;

import org.springframework.stereotype.Service;
import ptit.suwoo.model.KhuyenMai;

import java.util.List;
import java.util.Optional;

@Service
public interface KhuyenMaiService {
    List<KhuyenMai> findAll();
    Optional<KhuyenMai> findKMById(Long id);
    void addKm(KhuyenMai khuyenMai);
    void deleteKMById(Long id);
//    void updateKMSP(Long idKm,Long idSp);
}
