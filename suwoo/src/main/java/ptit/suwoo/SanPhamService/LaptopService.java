package ptit.suwoo.SanPhamService;

import org.springframework.data.domain.Page;
import ptit.suwoo.model.laptopmodel.Laptop;

import java.util.List;
import java.util.Optional;

public interface LaptopService {
    List<Laptop> findAllLT();
    Optional<Laptop> findLTById(Long id);
    void deleteLTById(Long id);
    void saveLt(Laptop lt);
    List<Laptop> findLimit20();

    List<String> findLTByCard(List<String> a);

    Page<Laptop> findFilterLT(List<String> listId,int pageOn,int pageSize, String sort);

    Page<Laptop> findAllLaptop(int pageOn,int pageSize, String sort);

    Optional<Laptop> findLtAndKmById(Long id);
}
