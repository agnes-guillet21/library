package fr.library.back.book;

import fr.library.back.author.AuthorEntity;
import fr.library.back.exception.LibraryException;
import fr.library.back.image.ImageDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class BookService {

    private BookDao bookDao;
    private AuthorEntity authorEntity;
    /**
     * Construct
     * @param bookDao
     */
    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    /**
     * get bookDto object
     * use mapper class
     */
    public List<BookDto> getBooks() {
        List<BookDto> bookDtos = new ArrayList<>();
        List<BookEntity> bookEntities = bookDao.findAll();
        return BookMapper.mapEntities(bookEntities);
    }

    /**
     * @param bookDtos
     */
    public void deleteAllBooks(List<BookDto> bookDtos){
        List<BookEntity> bookEntities = new ArrayList<>();
        for (BookDto bookDto : bookDtos) {
            bookEntities.remove(BookMapper.map(bookDto));
        }
    }

    /**
     *
     * @param id
     * @return : void
     */
    public void deleteBook(Integer id) {
        bookDao.deleteById(id);
    }

    /**
     * @param bookDto
     * @return BookDto : object for front
     */
    public BookDto createBook(BookDto bookDto) {
        /* tester l'ajout d'un livre avec une image */
        /*A supprimer et faire la logique pour setter l auteur */
        authorEntity =  new AuthorEntity(1, "chattam","maxime","francaise",null);
        BookEntity bookEntity = bookDao.save(BookMapper.map(bookDto));
        bookEntity.setAuthor(authorEntity);
        return BookMapper.map(bookEntity);
    }

   public BookDto updateBook(BookDto bookDto) throws LibraryException {
       BookEntity bookEntity ;
        try{
         bookEntity = bookDao.save(BookMapper.map(bookDto));
        }catch (NoSuchElementException e){
            System.out.println("Recovery error : " + e.getMessage());
            throw new LibraryException("Can't update this book");
        }
        return  BookMapper.map(bookEntity);
    }

    public BookDto findBookById(Integer id) throws LibraryException {
        BookDto bookDto = null;
        try{
            BookEntity bookEntity = bookDao.findById(id).get();
            bookDto = BookMapper.map(bookEntity);
        }catch (NoSuchElementException e){
            System.out.println("Recovery error : " + e.getMessage());
             throw new LibraryException("No book find with this ID");
        }
        return bookDto;
    }

    /**
     * Methode findBookByTitle
     * @return  one object  for front
     */
    public BookDto findBookByTitle(String title){
        BookDto bookDto = null;
        BookEntity bookEntity = bookDao.findByTitle(title);
        bookDto = BookMapper.map(bookEntity);
        return bookDto;
    }

    /**
     * findBookByIsbn
     * @return one object identify by isbn
     */
    public BookDto findBookByIsbn( Integer isbn){
        BookDto bookDto = null;
        BookEntity bookEntity =bookDao.findByIsbn(isbn);
        bookDto = BookMapper.map(bookEntity);
        return bookDto;

    }
}
