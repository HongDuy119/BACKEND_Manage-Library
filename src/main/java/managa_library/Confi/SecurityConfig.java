package managa_library.Confi;

import managa_library.Entity.Role;
import managa_library.Entity.User;
import managa_library.Repository.BookReps;
import managa_library.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.HashSet;

@Configuration
@EnableTransactionManagement
//@EnableWebSecurity
//@EnableJpaRepositories
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }
    @Bean
    CommandLineRunner run(UserService userService){
        return args -> {
//            userService.saveRole(new Role(null,"ROLE_USER"));
//            userService.saveRole(new Role(null,"ROLE_MANAGE"));
//            userService.saveRole(new Role(null,"ROLE_ADMIN"));
//            userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));
//            userService.saveUser(new User(null,"Le Hong Duy","admin","admin","Nam","0367382925",new HashSet<>()));
//            userService.addToUser("admin","ROLE_MANAGE");
        };
    }

}
