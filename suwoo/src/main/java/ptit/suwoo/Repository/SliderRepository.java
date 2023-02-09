package ptit.suwoo.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ptit.suwoo.model.Slider;

import java.util.List;


@Repository
public interface SliderRepository extends JpaRepository<Slider, Long> {
    @Query(value = "SELECT * FROM slider s ORDER BY s.ngay_tao DESC",
            countQuery = "SELECT COUNT(*) FROM slider s ORDER BY s.ngay_tao DESC", nativeQuery = true)
    Page<Slider> findAllByNgay(Pageable pageable);

    @Query(value = "SELECT COUNT(*) FROM slider", nativeQuery = true)
    int countSlider();

    @Query(value = "SELECT * FROM slider s ORDER BY s.ngay_tao DESC LIMIT 5", nativeQuery = true)
    List<Slider> findSlider();
}
