package ptit.suwoo.service;

import org.springframework.stereotype.Service;
import ptit.suwoo.model.Admin;
import ptit.suwoo.model.NguoiDung;

import java.util.List;
import java.util.Optional;

@Service
public interface AdminService {
    Optional<Admin> findById(Long id);
    Admin loadAdminByName(String username);
    List<Admin> findAllAdmin();
    void deleteAdminById(Long id);
    void editAdminById(Admin admin);
}
