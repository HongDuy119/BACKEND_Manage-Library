package managa_library.Service;

import managa_library.Dto.BookDTO;
import managa_library.Entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@Service
public interface BookService {
    public List<Book> findAll();
    public String addBook(BookDTO bookDTO) throws IOException;

    Book findbyId(int id);
    Book getBookByBookId(int id);

    List<Book> getBooksByBookTitle(String s);

    List<Book> findByBookDescriptionContaining(String s);

    List<Book> findByBookCategoryContaining(String s);

//    List<Book>
    List<Book> findByBookAuthorContaining(String s);

    public String editBook(BookDTO bookDTO) throws IOException;

    public int deleteBook(int id);
}
