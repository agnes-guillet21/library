package fr.library.back.author;
import fr.library.back.book.BookEntity;
import fr.library.back.image.ImageEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "author")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String lastName;

    private String firstName;

    private String nationality;

    @OneToOne
    @JoinColumn(name = "image_id")
    private ImageEntity image;

    @OneToMany
    private List <BookEntity> books;
}
