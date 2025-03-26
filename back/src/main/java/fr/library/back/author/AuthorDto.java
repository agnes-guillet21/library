package fr.library.back.author;

import fr.library.back.image.ImageDto;
import fr.library.back.image.ImageEntity;
import lombok.*;

@Data
public class AuthorDto {

    private Integer id;
    private String lastName;
    private String firstName;
    private String nationality;
    private ImageDto imageDto;

}
