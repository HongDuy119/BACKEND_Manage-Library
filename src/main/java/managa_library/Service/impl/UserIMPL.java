package managa_library.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import managa_library.Dto.UserDTO;
import managa_library.Entity.User;
import managa_library.Repository.UserReps;
import managa_library.Service.UserService;

@Component
public class UserIMPL implements UserService {
    @Autowired
    UserReps userReps;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public String addUser(UserDTO userDTO) {
//        User user = new User(userDTO.getUser_id(),
//                userDTO.getUser_name(),userDTO.getUser_email(),
//                this.passwordEncoder.encode(userDTO.getUser_password())
//                );
        User user = new User(
        );
        userReps.save(user);
        return user.getUser_name();
    }

    @Bean
    PasswordEncoder mahoaMK() {
        return new BCryptPasswordEncoder();
    }
}
