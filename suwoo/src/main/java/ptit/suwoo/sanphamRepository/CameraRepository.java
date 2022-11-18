package ptit.suwoo.sanphamRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptit.suwoo.model.Camera;

@Repository
public interface CameraRepository extends JpaRepository<Camera,Long> {
}
