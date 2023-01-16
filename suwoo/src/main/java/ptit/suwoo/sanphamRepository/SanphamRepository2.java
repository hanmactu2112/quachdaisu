package ptit.suwoo.sanphamRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ptit.suwoo.Dto.laptopDto.SanPhamJPQL;
import ptit.suwoo.model.DienThoai;
import ptit.suwoo.model.SanPham;
import ptit.suwoo.model.laptopmodel.Laptop;

import java.util.List;
import java.util.Optional;

@Repository
public interface SanphamRepository2 extends JpaRepository<SanPham,Long> {

    @Query(value = "SELECT * FROM dienthoai d JOIN sanpham s on d.id = s.id JOIN khuyenmai k ON s.khuyenmai_id = k.id" +
            " where k.ngaybd <= now() and k.ngaykt >= now() ORDER BY tile DESC LIMIT 20",nativeQuery = true)
    List<DienThoai> searchFlashDeals();

//    @Query(value = "Select * from sanpham s left join dienthoai d on d.id = s.id left join laptop l on l.id = s.id where d.id = 1577 or l.id = 1577",nativeQuery = true)
//    List<? super SanPham> searchProducts();
}
