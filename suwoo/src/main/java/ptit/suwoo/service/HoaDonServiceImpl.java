package ptit.suwoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ptit.suwoo.model.hoadon.HoaDon;
import ptit.suwoo.sanphamRepository.HoaDonRepository;

@Service
public class HoaDonServiceImpl implements HoaDonService{
    @Autowired
    HoaDonRepository hoaDonRepository;
    @Override
    public Page<HoaDon> findHDUser(int pageNo, int pageSize, Long id) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return hoaDonRepository.findAllHDByUser(id,pageable);
    }
}
