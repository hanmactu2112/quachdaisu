package ptit.suwoo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptit.suwoo.model.Category;

import java.sql.SQLException;

@Repository
public interface CategoryReponsitory extends JpaRepository<Category,Long> {

    @Override
    void deleteById(Long aLong);
}
