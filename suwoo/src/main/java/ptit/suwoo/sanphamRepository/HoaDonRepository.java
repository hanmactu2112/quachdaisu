package ptit.suwoo.sanphamRepository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ptit.suwoo.model.hoadon.HoaDon;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Long> {
    @Override
    <S extends HoaDon> S save(S entity);

    @Query(value = "SELECT * FROM hoadon hd LEFT JOIN magiamgia mgg on hd.magiamgia_id = mgg.id where hd.khachhang_id = ?1 ORDER BY hd.ngay_tao DESC",
            countQuery = "SELECT count(*) FROM hoadon hd LEFT JOIN magiamgia mgg on hd.magiamgia_id = mgg.id where hd.khachhang_id = ?1 ORDER BY hd.ngay_tao DESC", nativeQuery = true)
    Page<HoaDon> findAllHDByUser(Long id, Pageable pageable);

    @Query(value = "SELECT * FROM hoadon hd LEFT JOIN magiamgia mgg on hd.magiamgia_id = mgg.id WHERE hd.id = ?1 AND hd.khachhang_id = ?2", nativeQuery = true)
    Optional<HoaDon> findHD(Long id, Long khid);

    @Modifying
    @Transactional
    @Query(value = "UPDATE hoadon hd SET hd.tinhtrang = ?1 WHERE hd.id =  ?2", nativeQuery = true)
    void updateHDTinhTrang(String tinhTrang, Long id) throws Exception;

    @Query(value = "SELECT * FROM hoadon hd LEFT JOIN magiamgia mgg on hd.magiamgia_id = mgg.id where hd.tinhtrang = ?1 ORDER BY hd.ngay_tao DESC",
            countQuery = "SELECT count(*) FROM hoadon hd LEFT JOIN magiamgia mgg on hd.magiamgia_id = mgg.id where hd.tinhtrang = ?1 ORDER BY hd.ngay_tao DESC", nativeQuery = true)
    Page<HoaDon> findAllHDByStatus(String status, Pageable pageable);

    @Query(value = "SELECT * FROM hoadon hd LEFT JOIN magiamgia mgg on hd.magiamgia_id = mgg.id where hd.id LIKE %?1% ORDER BY hd.ngay_tao DESC",
            countQuery = "SELECT count(*) FROM hoadon hd LEFT JOIN magiamgia mgg on hd.magiamgia_id = mgg.id where hd.id LIKE %?1% ORDER BY hd.ngay_tao DESC", nativeQuery = true)
    Page<HoaDon> findAllHD(String id, Pageable pageable);

    @Query(value = "SELECT * FROM hoadon hd LEFT JOIN magiamgia mgg on hd.magiamgia_id = mgg.id where hd.id LIKE %?1%  AND hd.tinhtrang = ?2 ORDER BY hd.ngay_tao DESC",
            countQuery = "SELECT count(*) FROM hoadon hd LEFT JOIN magiamgia mgg on hd.magiamgia_id = mgg.id where hd.id LIKE %?1% AND hd.tinhtrang = ?2 ORDER BY hd.ngay_tao DESC", nativeQuery = true)
    Page<HoaDon> findAllHD(String id, String status, Pageable pageable);

    @Query(value = "SELECT * FROM hoadon hd LEFT JOIN magiamgia mgg on hd.magiamgia_id = mgg.id ORDER BY hd.ngay_tao DESC",
            countQuery = "SELECT count(*) FROM hoadon hd LEFT JOIN magiamgia mgg on hd.magiamgia_id = mgg.id ORDER BY hd.ngay_tao DESC", nativeQuery = true)
    Page<HoaDon> findAllHD(Pageable pageable);

    @Query(value = "SELECT * FROM hoadon hd LEFT JOIN magiamgia mgg on hd.magiamgia_id = mgg.id WHERE hd.id = ?1", nativeQuery = true)
    Optional<HoaDon> findHDById(Long id);
}
