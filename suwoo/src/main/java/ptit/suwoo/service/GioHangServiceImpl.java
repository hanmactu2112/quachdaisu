package ptit.suwoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptit.suwoo.Repository.GioHangRepository;
import ptit.suwoo.model.giohang.GioHang;

import java.util.List;

@Service
public class GioHangServiceImpl implements GioHangService{
    @Autowired
    GioHangRepository gioHangRepository;
    @Override
    public GioHang findAllGioHangActive(Long id) {
        return gioHangRepository.findAllGioHangActive(id);
    }
}
