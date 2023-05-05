package managa_library.Repository;

import managa_library.Entity.Book;
import managa_library.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@EnableJpaRepositories
//@Transactional
public interface BookReps extends JpaRepository<Book,Integer> {
    public List<Book> findAll();

    Book findByBookId(int id);
    Book getBookByBookId(int id);


    List<Book> findByBookTitleContaining(String s);

    List<Book> findByBookDescriptionContaining(String s);
    List<Book> findByBookCategoryContaining(String s);
    List<Book> findByBookAuthorContaining(String s);
    @Transactional
    public int deleteByBookId(int bookId);
}
