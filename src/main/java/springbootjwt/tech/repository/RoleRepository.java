package springbootjwt.tech.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import springbootjwt.tech.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> getRoleByName(String role);
}
