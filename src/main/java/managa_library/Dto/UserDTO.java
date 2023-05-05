package managa_library.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int user_id;

    private String user_name;

    private String user_email;

    private String user_password;
}
