package ptit.suwoo.service;


import org.springframework.stereotype.Service;
import ptit.suwoo.model.giohang.GioHang;

import java.util.List;

@Service
public interface GioHangService {
    GioHang findAllGioHangActive(Long id);
}
