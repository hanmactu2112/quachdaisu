package ptit.suwoo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ptit.suwoo.model.KhachHang;
import ptit.suwoo.model.NguoiDung;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang,Long> {
    @Query(value = "Update into NguoiDung nd Set ng.name =:  khachHang.name where nd.id = khachHang.id",nativeQuery = true)
    KhachHang UpdateNoPass(KhachHang khachHang);
}
