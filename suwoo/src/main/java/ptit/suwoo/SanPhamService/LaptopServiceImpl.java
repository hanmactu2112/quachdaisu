package ptit.suwoo.SanPhamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ptit.suwoo.model.laptopmodel.Laptop;
import ptit.suwoo.sanphamRepository.LaptopRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LaptopServiceImpl implements LaptopService {
    @Autowired
    LaptopRepository laptopRepository;

    @Override
    public List<Laptop> findAllLT() {
        return laptopRepository.findAll();
    }

    @Override
    public Optional<Laptop> findLTById(Long id) {
        return laptopRepository.findById(id);
    }

    @Override
    public void deleteLTById(Long id) {
        laptopRepository.deleteById(id);
    }

    @Override
    public void saveLt(Laptop lt) {
        laptopRepository.save(lt);
    }

    @Override
    public List<Laptop> findLimit20() {
        return laptopRepository.findLimit20();
    }

    @Override
    public List<String> findLTByCard(List<String> a) {
        List<String> lt = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).equals("nVidia") || a.get(i).equals("AMD")) {
                lt.addAll(laptopRepository.findFilterCard(a.get(i)));
            } else lt.addAll(laptopRepository.findFilterCard2());
        }
        return lt;
    }

    @Override
    public Page<Laptop> findFilterLT(List<String> listId,int pageOn, int pageSize, String sort) {
        Pageable pageable = PageRequest.of(pageOn-1,pageSize);
        if (sort !=null){
            if (sort.equals("sortNameASC")) {
                return laptopRepository.filterLtSortNameASC(listId, pageable);
            }
            else if(sort.equals("sortNameDESC")){
                return laptopRepository.filterLtSortNameDESC(listId, pageable);
            }
            else if(sort.equals("sortPriceASC")){
                return laptopRepository.filterLtSortPriceASC(listId, pageable);
            }
            else {
                return laptopRepository.filterLtSortPriceDESC(listId, pageable);
            }
        }
        return laptopRepository.filterLt(listId, pageable);
    }


    @Override
    public Page<Laptop> findAllLaptop(int pageNo, int pageSize, String sort) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        if (sort != null) {
            if (sort.equals("sortNameASC")) {
                return laptopRepository.findAllLaptopsortNameASC(pageable);
            } else if (sort.equals("sortNameDESC")) {
                return laptopRepository.findAllLaptopsortNameDESC(pageable);
            } else if (sort.equals("sortPriceASC")) {
                return laptopRepository.findAllLaptopsortPriceASC(pageable);
            } else {
                return laptopRepository.findAllLaptopsortPriceDESC(pageable);
            }
        }
        return laptopRepository.findAllLaptop(pageable);
    }

    @Override
    public Optional<Laptop> findLtAndKmById(Long id) {
        return laptopRepository.findLtAndKmById(id);
    }
}
