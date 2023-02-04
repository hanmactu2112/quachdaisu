package ptit.suwoo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ptit.suwoo.model.KhachHang;
import ptit.suwoo.model.NguoiDung;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang,Long> {
    @Query(value = "Update into nguoi_dung nd Set ng.name =:  khachHang.name where nd.id = khachHang.id",nativeQuery = true)
    KhachHang UpdateNoPass(KhachHang khachHang);

    @Query(value = "Select * from khachhang kh join nguoi_dung nd on kh.id = nd.id where nd.email = ?1",nativeQuery = true)
    Optional<KhachHang> findKhByEmail(String email);

    @Modifying
    @Transactional
    @Query(value = "UPDATE nguoi_dung nd join khachhang kh on kh.id = nd.id set nd.matkhau = ?1  where kh.id = ?2",nativeQuery = true)
    void updatePass(String pass,Long id);
}
