package ptit.suwoo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ptit.suwoo.model.NguoiDung;
public interface NguoiDungService {
    NguoiDung loadNguoiDungByUsername(String username);
    NguoiDung findAllNguoiDung();
    boolean deleteNguoiDungById(Long id);
    void editNguoiDungById(Long id);
}
