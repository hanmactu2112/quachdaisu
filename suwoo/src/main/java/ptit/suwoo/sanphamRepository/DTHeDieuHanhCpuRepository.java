package ptit.suwoo.sanphamRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptit.suwoo.model.DTHeDieuHanhCPU;

@Repository
public interface DTHeDieuHanhCpuRepository extends JpaRepository<DTHeDieuHanhCPU,Long> {
}
