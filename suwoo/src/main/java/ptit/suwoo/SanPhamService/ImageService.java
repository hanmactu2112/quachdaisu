package ptit.suwoo.SanPhamService;


import org.springframework.stereotype.Service;
import ptit.suwoo.model.Image;

import java.util.Optional;

@Service
public interface ImageService {
    void deleteById(Long id);
    void delete(Image img);
    Optional<Image> findById(Long id);
}
