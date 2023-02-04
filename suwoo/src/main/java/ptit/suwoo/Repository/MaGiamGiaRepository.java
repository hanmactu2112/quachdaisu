package ptit.suwoo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ptit.suwoo.model.maGiamGia.MaGiamGia;

import java.util.Optional;

public interface MaGiamGiaRepository extends JpaRepository<MaGiamGia,Long> {

    @Query(value = "SELECT * from magiamgia m join category c on m.category_id = c.id where m.code = ?1",nativeQuery = true)
    Optional<MaGiamGia> findMGGByCode(String code);


}
