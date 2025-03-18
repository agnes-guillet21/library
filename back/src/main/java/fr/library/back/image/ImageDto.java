package fr.library.back.image;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImageDto {

    private Integer id;
    private String fileName;
    private String dataBase64;
    private String fileType;



}
