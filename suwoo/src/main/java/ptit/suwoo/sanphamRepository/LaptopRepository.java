package ptit.suwoo.sanphamRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ptit.suwoo.model.DienThoai;
import ptit.suwoo.model.laptopmodel.Laptop;

import java.util.List;
import java.util.Optional;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop,Long> {
    @Query(value = "SELECT * FROM laptop d JOIN sanpham s on d.id = s.id LEFT JOIN khuyenmai k on s.khuyenmai_id = k.id " +
            " where s.active = 1 ORDER BY s.ngay_dangsp DESC LIMIT 10",nativeQuery = true)
    List<Laptop> findLimit20();

    //Tim tat ca cac hang laptop
    @Query(value = "SELECT s.hang from laptop l join sanpham s on l.id = s.id group by s.hang order by s.hang",nativeQuery = true)
    List<String> findAllHangLt();

    //Group by CPU
    @Query(value = "SELECT pu.tencpu from laptop l join sanpham s on l.id = s.id join ltcpu pu on pu.id = l.ltcpu_id group by pu.tencpu order by pu.tencpu",nativeQuery = true)
    List<String> findAllTenCPULt();

    //Group by Ram
    @Query(value = "SELECT r.dungluongram from laptop l join sanpham s on l.id = s.id join ram_ocung r on r.id = l.lt_ram_o_cung_id group by r.dungluongram",nativeQuery = true)
    List<String> findAllRamLt();

    //Group by Rom
    @Query(value = "SELECT r.ocung from laptop l join sanpham s on l.id = s.id join ram_ocung r on l.lt_ram_o_cung_id=r.id group by r.ocung",nativeQuery = true)
    List<String> findAllRomLt();

    //Group by Kich thuoc Man hinh
    @Query(value = "SELECT mh.kichthuoc from laptop l join sanpham s on l.id = s.id join manhinhlt mh on l.man_hinh_lt_id = mh.id  group by mh.kichthuoc order by mh.kichthuoc",nativeQuery = true)
    List<String> findAllKichThuoc();

    //Group by do phan giai Man hinh
    @Query(value = "SELECT mh.dophangiai from laptop l join sanpham s on l.id = s.id join manhinhlt mh on l.man_hinh_lt_id = mh.id  group by mh.dophangiai order by mh.dophangiai",nativeQuery = true)
    List<String> findAllDoPhanGiai();

    //Group by tan so quet Man hinh
    @Query(value = "SELECT mh.tansoquet from laptop l join sanpham s on l.id = s.id join manhinhlt mh on l.man_hinh_lt_id = mh.id  group by mh.tansoquet order by mh.tansoquet;",nativeQuery = true)
    List<String> findAllTanSoQuet();

    //find all laptop
    @Query(value = "SELECT * from laptop l join sanpham s on l.id = s.id left join khuyenmai k on s.khuyenmai_id = k.id WHERE s.active = 1",
            countQuery = "SELECT count(*) from laptop l join sanpham s on l.id = s.id left join khuyenmai k on s.khuyenmai_id = k.id WHERE s.active = 1",nativeQuery = true)
    Page<Laptop> findAllLaptop(Pageable pageable);

    @Query(value = "SELECT * from laptop l join sanpham s on l.id = s.id left join khuyenmai k on s.khuyenmai_id = k.id WHERE s.active = 1 order by s.tensp ASC",
            countQuery = "SELECT count(*) from laptop l join sanpham s on l.id = s.id left join khuyenmai k on s.khuyenmai_id = k.id WHERE s.active = 1 order by s.tensp ASC",nativeQuery = true)
    Page<Laptop> findAllLaptopsortNameASC(Pageable pageable);

    @Query(value = "SELECT * from laptop l join sanpham s on l.id = s.id left join khuyenmai k on s.khuyenmai_id = k.id WHERE s.active = 1 order by s.tensp DESC",
            countQuery = "SELECT count(*) from laptop l join sanpham s on l.id = s.id left join khuyenmai k on s.khuyenmai_id = k.id WHERE s.active = 1 order by s.tensp DESC",nativeQuery = true)
    Page<Laptop> findAllLaptopsortNameDESC(Pageable pageable);

    @Query(value = "SELECT * from laptop l join sanpham s on l.id = s.id left join khuyenmai k on s.khuyenmai_id = k.id WHERE s.active = 1 order by s.gia ASC",
            countQuery = "SELECT count(*) from laptop l join sanpham s on l.id = s.id left join khuyenmai k on s.khuyenmai_id = k.id WHERE s.active = 1 order by s.gia ASC",nativeQuery = true)
    Page<Laptop> findAllLaptopsortPriceASC(Pageable pageable);

    @Query(value = "SELECT * from laptop l join sanpham s on l.id = s.id left join khuyenmai k on s.khuyenmai_id = k.id WHERE s.active = 1 order by s.gia DESC",
            countQuery = "SELECT count(*) from laptop l join sanpham s on l.id = s.id left join khuyenmai k on s.khuyenmai_id = k.id WHERE s.active = 1 order by s.gia DESC",nativeQuery = true)
    Page<Laptop> findAllLaptopsortPriceDESC(Pageable pageable);

    @Query(value = "Select l.id from laptop l join sanpham s on l.id = s.id WHERE s.active = 1 AND s.hang IN ?1",nativeQuery = true)
    List<String> findFilterHang(List<String> a);

    @Query(value = "Select l.id from laptop l join sanpham s on l.id = s.id join ltcpu c on l.ltcpu_id = c.id WHERE c.tencpu LIKE %?1% AND s.active = 1",nativeQuery = true)
    List<String> findFilterCPU(String a);
    @Query(value = "Select l.id from laptop l join sanpham s on l.id = s.id join manhinhlt mh on l.man_hinh_lt_id = mh.id WHERE mh.kichthuoc IN ?1 AND s.active = 1",nativeQuery = true)
    List<String> findFilterKT(List<String> a);

    @Query(value = "Select l.id from laptop l join sanpham s on l.id = s.id join manhinhlt mh on l.man_hinh_lt_id = mh.id WHERE mh.dophangiai IN ?1 AND s.active = 1",nativeQuery = true)
    List<String> findFilterDPG(List<String> a);

    @Query(value = "Select l.id from laptop l join sanpham s on l.id = s.id join ram_ocung ro on l.lt_ram_o_cung_id = ro.id WHERE ro.ocung IN ?1 AND s.active = 1",nativeQuery = true)
    List<String> findFilterBN(List<String> a);

    @Query(value = "Select l.id from laptop l join sanpham s on l.id = s.id join ram_ocung ro on l.lt_ram_o_cung_id = ro.id WHERE ro.dungluongram IN ?1 AND s.active = 1",nativeQuery = true)
    List<String> findFilterRam(List<String> a);

    @Query(value = "Select l.id from laptop l join sanpham s on l.id = s.id join manhinhlt mh on l.man_hinh_lt_id = mh.id WHERE mh.tansoquet IN ?1 AND s.active = 1",nativeQuery = true)
    List<String> findFilterTanSoQuet(List<String> a);

    @Query(value = "Select l.id from laptop l join sanpham s on l.id = s.id WHERE s.gia >= ?1 AND s.gia <= ?2 AND s.active = 1",nativeQuery = true)
    List<String> findFilterGia(Integer a,Integer b);

    @Query(value = "Select l.id from laptop l join sanpham s on l.id = s.id join ltdohoavaamthanh car on l.lt_do_hoa_va_am_thanh_id = car.id WHERE car.carddohoa LIKE %?1% AND s.active = 1",nativeQuery = true)
    List<String> findFilterCard(String a);

    @Query(value = "Select l.id from laptop l join sanpham s on l.id = s.id join ltdohoavaamthanh car on l.lt_do_hoa_va_am_thanh_id = car.id WHERE car.carddohoa NOT LIKE '%nVidia%' AND car.carddohoa NOT LIKE '%AMD%' AND s.active = 1",nativeQuery = true)
    List<String> findFilterCard2();

    @Query(value = "SELECT * FROM laptop d join sanpham s on d.id = s.id left " +
            "JOIN khuyenmai k on s.khuyenmai_id = k.id WHERE d.id IN ?1",
            countQuery = "SELECT count(*) FROM laptop d join sanpham s on d.id = s.id left " +
                    "JOIN khuyenmai k on s.khuyenmai_id = k.id  WHERE d.id IN ?1",nativeQuery = true)
    Page<Laptop> filterLt(List<String> a, Pageable pageable);

    @Query(value = "SELECT * FROM laptop d join sanpham s on d.id = s.id left " +
            "JOIN khuyenmai k on s.khuyenmai_id = k.id WHERE d.id IN ?1 ORDER BY s.tensp ASC",
            countQuery = "SELECT count(*) FROM laptop d join sanpham s on d.id = s.id left " +
                    "JOIN khuyenmai k on s.khuyenmai_id = k.id  WHERE d.id IN ?1 ORDER BY s.tensp ASC",nativeQuery = true)
    Page<Laptop> filterLtSortNameASC(List<String> a, Pageable pageable);

    @Query(value = "SELECT * FROM laptop d join sanpham s on d.id = s.id left " +
            "JOIN khuyenmai k on s.khuyenmai_id = k.id WHERE d.id IN ?1 ORDER BY s.tensp DESC",
            countQuery = "SELECT count(*) FROM laptop d join sanpham s on d.id = s.id left " +
                    "JOIN khuyenmai k on s.khuyenmai_id = k.id  WHERE d.id IN ?1 ORDER BY s.tensp DESC",nativeQuery = true)
    Page<Laptop> filterLtSortNameDESC(List<String> a, Pageable pageable);

    @Query(value = "SELECT * FROM laptop d join sanpham s on d.id = s.id left " +
            "JOIN khuyenmai k on s.khuyenmai_id = k.id WHERE d.id IN ?1 ORDER BY s.gia DESC",
            countQuery = "SELECT count(*) FROM laptop d join sanpham s on d.id = s.id left " +
                    "JOIN khuyenmai k on s.khuyenmai_id = k.id  WHERE d.id IN ?1 ORDER BY s.gia DESC",nativeQuery = true)
    Page<Laptop> filterLtSortPriceDESC(List<String> a, Pageable pageable);

    @Query(value = "SELECT * FROM laptop d join sanpham s on d.id = s.id left " +
            "JOIN khuyenmai k on s.khuyenmai_id = k.id WHERE d.id IN ?1 ORDER BY s.gia ASC",
            countQuery = "SELECT count(*) FROM laptop d join sanpham s on d.id = s.id left " +
                    "JOIN khuyenmai k on s.khuyenmai_id = k.id  WHERE d.id IN ?1 ORDER BY s.gia ASC",nativeQuery = true)
    Page<Laptop> filterLtSortPriceASC(List<String> a, Pageable pageable);

    @Query(value = "SELECT * from laptop l join sanpham s on l.id = s.id left join khuyenmai k on s.khuyenmai_id = k.id where l.id = ?1",nativeQuery = true)
    Optional<Laptop> findLtAndKmById(Long id);

    @Query(value = "SELECT * FROM laptop d JOIN sanpham s on d.id = s.id LEFT JOIN category c on s.category_id = c.id LEFT JOIN khuyenmai k on s.khuyenmai_id = k.id " +
            " where c.id = ?1",nativeQuery = true)
    List<Laptop> findAllLtByIdCategory(Long id);
}
