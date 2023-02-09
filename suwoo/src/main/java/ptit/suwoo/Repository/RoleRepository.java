package ptit.suwoo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import ptit.suwoo.model.Role;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findById(long id);

    @Query(value = "SELECT r.* FROM role r join user_role ur on r.id = ur.id_role where ur.id_user = ?1",nativeQuery = true)
    List<Role> findRoleByIdUser(Long id);
}
