package ptit.suwoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptit.suwoo.Repository.RoleRepository;
import ptit.suwoo.model.Role;

import java.util.Optional;


@Service
public class RoleServiceIplm implements RoleService{
    @Autowired
    RoleRepository roleRepository;
    @Override
    public Optional<Role> findById(long id) {
        return roleRepository.findById(id);
    }
}
