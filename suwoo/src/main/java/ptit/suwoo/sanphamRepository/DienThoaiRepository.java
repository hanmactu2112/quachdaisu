package ptit.suwoo.sanphamRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptit.suwoo.model.DienThoai;

@Repository
public interface DienThoaiRepository extends JpaRepository<DienThoai,Long> {

}
