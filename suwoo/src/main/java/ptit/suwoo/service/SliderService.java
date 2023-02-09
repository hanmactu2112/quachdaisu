package ptit.suwoo.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ptit.suwoo.model.Slider;

import java.sql.SQLException;

@Service
public interface SliderService {
    Page<Slider> findAll(int pageNo,int pageSize);

    void deleteSlideById(Long id) throws SQLException;

}
