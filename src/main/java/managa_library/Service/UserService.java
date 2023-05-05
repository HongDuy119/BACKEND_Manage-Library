package managa_library.Service;

import managa_library.Dto.LoginDTO;
import managa_library.Dto.UserDTO;
import managa_library.Entity.Role;
import managa_library.Entity.User;
import managa_library.Status.LoginMessage;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public String addUser(UserDTO userDTO);
    User saveUser(User user);
    Role saveRole(Role role);

    void addToUser(String username, String rolename);
    public  LoginMessage loginUser(LoginDTO loginDTO);
}
