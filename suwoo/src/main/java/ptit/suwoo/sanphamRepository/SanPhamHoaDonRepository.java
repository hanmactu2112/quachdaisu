package ptit.suwoo.sanphamRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ptit.suwoo.model.hoadon.SanPhamHoaDon;

import java.util.List;

@Repository
public interface SanPhamHoaDonRepository extends JpaRepository<SanPhamHoaDon,Long> {

    @Query(value = "SELECT * FROM sanphamhd sp where sp.hoadon_id = ?1",nativeQuery = true)
    List<SanPhamHoaDon> findSPHDByHD(Long id);
}
