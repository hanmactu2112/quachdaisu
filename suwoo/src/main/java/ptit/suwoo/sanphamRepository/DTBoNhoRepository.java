package ptit.suwoo.sanphamRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptit.suwoo.model.DTBoNho;

@Repository
public interface DTBoNhoRepository extends JpaRepository<DTBoNho,Long> {
}
