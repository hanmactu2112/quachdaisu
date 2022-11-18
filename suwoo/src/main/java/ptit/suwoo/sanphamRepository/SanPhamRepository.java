package ptit.suwoo.sanphamRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptit.suwoo.model.SanPham;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham,Long> {
}
