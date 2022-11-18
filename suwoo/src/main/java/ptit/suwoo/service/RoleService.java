package ptit.suwoo.service;

import org.springframework.stereotype.Service;
import ptit.suwoo.model.Role;

import java.util.Optional;

@Service
public interface RoleService {
    Optional<Role> findById(long id);

}
