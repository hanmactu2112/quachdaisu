package ptit.suwoo.sanphamRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ptit.suwoo.model.SanPham;

import java.util.List;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham,Long> {
//    @Modifying
//    @Transactional
//    @Query(value = "UPDATE sanpham s SET s.khuyenmai_id = ?1 WHERE s.id = ?2",nativeQuery = true)
//    void updateKMSP(Long idKm,Long idSp);

}
