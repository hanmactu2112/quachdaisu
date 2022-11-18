package ptit.suwoo.sanphamRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptit.suwoo.model.KichThuocTrongLuong;

@Repository
public interface KichThuocTrongLuongRepository extends JpaRepository<KichThuocTrongLuong,Long> {
}
