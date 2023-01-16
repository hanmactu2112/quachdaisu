package ptit.suwoo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ptit.suwoo.model.giohang.GioHang;

import java.util.List;

@Repository
public interface GioHangRepository extends JpaRepository<GioHang,Long> {

    @Query(value = "SELECT * from giohang g where g.khachhang_id = ?1",nativeQuery = true)
    GioHang findAllGioHangActive(Long id);
}
