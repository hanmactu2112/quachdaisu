package ptit.suwoo.sanphamRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptit.suwoo.model.Pin;

@Repository
public interface PinRepository extends JpaRepository<Pin,Long> {
}
