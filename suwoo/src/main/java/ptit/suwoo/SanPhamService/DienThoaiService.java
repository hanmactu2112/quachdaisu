package ptit.suwoo.SanPhamService;

import org.springframework.stereotype.Service;
import ptit.suwoo.model.DienThoai;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public interface DienThoaiService {
    public void save(DienThoai dt);
    List<DienThoai> findAll();
    public Optional<DienThoai> findDtById(Long id) ;
    void deleteDTById(Long id) throws SQLException;
}
