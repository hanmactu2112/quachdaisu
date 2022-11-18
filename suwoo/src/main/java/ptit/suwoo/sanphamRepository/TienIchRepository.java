package ptit.suwoo.sanphamRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptit.suwoo.model.TienIch;

@Repository
public interface TienIchRepository extends JpaRepository<TienIch,Long> {
}
