package ptit.suwoo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ptit.suwoo.model.maGiamGia.KhachHangMaGiamGia;

import javax.transaction.Transactional;
import java.util.Optional;

public interface KhachHangMaGiamGiaRepository extends JpaRepository<KhachHangMaGiamGia,Long> {

    @Query(value = "SELECT * from khachhang_magiamgia khmgg join khachhang kh on kh.id = khmgg.khachhang_id " +
            "join magiamgia mgg on mgg.id = khmgg.magiamgia_id where khmgg.khachhang_id = ?1 and mgg.code = ?2 and khmgg.trangthai = 1",nativeQuery = true)
    Optional<KhachHangMaGiamGia> checkActiveMGG(Long idKh,String code);

    @Modifying
    @Transactional
    @Query(value = "UPDATE khachhang_magiamgia khmgg join khachhang kh on kh.id = khmgg.khachhang_id " +
            "join magiamgia mgg on mgg.id = khmgg.magiamgia_id  SET khmgg.trangthai = 0 where khmgg.khachhang_id = ?1 and mgg.code = ?2",nativeQuery = true)
    void updateKHMGG(Long idKh,String code);
}
