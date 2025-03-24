package fr.library.back.author;


public class AuthorMapper {

    private AuthorMapper (){}

    public static AuthorDto map(AuthorEntity authorEntity) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(authorEntity.getId());
        authorDto.setLastName(authorEntity.getLastName());
        authorDto.setFirstName(authorEntity.getFirstName());
        authorDto.setNationality(authorEntity.getFirstName());
        if (authorDto.getImageDto() != null) {
            //   authorDto.setImageDto(authorEntity.getFirstName());
        }
        return authorDto;
    }


    public static AuthorEntity map(AuthorDto authorDto) {
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setId(authorDto.getId());
        authorEntity.setLastName(authorDto.getLastName());
        authorEntity.setFirstName(authorDto.getFirstName());
        authorEntity.setNationality(authorDto.getFirstName());
        if (authorEntity.getImage() != null) {
            //   authorDto.setImageDto(authorEntity.getFirstName());
        }
        return authorEntity;
    }
}



