package ptit.suwoo.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ptit.suwoo.model.hoadon.HoaDon;

@Service
public interface HoaDonService {

    Page<HoaDon> findHDUser(int pageNo, int pageSize,Long id);

}
