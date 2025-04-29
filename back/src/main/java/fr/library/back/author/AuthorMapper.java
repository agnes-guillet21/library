package fr.library.back.author;

import fr.library.back.image.ImageDto;
import fr.library.back.image.ImageEntity;
import fr.library.back.image.ImageMapper;

import java.util.ArrayList;
import java.util.List;

public class AuthorMapper {

    private AuthorMapper (){}

    public static AuthorDto map(AuthorEntity authorEntity) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(authorEntity.getId());
        authorDto.setLastName(authorEntity.getLastName());
        authorDto.setFirstName(authorEntity.getFirstName());
        authorDto.setNationality(authorEntity.getNationality());
        if (authorEntity.getImage() != null) {
            ImageEntity imageEntity = authorEntity.getImage();
            ImageDto imageDto = ImageMapper.map(imageEntity);
            authorDto.setImageDto(imageDto);
        }
        return authorDto;
    }


    public static AuthorEntity map(AuthorDto authorDto) {
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setId(authorDto.getId());
        authorEntity.setLastName(authorDto.getLastName());
        authorEntity.setFirstName(authorDto.getFirstName());
        authorEntity.setNationality(authorDto.getNationality());
        if (authorDto.getImageDto() != null) {
            ImageDto imageDto = authorDto.getImageDto();
            ImageEntity imageEntity = ImageMapper.map(imageDto);
            authorEntity.setImage(imageEntity);
        }
        return authorEntity;
    }

    public static List<AuthorDto> mapEntities(List<AuthorEntity> authorEntities) {
        List<AuthorDto> authorDtos = new ArrayList<>();
        for (AuthorEntity authorEntity : authorEntities) {
            authorDtos.add(AuthorMapper.map(authorEntity));
        }
        return authorDtos;
    }
}



