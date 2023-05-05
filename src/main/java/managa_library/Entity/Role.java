package managa_library.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.HashSet;
import java.util.Set;

@Data@Setter@Getter
@NoArgsConstructor@AllArgsConstructor
@Entity
@Table(name = "Roles")
public class Role {
    @Id
    @SequenceGenerator(
            name = "roles_sequence",
            sequenceName = "roles_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "roles_sequence")
    private Long id;
    private String name;

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @ManyToMany(mappedBy = "roles")
    @Fetch(value = FetchMode.SELECT)
    @JsonIgnore
    private Set<User> user = new HashSet<>();
}
