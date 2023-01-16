package ptit.suwoo.SanPhamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ptit.suwoo.model.DienThoai;
import ptit.suwoo.sanphamRepository.DienThoaiRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class DienThoaiServiceImpl implements DienThoaiService{
    @Autowired
    DienThoaiRepository dienThoaiRepository;
    @Override
    public void save(DienThoai dt) {
        dienThoaiRepository.save(dt);
    }

    @Override
    public List<DienThoai> findAll() {
        return dienThoaiRepository.findAll();
    }

    @Override
    public Optional<DienThoai> findDtById(Long id) {
        Optional<DienThoai> dt = dienThoaiRepository.findById(id);
        return dt;
    }

    @Override
    public Optional<DienThoai> findDtAndKmById(Long id) {
        return dienThoaiRepository.findDtAndKmById(id);
    }

    @Override
    public void deleteDTById(Long id) throws SQLException {
        dienThoaiRepository.deleteById(id);
    }

    @Override
    public List<DienThoai> findLimit20() {
        return dienThoaiRepository.findLimit20();
    }

    @Override
    public List<DienThoai> findAllDtByIdCategory(Long id) {
        return dienThoaiRepository.findAllDtByIdCategory(id);
    }

    @Override
    public Page<DienThoai> findAllDtClient(int pageNo, int pageSize,String sort) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        if (sort !=null){
            if (sort.equals("sortNameASC")) {
                return dienThoaiRepository.findAllDtClientsortNameASC(pageable);
            }
            else if(sort.equals("sortNameDESC")){
                return dienThoaiRepository.findAllDtClientsortNameDESC(pageable);
            }
            else if(sort.equals("sortPriceASC")){
                return dienThoaiRepository.findAllDtClientsortPriceASC(pageable);
            }
            else {
                return dienThoaiRepository.findAllDtClientsortPriceDESC(pageable);
            }
        }
        return dienThoaiRepository.findAllDtClient(pageable);
    }

    @Override
    public List<String> findAllHang() {
        return dienThoaiRepository.findAllHang();
    }

    @Override
    public List<String> groupByDPG() {
        return dienThoaiRepository.groupByDPG();
    }

    @Override
    public List<String> groupByDTBN() {
        return dienThoaiRepository.groupByDTBN();
    }

    @Override
    public List<String> groupByRAM() {
        return dienThoaiRepository.groupByRAM();
    }

    @Override
    public List<String> groupByTinhNangCam() {
        return dienThoaiRepository.groupByTinhNangCam();
    }

    @Override
    public Page<DienThoai> filterDt(List<String> sql, int pageNo, int pageSize,String sort) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        if (sort !=null){
            if (sort.equals("sortNameASC")) {
                return dienThoaiRepository.filterDtSortNameASC(sql,pageable);
            }
            else if(sort.equals("sortNameDESC")){
                return dienThoaiRepository.filterDtSortNameDESC(sql,pageable);
            }
            else if(sort.equals("sortPriceASC")){
                return dienThoaiRepository.filterDtSortPriceASC(sql,pageable);
            }
            else {
                return dienThoaiRepository.filterDtSortPriceDESC(sql,pageable);
            }
        }
        else return dienThoaiRepository.filterDt(sql,pageable);
    }
}
