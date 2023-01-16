package ptit.suwoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptit.suwoo.Repository.GioHangSanPhamRepository;

import javax.transaction.Transactional;

@Service
public class GioHangSanPhamServiceImpl implements GioHangSanPhamService{
    @Autowired
    GioHangSanPhamRepository gioHangSanPhamRepository;
    @Override
    public void deleteProduct(Long id1) {
        gioHangSanPhamRepository.deleteProduct(id1);
    }
}
