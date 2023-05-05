package managa_library.Repository;


import lombok.extern.slf4j.Slf4j;
import managa_library.Entity.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface UserReps extends JpaRepository<User,Long>
{
    Optional<User> findOneByUserEmailAndUserPassword(String useremail, String userpassword);

    User findByUserEmail(String useremail);
}