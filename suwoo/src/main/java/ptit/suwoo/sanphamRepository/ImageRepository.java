package ptit.suwoo.sanphamRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptit.suwoo.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {
}
