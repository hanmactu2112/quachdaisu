package ptit.suwoo.sanphamRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptit.suwoo.model.PhuKien;

@Repository
public interface PhuKienRepository extends JpaRepository<PhuKien, Long> {
}
