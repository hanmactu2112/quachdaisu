package ptit.suwoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;
import ptit.suwoo.Dto.NguoiDungDTO;
import ptit.suwoo.Repository.NguoiDungRepository;
import ptit.suwoo.Repository.RoleRepository;
import ptit.suwoo.Repository.UserRoleRepository;
import ptit.suwoo.model.NguoiDung;
import ptit.suwoo.model.Role;
import ptit.suwoo.model.UserRole;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NguoiDungServiceImpl implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private NguoiDungRepository nguoiDungRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        NguoiDung account = nguoiDungRepository.findByEmail(username);
        if(account == null) {
            System.out.println("User not found! "+username);
            throw new UsernameNotFoundException("User " + username + " was not found in database");
        }
        else {
            List<UserRole> userRole = userRoleRepository.findByidUser(account);
            List<GrantedAuthority> grandList = new ArrayList<GrantedAuthority>();
            System.out.println(account.getMatKhau());
            if(userRole!=null) {
                for (UserRole r:userRole) {
                    Optional<Role> role = roleRepository.findById(r.getIdRole().getId());
                    System.out.println(role.get().getRole());
                    GrantedAuthority authority = new SimpleGrantedAuthority(role.get().getRole());
                    grandList.add(authority);
                }
            }


            NguoiDungDTO userDetails =  new NguoiDungDTO(account.getEmail(), account.getMatKhau(), grandList,account.getName(),account.isGioiTinh(),account.getNgaySinh().toString(),account.getSdt(),account.getDiaChi());
            System.out.println(userDetails.getPassword());
            System.out.println(userDetails);
            return userDetails;
        }

        //	System.out.println("Found User: "+appUser);



    }
}
