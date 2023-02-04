package ptit.suwoo.sanphamRepository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ptit.suwoo.model.hoadon.HoaDon;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Long> {
    @Override
    <S extends HoaDon> S save(S entity);
    @Query(value = "SELECT * FROM hoadon hd LEFT JOIN magiamgia mgg on hd.magiamgia_id = mgg.id where hd.khachhang_id = ?1 ORDER BY hd.ngay_tao DESC",
            countQuery = "SELECT count(*) FROM hoadon hd LEFT JOIN magiamgia mgg on hd.magiamgia_id = mgg.id where hd.khachhang_id = ?1 ORDER BY hd.ngay_tao DESC",nativeQuery = true)
    Page<HoaDon> findAllHDByUser(Long id,Pageable pageable);
}
