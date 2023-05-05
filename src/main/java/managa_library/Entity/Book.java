package managa_library.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int bookId;

        private String bookTitle;
        @Lob
        @Column(nullable = false)
        private String bookDescription;
        private String bookNumberPage;
        private String bookAuthor;
        private String bookCategory;


        private String bookImage;
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "user_loan",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "boo_id")
//    )
//    private Set<User> users = new HashSet<>();

}
