package spring_boot_jwt.tech1.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import spring_boot_jwt.tech1.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> getRoleByName(String role);
}
