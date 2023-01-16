package ptit.suwoo.SanPhamService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ptit.suwoo.model.DienThoai;
import ptit.suwoo.model.SanPham;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public interface DienThoaiService {
    public void save(DienThoai dt);
    List<DienThoai> findAll();
    Optional<DienThoai> findDtById(Long id) ;

    Optional<DienThoai> findDtAndKmById(Long id);
    void deleteDTById(Long id) throws SQLException;
    List<DienThoai> findLimit20();
    List<DienThoai> findAllDtByIdCategory(Long id);
    Page<DienThoai> findAllDtClient(int pageNo , int pageSize,String sort);
    List<String> findAllHang();
    List<String> groupByDPG();
    List<String> groupByDTBN();
    List<String> groupByRAM();
    List<String> groupByTinhNangCam();

    Page<DienThoai> filterDt(List<String> sql, int pageNo , int pageSize,String sort);

}
