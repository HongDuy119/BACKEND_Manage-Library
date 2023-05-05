package managa_library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import managa_library.Entity.User;

@EnableJpaRepositories
@Repository
public interface UserReps extends JpaRepository<User,Long> {

}
