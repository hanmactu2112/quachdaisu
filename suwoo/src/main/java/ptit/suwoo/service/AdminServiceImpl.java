package ptit.suwoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptit.suwoo.Repository.AdminRepository;
import ptit.suwoo.Repository.NguoiDungRepository;
import ptit.suwoo.Repository.RoleRepository;
import ptit.suwoo.Repository.UserRoleRepository;
import ptit.suwoo.model.Admin;
import ptit.suwoo.model.NguoiDung;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    AdminRepository adminRepository;

    @Override
    public Optional<Admin> findById(Long id) {
        return adminRepository.findById(id);
    }

    @Override
    public Admin loadAdminByName(String name) {
        return adminRepository.findByName(name);
    }

    @Override
    public List<Admin> findAllAdmin() {
        return adminRepository.findAll();
    }

    @Override
    public void deleteAdminById(Long id) {
        adminRepository.deleteById(id);
    }

    @Override
    public void editAdminById(Admin admin) {
        adminRepository.save(admin);
    }
}
