package ptit.suwoo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import ptit.suwoo.model.NguoiDung;

@Repository
public interface NguoiDungRepository extends JpaRepository<NguoiDung,Long> {
    NguoiDung findByEmail(String email);
}
