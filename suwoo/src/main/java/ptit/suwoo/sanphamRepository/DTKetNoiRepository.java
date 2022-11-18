package ptit.suwoo.sanphamRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptit.suwoo.model.DTKetNoi;

@Repository
public interface DTKetNoiRepository extends JpaRepository<DTKetNoi,Long> {
}
