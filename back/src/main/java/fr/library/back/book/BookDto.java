package fr.library.back.book;

import fr.library.back.image.ImageDto;
import fr.library.back.image.ImageEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private Integer id;
    private String title;
    private String description;
    private String author;
    private Integer isbn;
    private List<ImageDto> images;

}
