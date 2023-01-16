package ptit.suwoo.SanPhamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptit.suwoo.model.Image;
import ptit.suwoo.sanphamRepository.ImageRepositoryCustom;

import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService{
    @Autowired
    ImageRepositoryCustom imageRepository;

    @Override
    public void deleteById(Long id) {
        imageRepository.deleteById(id);
    }

    @Override
    public void delete(Image img) {
        imageRepository.delete(img);
    }

    @Override
    public Optional<Image> findById(Long id) {
        return imageRepository.findById(id);
    }
}
