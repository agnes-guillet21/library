
package fr.library.back.book;

import fr.library.back.author.AuthorEntity;
import fr.library.back.image.ImageEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity(name = "book")
@Data
public class BookEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private Integer isbn;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "book_image",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id"))
    List<ImageEntity> images ;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorEntity author;
}
