package ptit.suwoo.service;

import org.springframework.stereotype.Service;

@Service
public interface GioHangSanPhamService {
    void deleteProduct(Long id1);
    void updateCart(Integer quantity,Long id1);
}
