package managa_library.Controller;

import managa_library.Dto.LoginDTO;
import managa_library.Status.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import managa_library.Dto.UserDTO;
import managa_library.Service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping(path = "/save")
    public String saveUser(@RequestBody UserDTO userDTO)
    {
        String id = userService.addUser(userDTO);
        return id;
    }
    @PostMapping(path = "/login")
    public ResponseEntity<LoginMessage> LoginUser(@RequestBody LoginDTO loginDTO)
    {
        LoginMessage loginMessege = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginMessege);

    }
}
