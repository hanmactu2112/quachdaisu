package ptit.suwoo.sanphamRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ptit.suwoo.model.Image;

@Repository
public interface ImageRepositoryCustom extends JpaRepository<Image,Long>{
    @Override
    void deleteById(Long aLong);
}
