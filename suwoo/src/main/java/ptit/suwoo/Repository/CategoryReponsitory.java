package ptit.suwoo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ptit.suwoo.model.Category;
import ptit.suwoo.model.DienThoai;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface CategoryReponsitory extends JpaRepository<Category,Long> {

    @Override
    void deleteById(Long aLong);

    @Query(value = "select c.id,c.loai,c.ten from category c join sanpham s on c.id = s.category_id " +
            "join dienthoai d on d.id = s.id where d.id = ?1",nativeQuery = true)
    Category searchCategoryByDt(Long idDt);
    @Query(value = "select c.id,c.loai,c.ten from category c join sanpham s on c.id = s.category_id " +
            "join laptop d on d.id = s.id where d.id = ?1",nativeQuery = true)
    Category searchCategoryByLt(Long idLt);
}
