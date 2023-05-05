package managa_library.Service.impl;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import managa_library.Dto.BookDTO;
import managa_library.Entity.Book;
import managa_library.Repository.BookReps;
import managa_library.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
@Component
@Service
@Transactional
@Slf4j
public class BookIMPL implements BookService {
    @Autowired(required = true)
    private BookReps bookReps;
    @Override
    public List<Book> findAll() {
        List<Book> list = bookReps.findAll();
        return list;
    }

    @Override
    public String addBook(BookDTO bookDTO) throws IOException {
        Book book = new Book(bookDTO.getBookId(),bookDTO.getBookTitle(),bookDTO.getBookDescription(),
                bookDTO.getBookNumberPage(),bookDTO.getBookAuthor(),bookDTO.getBookCategory(),
                bookDTO.getImage());
        bookReps.save(book);
        return book.getBookDescription();
    }

    @Override
    public Book findbyId(int id) {
        return bookReps.findByBookId(id);
    }

    @Override
    public Book getBookByBookId(int id) {
        return bookReps.getBookByBookId(id);
    }

    @Override
    public List<Book> getBooksByBookTitle(String s) {
        return bookReps.findByBookTitleContaining(s);
    }

    @Override
    public List<Book> findByBookDescriptionContaining(String s) {
        return bookReps.findByBookDescriptionContaining(s);
    }

    @Override
    public List<Book> findByBookCategoryContaining(String s) {
        return bookReps.findByBookCategoryContaining(s);
    }

    @Override
    public List<Book> findByBookAuthorContaining(String s) {
        return bookReps.findByBookAuthorContaining(s);
    }

    @Override
    public String editBook(BookDTO bookDTO) throws IOException {

        Book book = new Book(bookDTO.getBookId(),bookDTO.getBookTitle(),bookDTO.getBookDescription(),
                bookDTO.getBookNumberPage(),bookDTO.getBookAuthor(),bookDTO.getBookCategory(),
                bookDTO.getImage());
        bookReps.save(book);
        return "ok";
    }

    @Override
    public int deleteBook(int id) {
        int id1 = bookReps.deleteByBookId(id);
        return id1;
    }
}
