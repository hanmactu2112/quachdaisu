package ptit.suwoo.sanphamRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ptit.suwoo.model.DienThoai;

import java.util.List;
import java.util.Optional;

@Repository
public interface DienThoaiRepository extends JpaRepository<DienThoai,Long> {
    @Query(value = "SELECT * FROM dienthoai d JOIN sanpham s on d.id = s.id LEFT JOIN khuyenmai k on s.khuyenmai_id = k.id " +
            " where s.active = 1 ORDER BY s.ngay_dangsp DESC LIMIT 10",nativeQuery = true)
    List<DienThoai> findLimit20();
    @Query(value = "SELECT * FROM dienthoai d JOIN sanpham s on d.id = s.id LEFT JOIN khuyenmai k on s.khuyenmai_id = k.id " +
            " where d.id = ?1",nativeQuery = true)
    Optional<DienThoai> findDtAndKmById(Long id);
    @Query(value = "SELECT * FROM dienthoai d JOIN sanpham s on d.id = s.id LEFT JOIN category c on s.category_id = c.id LEFT JOIN khuyenmai k on s.khuyenmai_id = k.id " +
            " where c.id = ?1",nativeQuery = true)
    List<DienThoai> findAllDtByIdCategory(Long id);
    @Query(value = "SELECT * FROM dienthoai d JOIN sanpham s on d.id = s.id LEFT JOIN khuyenmai k on s.khuyenmai_id = k.id ",
            countQuery = "SELECT count(*) FROM dienthoai d JOIN sanpham s on d.id = s.id LEFT JOIN khuyenmai k on s.khuyenmai_id = k.id",nativeQuery = true)
    Page<DienThoai> findAllDtClient(Pageable pageable);
    @Query(value = "SELECT * FROM dienthoai d JOIN sanpham s on d.id = s.id LEFT JOIN khuyenmai k on s.khuyenmai_id = k.id ORDER BY s.tensp ASC",
            countQuery = "SELECT count(*) FROM dienthoai d JOIN sanpham s on d.id = s.id LEFT JOIN khuyenmai k on s.khuyenmai_id = k.id ORDER BY s.tensp ASC",nativeQuery = true)
    Page<DienThoai> findAllDtClientsortNameASC(Pageable pageable);
    @Query(value = "SELECT * FROM dienthoai d JOIN sanpham s on d.id = s.id LEFT JOIN khuyenmai k on s.khuyenmai_id = k.id ORDER BY s.tensp DESC",
            countQuery = "SELECT count(*) FROM dienthoai d JOIN sanpham s on d.id = s.id LEFT JOIN khuyenmai k on s.khuyenmai_id = k.id ORDER BY s.tensp DESC",nativeQuery = true)
    Page<DienThoai> findAllDtClientsortNameDESC(Pageable pageable);
    @Query(value = "SELECT * FROM dienthoai d JOIN sanpham s on d.id = s.id LEFT JOIN khuyenmai k on s.khuyenmai_id = k.id ORDER BY s.gia ASC",
            countQuery = "SELECT count(*) FROM dienthoai d JOIN sanpham s on d.id = s.id LEFT JOIN khuyenmai k on s.khuyenmai_id = k.id ORDER BY s.gia ASC",nativeQuery = true)
    Page<DienThoai> findAllDtClientsortPriceASC(Pageable pageable);
    @Query(value = "SELECT * FROM dienthoai d JOIN sanpham s on d.id = s.id LEFT JOIN khuyenmai k on s.khuyenmai_id = k.id ORDER BY s.gia DESC",
            countQuery = "SELECT count(*) FROM dienthoai d JOIN sanpham s on d.id = s.id LEFT JOIN khuyenmai k on s.khuyenmai_id = k.id ORDER BY s.gia DESC",nativeQuery = true)
    Page<DienThoai> findAllDtClientsortPriceDESC(Pageable pageable);

    @Query(value = "SELECT s.hang from dienthoai d join sanpham s on d.id = s.id group by s.hang",nativeQuery = true)
    List<String> findAllHang();
    @Query(value = "SELECT h.dophangiai from dienthoai d join sanpham s on d.id = s.id left join manhinh h on d.manhinh_id = h.id  group by h.dophangiai",nativeQuery = true)
    List<String> groupByDPG();

    @Query(value = "SELECT s.tensp from dienthoai d join sanpham s on d.id = s.id where s.hang in (?1)",nativeQuery = true)
    List<String> selectAllDtByHang(List<String> list);

