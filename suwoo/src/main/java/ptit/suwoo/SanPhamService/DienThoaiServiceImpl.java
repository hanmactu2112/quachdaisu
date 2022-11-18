package ptit.suwoo.SanPhamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptit.suwoo.model.DienThoai;
import ptit.suwoo.sanphamRepository.DienThoaiRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class DienThoaiServiceImpl implements DienThoaiService{
    @Autowired
    DienThoaiRepository dienThoaiRepository;
    @Override
    public void save(DienThoai dt) {
        dienThoaiRepository.save(dt);
    }

    @Override
    public List<DienThoai> findAll() {
        return dienThoaiRepository.findAll();
    }

    @Override
    public Optional<DienThoai> findDtById(Long id) {
        Optional<DienThoai> dt = dienThoaiRepository.findById(id);
        return dt;
    }

    @Override
    public void deleteDTById(Long id) throws SQLException {
        dienThoaiRepository.deleteById(id);
    }
}
