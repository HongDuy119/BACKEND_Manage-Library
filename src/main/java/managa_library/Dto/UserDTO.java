package managa_library.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long userId;

    private String userName;

    private String userEmail;

    private String userPassword;

    private String userGender;


    private String userPhone;
}
