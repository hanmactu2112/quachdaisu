package ptit.suwoo.service;

import org.springframework.stereotype.Service;
import ptit.suwoo.model.NguoiDung;

@Service
public class NguoiDungImp implements NguoiDungService{
    @Override
    public NguoiDung loadNguoiDungByUsername(String username) {
        return null;
    }

    @Override
    public NguoiDung findAllNguoiDung() {
        return null;
    }

    @Override
    public boolean deleteNguoiDungById(Long id) {
        return false;
    }

    @Override
    public void editNguoiDungById(Long id) {

    }
}