    @Query(value = "SELECT a.rom from dienthoai d join sanpham s on d.id = s.id left join dtbonho a on d.dtbonho_id = a.id  group by a.rom",nativeQuery = true)
    List<String> groupByDTBN();
    @Query(value = "SELECT a.ram from dienthoai d join sanpham s on d.id = s.id left join dtbonho a on d.dtbonho_id = a.id  group by a.ram",nativeQuery = true)
    List<String> groupByRAM();
    @Query(value = "SELECT a.tinhnang from dienthoai d join sanpham s on d.id = s.id left join camera a on d.id = a.dienthoai_id  group by a.tinhnang",nativeQuery = true)
    List<String> groupByTinhNangCam();
    @Query(value = "SELECT * FROM dienthoai d join sanpham s on d.id = s.id left " +
            "JOIN khuyenmai k on s.khuyenmai_id = k.id WHERE d.id IN ?1",
            countQuery = "SELECT count(*) FROM dienthoai d join sanpham s on d.id = s.id left " +
            "JOIN khuyenmai k on s.khuyenmai_id = k.id  WHERE d.id IN ?1",nativeQuery = true)
    Page<DienThoai> filterDt(List<String> a, Pageable pageable);
    @Query(value = "SELECT * FROM dienthoai d join sanpham s on d.id = s.id left " +
            "JOIN khuyenmai k on s.khuyenmai_id = k.id WHERE d.id IN ?1 ORDER BY s.tensp ASC",
            countQuery = "SELECT count(*) FROM dienthoai d join sanpham s on d.id = s.id left " +
                    "JOIN khuyenmai k on s.khuyenmai_id = k.id  WHERE d.id IN ?1 ORDER BY s.tensp ASC",nativeQuery = true)
    Page<DienThoai> filterDtSortNameASC(List<String> a, Pageable pageable);
    @Query(value = "SELECT * FROM dienthoai d join sanpham s on d.id = s.id left " +
            "JOIN khuyenmai k on s.khuyenmai_id = k.id WHERE d.id IN ?1 ORDER BY s.tensp DESC",
            countQuery = "SELECT count(*) FROM dienthoai d join sanpham s on d.id = s.id left " +
                    "JOIN khuyenmai k on s.khuyenmai_id = k.id  WHERE d.id IN ?1 ORDER BY s.tensp DESC",nativeQuery = true)
    Page<DienThoai> filterDtSortNameDESC(List<String> a, Pageable pageable);
    @Query(value = "SELECT * FROM dienthoai d join sanpham s on d.id = s.id left " +
            "JOIN khuyenmai k on s.khuyenmai_id = k.id WHERE d.id IN ?1 ORDER BY s.gia DESC",
            countQuery = "SELECT count(*) FROM dienthoai d join sanpham s on d.id = s.id left " +
                    "JOIN khuyenmai k on s.khuyenmai_id = k.id  WHERE d.id IN ?1 ORDER BY s.gia DESC",nativeQuery = true)
    Page<DienThoai> filterDtSortPriceDESC(List<String> a, Pageable pageable);
    @Query(value = "SELECT * FROM dienthoai d join sanpham s on d.id = s.id left " +
            "JOIN khuyenmai k on s.khuyenmai_id = k.id WHERE d.id IN ?1 ORDER BY s.gia ASC",
            countQuery = "SELECT count(*) FROM dienthoai d join sanpham s on d.id = s.id left " +
                    "JOIN khuyenmai k on s.khuyenmai_id = k.id  WHERE d.id IN ?1 ORDER BY s.gia ASC",nativeQuery = true)
    Page<DienThoai> filterDtSortPriceASC(List<String> a, Pageable pageable);
    @Query(value = "SELECT d.id FROM dienthoai d join sanpham s on d.id = s.id JOIN pin p on  d.pin_id = p.id " +
            "WHERE p.dungluong < 3000",nativeQuery = true)
    List<String> filterPin1();
    @Query(value = "SELECT d.id FROM dienthoai d join sanpham s on d.id = s.id JOIN pin p on  d.pin_id = p.id " +
            "WHERE p.dungluong >= 3000 AND p.dungluong <=5000",nativeQuery = true)
    List<String> filterPin2();
    @Query(value = "SELECT d.id FROM dienthoai d join sanpham s on d.id = s.id JOIN pin p on  d.pin_id = p.id " +
            "WHERE p.dungluong > 5000",nativeQuery = true)
    List<String> filterPin3();
    @Query(value = "SELECT d.id FROM dienthoai d join sanpham s on d.id = s.id JOIN manhinh m on  d.manhinh_id = m.id " +
            "WHERE m.dophangiai like %?1% ",nativeQuery = true)
    List<String> filterDPG(String a);
    @Query(value = "SELECT d.id FROM dienthoai d join sanpham s on d.id = s.id JOIN manhinh m on  d.manhinh_id = m.id " +
            "WHERE m.kichthuoc >=6",nativeQuery = true)
    List<String> filterKT1();
    @Query(value = "SELECT d.id FROM dienthoai d join sanpham s on d.id = s.id JOIN manhinh m on  d.manhinh_id = m.id " +
            "WHERE m.kichthuoc <=6",nativeQuery = true)
    List<String> filterKT2();
    @Query(value = "SELECT d.id FROM dienthoai d join sanpham s on d.id = s.id JOIN camera c on  c.dienthoai_id = d.id " +
            "WHERE c.tinhnang like %?1% ",nativeQuery = true)
    List<String> filterCamera(String a);
    @Query(value = "SELECT d.id FROM dienthoai d join sanpham s on d.id = s.id WHERE s.hang in ?1",nativeQuery = true)
    List<String> filterHang(List<String> a);
    @Query(value = "SELECT d.id FROM dienthoai d join sanpham s on d.id = s.id WHERE s.gia>=?1 AND s.gia <=?2",nativeQuery = true)
    List<String> filterGia(Integer a, Integer b);
    @Query(value = "SELECT d.id FROM dienthoai d join sanpham s on d.id = s.id join dtbonho bn on d.dtbonho_id = bn.id where bn.rom in ?1 ",nativeQuery = true)
    List<String> filterROM(List<String> a);
    @Query(value = "SELECT d.id FROM dienthoai d join sanpham s on d.id = s.id join dtbonho bn on d.dtbonho_id = bn.id where bn.ram in ?1 ",nativeQuery = true)
    List<String> filterRAM(List<String> a);
    @Query(value = "SELECT d.id FROM dienthoai d join sanpham s on d.id = s.id join dthedieuhanhcpu hdh on d.dthedieuhanhcpu_id = hdh.id where hdh.hedieuhanh like %?1%",nativeQuery = true)
    List<String> filterHDH(String a);

}
