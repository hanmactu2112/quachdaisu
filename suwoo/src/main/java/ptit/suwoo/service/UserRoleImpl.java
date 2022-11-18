package ptit.suwoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptit.suwoo.Repository.UserRoleRepository;
import ptit.suwoo.model.UserRole;

import java.util.Optional;

@Service
public class UserRoleImpl implements UserRoleService{
    @Autowired
    UserRoleRepository userRoleRepository;
    @Override
    public Optional<UserRole> findById(Long id) {
        return userRoleRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        userRoleRepository.deleteById(id);
    }
}
