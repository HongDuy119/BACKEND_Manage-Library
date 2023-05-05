package managa_library.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import managa_library.Dto.BookDTO;
import managa_library.Entity.Book;
import managa_library.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/book")
public class BookController {
    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));
    @Autowired
    private BookService bookService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Book>> getAllBook(){
//        System.out.println(1);
        List<Book> books = bookService.findAll();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/getbytitle")
    public ResponseEntity<List<Book>> getByTitle(@RequestParam String s, @RequestParam String s1){
        List<Book> books = null;
//        System.out.println(s);
        if(s1.contains("title")) books = bookService.getBooksByBookTitle(s);
        else if(s1.contains("content")) books = bookService.findByBookDescriptionContaining(s);
        else if(s1.contains("author")) books = bookService.findByBookAuthorContaining(s);
        else if(s1.contains("category")) books = bookService.findByBookCategoryContaining(s);
        else books = bookService.getBooksByBookTitle(s);
        return ResponseEntity.ok(books);
    }
    @PostMapping("/addBook")
    public String addBook(@RequestParam("book") String book,@RequestParam("images") MultipartFile images) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        BookDTO bookDTO = objectMapper.readValue(book, BookDTO.class);
        Path staticPath = Paths.get("static");

        Path imagePath = Paths.get("images");
        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
        }
        Path file = CURRENT_FOLDER.resolve(staticPath)
                .resolve(imagePath).resolve(images.getOriginalFilename());
        try (OutputStream os = Files.newOutputStream(file)) {
            os.write(images.getBytes());
        }
        bookDTO.setImage(imagePath.resolve(images.getOriginalFilename()).toString());
        String id = bookService.addBook(bookDTO);
        return id;
    }
    @DeleteMapping ("/deleteBook/{id}")
    public int deleteBook(@PathVariable int id){
        int id1 = bookService.deleteBook(id);

        return id1;
    }

    @PutMapping("/editBook/{id}")
    public ResponseEntity<String> editBook(@PathVariable int id,@RequestParam("book") String book,@RequestParam("images") MultipartFile images) throws IOException {
//        System.out.println(images);
        ObjectMapper objectMapper = new ObjectMapper();
        BookDTO bookDTO = objectMapper.readValue(book, BookDTO.class);
        Path staticPath = Paths.get("static");

        Path imagePath = Paths.get("images");
        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
        }
        Path file = CURRENT_FOLDER.resolve(staticPath)
                .resolve(imagePath).resolve(images.getOriginalFilename());
//        System.out.println(file);
        try (OutputStream os = Files.newOutputStream(file)) {
            os.write(images.getBytes());
        }
        bookDTO.setImage(imagePath.resolve(images.getOriginalFilename()).toString());
        bookDTO.setBookId(id);
        return ResponseEntity.ok(bookService.editBook(bookDTO));
//        System.out.println(book.get);
//        return null;
    }
    @GetMapping("/book/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable int id) {
        Book book = bookService.findbyId(id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(book.getBookImage().getBytes());
    }



    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookbyId(@PathVariable int id){
        return ResponseEntity.ok(bookService.findbyId(id));
    }
}
