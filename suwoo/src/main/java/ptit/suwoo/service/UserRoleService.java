package ptit.suwoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptit.suwoo.Repository.UserRoleRepository;
import ptit.suwoo.model.UserRole;

import java.util.Optional;

@Service
public interface UserRoleService {

    Optional<UserRole> findById(Long id);
    void deleteById(Long id);
}
