package managa_library.Service.impl;

import lombok.extern.slf4j.Slf4j;
import managa_library.Dto.LoginDTO;
import managa_library.Entity.Role;
import managa_library.Repository.RoleReps;
import managa_library.Status.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import managa_library.Dto.UserDTO;
import managa_library.Entity.User;
import managa_library.Repository.UserReps;
import managa_library.Service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@Service
@Transactional
@Slf4j
public class UserIMPL implements UserService {
    @Autowired(required = true)
    private UserReps userReps;

    @Autowired
    private RoleReps roleReps;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private UserDTO userDTO;
    @Override
    public String addUser(UserDTO userDTO) {
        User user = new User(userDTO.getUserId(),
                userDTO.getUserName(),userDTO.getUserEmail(),
                this.passwordEncoder.encode(userDTO.getUserPassword()),
                userDTO.getUserGender(),
                userDTO.getUserPhone()
                );
        userReps.save(user);
        return user.getUsername();
    }

    @Override
    public User saveUser(User user) {
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        return userReps.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleReps.save(role);
    }

    @Override
    public void addToUser(String username, String rolename) {
        User user = userReps.findByUserEmail(username);
        Role role = roleReps.findByName(rolename);
        user.getRoles().add(role);
    }

    @Override
    public LoginMessage loginUser(LoginDTO loginDTO) {
//        return new LoginMessage("Login Success", true);
        User user = userReps.findByUserEmail(loginDTO.getUserEmail());
        if (user != null)
        {
            String password = loginDTO.getUserPassword();
            String encodedPassword = user.getUserPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight)
            {
                Optional<User> user1 = userReps.findOneByUserEmailAndUserPassword(loginDTO.getUserEmail(), encodedPassword);
                if (user1.isPresent()) {
                    return new LoginMessage("Login Success", true);
                }
                else
                {
                    return new LoginMessage("Login Failed", false);
                }
            }
            else
            {
                return new LoginMessage("password Not Match", false);
            }
        }
        else
        {
            return new LoginMessage("Email not exits", false);
        }

    }
}
