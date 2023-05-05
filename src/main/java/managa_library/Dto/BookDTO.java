package managa_library.Dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter@Setter
@NoArgsConstructor@AllArgsConstructor
@Data
public class BookDTO {
    private int bookId;

    private String bookTitle;
    private String bookDescription;
    private String bookNumberPage;
    private String bookAuthor;
    private String bookCategory;
    private String image;
}
