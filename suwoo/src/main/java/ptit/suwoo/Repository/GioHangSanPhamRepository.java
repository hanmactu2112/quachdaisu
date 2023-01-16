package ptit.suwoo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ptit.suwoo.model.giohang.GioHangSanPham;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface GioHangSanPhamRepository extends JpaRepository<GioHangSanPham,Long> {

    @Query(value = "select * from giohangsp gs join giohang gh on gh.id = gs.giohang_id join sanpham s on gs.sanpham_id = s.id where gs.giohang_id = ?1", nativeQuery = true)
    List<GioHangSanPham> findAllByGioHangId(Long id);
    @Query(value = "select * from giohangsp gs join giohang gh on gh.id = gs.giohang_id join sanpham s on gs.sanpham_id = s.id where gs.sanpham_id = ?1 and gs.giohang_id = ?2", nativeQuery = true)
    Optional<GioHangSanPham> findSpInGioHangId(Long id,Long idGH);
    @Query(value = "Select count(gs.sanpham_id) from giohangsp gs join giohang g on g.id = gs.giohang_id join khachhang kh on kh.id = g.khachhang_id where kh.id = ?1", nativeQuery = true)
    Integer countProduct(Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM giohangsp gs WHERE gs.id=?1", nativeQuery = true)
    void deleteProduct(Long id1);


}
