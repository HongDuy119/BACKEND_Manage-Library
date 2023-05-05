package managa_library.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;


@Entity
@Table(name = "users")
@Getter@Setter
//@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",length = 45)
    private Long userId;

    @Column(name = "user_name",length = 255)
    private String userName;

    @Column(name = "user_email",length = 255,unique = true)
    private String userEmail;

    @Column(name = "user_password",length = 255)
    private String userPassword;
    private String userGender;
    private String userPhone;
    @ManyToMany
    @JoinTable(name="users_role",
    joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "Roles_ID")
    )
    private Set<Role> roles = new HashSet<>();

    public User(Long userId, String userName, String userEmail, String userPassword, String userGender, String userPhone, Set<Role> roles) {
        this.userId = (userId);
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userGender = userGender;
        this.userPhone = userPhone;
        this.roles = roles;
    }

    public User(String userName, String userEmail, String userPassword, String userGender, String userPhone) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userGender = userGender;
        this.userPhone = userPhone;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        roles.stream().forEach(i -> authorities.add(new SimpleGrantedAuthority(i.getName())));
        return List.of(new SimpleGrantedAuthority(authorities.toString()));
    }

    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public String getUsername() {
        return userEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User(Long userId, String userName, String userEmail, String userPassword, String userGender, String userPhone) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userGender = userGender;
        this.userPhone = userPhone;
    }
}
