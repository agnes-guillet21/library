package fr.library.back.book;

import java.util.ArrayList;
import java.util.List;

public class BookMapper {

    private BookMapper(){};

    public static BookDto map(BookEntity bookEntity) {
        BookDto bookDto = new BookDto();
        bookDto.setId(bookEntity.getId());
        bookDto.setTitle(bookEntity.getTitle());
        bookDto.setDescription(bookEntity.getDescription());
        bookDto.setAuthor(bookEntity.getAuthor());
        bookDto.setIsbn(bookEntity.getIsbn());

        return bookDto;
    }

    public static BookEntity map(BookDto bookDto){
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(bookDto.getId());
        bookEntity.setTitle(bookDto.getTitle());
        bookEntity.setDescription(bookDto.getDescription());
        bookEntity.setAuthor(bookDto.getAuthor());
        bookEntity.setIsbn(bookDto.getIsbn());

        return bookEntity;
    }

    public static List<BookDto> mapEntities(List<BookEntity> bookEntities) {
        List<BookDto> bookDtos = new ArrayList<>();
        for (BookEntity bookEntity : bookEntities) {
            bookDtos.add(BookMapper.map(bookEntity));
        }
        return bookDtos;
    }

    public static List<BookEntity> mapDtos(List<BookDto> bookDtos) {
        List<BookEntity> bookEntities = new ArrayList<>();
        for (BookDto bookDto : bookDtos) {
            bookEntities.remove(BookMapper.map(bookDto));
        }
        return bookEntities;
    }
}
