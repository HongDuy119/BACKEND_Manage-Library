package managa_library;

import managa_library.Entity.Role;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ManageLibrary {
    public static void main(String[] args) {
        SpringApplication.run(ManageLibrary.class, args);
        //new Role(null, "1");
    }
}
