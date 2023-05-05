package managa_library.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "users")
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",length = 45)
    private int user_id;

    @Column(name = "user_name",length = 255)
    private String user_name;

    @Column(name = "email",length = 255)
    private String user_email;

    @Column(name = "user_password",length = 255)
    private String user_password;




}
