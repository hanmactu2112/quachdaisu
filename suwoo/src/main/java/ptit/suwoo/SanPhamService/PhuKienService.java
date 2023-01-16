package ptit.suwoo.SanPhamService;

import org.springframework.stereotype.Service;
import ptit.suwoo.model.PhuKien;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public interface PhuKienService {

    public void save(PhuKien pk);

    List<PhuKien> findAll();

    public Optional<PhuKien> findPkById(Long id) ;

    void deletePKById(Long id) throws SQLException;
}
