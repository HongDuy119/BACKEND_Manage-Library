package managa_library.Repository;

import managa_library.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface RoleReps extends JpaRepository<Role,Long> {
    Role findByName(String role);
}
