package fr.library.back.book;

import fr.library.back.author.AuthorDto;
import fr.library.back.author.AuthorEntity;
import fr.library.back.author.AuthorMapper;
import fr.library.back.image.ImageDto;
import fr.library.back.image.ImageEntity;
import fr.library.back.image.ImageMapper;

import java.util.ArrayList;
import java.util.List;

public class BookMapper {

    private BookMapper(){}

    public static BookDto map(BookEntity bookEntity) {
        BookDto bookDto = new BookDto();
        List<ImageDto> imageDtos = new ArrayList<>();
        bookDto.setId(bookEntity.getId());
        bookDto.setTitle(bookEntity.getTitle());
        bookDto.setDescription(bookEntity.getDescription());
        bookDto.setIsbn(bookEntity.getIsbn());
        if(bookEntity.getAuthor() != null){
            AuthorEntity authorEntity = bookEntity.getAuthor();
            AuthorDto authorDto = AuthorMapper.map(authorEntity);
            bookDto.setAuthor(authorDto);
        }
        if (bookEntity.getImages() != null) {
            for (ImageEntity imageEntity : bookEntity.getImages()) {
                ImageDto imageDto = ImageMapper.map(imageEntity);
                imageDtos.add(imageDto);
            }
            bookDto.setImages(imageDtos);
        }
        return bookDto;
    }

    public static BookEntity map(BookDto bookDto){
        BookEntity bookEntity = new BookEntity();
        List<ImageEntity> imageEntities = new ArrayList<>();
        bookEntity.setId(bookDto.getId());
        bookEntity.setTitle(bookDto.getTitle());
        bookEntity.setDescription(bookDto.getDescription());
//       bookEntity.setAuthor(bookDto.getAuthor());
        bookEntity.setIsbn(bookDto.getIsbn());
        if (bookDto.getImages() != null){
           bookEntity.setImages(ImageMapper.mapDtos(bookDto.getImages()));
        }
    return bookEntity;
    }

    public static List<BookDto> mapEntities(List<BookEntity> bookEntities) {
        List<BookDto> bookDtos = new ArrayList<>();
        for (BookEntity bookEntity : bookEntities) {
            bookDtos.add(BookMapper.map(bookEntity));
        }
        return bookDtos;
    }

//    public static List<BookEntity> mapDtos(List<BookDto> bookDtos) {
//        List<BookEntity> bookEntities = new ArrayList<>();
//        for (BookDto bookDto : bookDtos) {
//            bookEntities.add(BookMapper.map(bookDto));
//        }
//        return bookEntities;
//    }

    /**TODO faire un mapper pour remove tous les livres */
}
