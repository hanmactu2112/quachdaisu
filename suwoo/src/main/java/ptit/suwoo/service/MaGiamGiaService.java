package ptit.suwoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import ptit.suwoo.Repository.MaGiamGiaRepository;
import ptit.suwoo.model.maGiamGia.MaGiamGia;

import java.util.List;
import java.util.Optional;

public interface MaGiamGiaService {
    List<MaGiamGia> findAll();
    Optional<MaGiamGia> findById(Long id);
    void save(MaGiamGia m);
    void delete(Long id);
}
