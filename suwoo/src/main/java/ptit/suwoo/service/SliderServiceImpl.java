package ptit.suwoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ptit.suwoo.Repository.SliderRepository;
import ptit.suwoo.model.Slider;

import java.sql.SQLException;

@Service
public class SliderServiceImpl implements SliderService{
    @Autowired
    SliderRepository sliderRepository;
    @Override
    public Page<Slider> findAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return sliderRepository.findAllByNgay(pageable);
    }

    @Override
    public void deleteSlideById(Long id) throws SQLException {
        sliderRepository.deleteById(id);
    }
}
