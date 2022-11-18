package ptit.suwoo.sanphamRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptit.suwoo.model.ManHinh;

@Repository
public interface ManHinhRepository extends JpaRepository<ManHinh,Long> {
}
