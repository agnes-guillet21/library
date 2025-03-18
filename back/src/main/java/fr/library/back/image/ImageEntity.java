package fr.library.back.image;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "image")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    private String fileName;

    @Column(name = "content")
    private String dataBase64;
    
    @Column(name = "extension")
    private String fileType;


}
