package fr.library.back.book;

import fr.library.back.LibraryRestController;
import fr.library.back.exception.LibraryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookRestController implements LibraryRestController<BookDto> {

    @Autowired
    private BookService bookService;

    /**
     * Read - Get all books
     * @return - An Iterable object of Book full filled
     */
    @GetMapping("/books")
    public ResponseEntity<Iterable<BookDto>> getAll() {
        List<BookDto> allBooks = new ArrayList<>();
        try {
            allBooks = bookService.getBooks();
        }catch (Exception e){
            return new ResponseEntity<Iterable<BookDto>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<BookDto>>(allBooks, HttpStatus.OK);
    }


    /**
     * Delete All Book
     * @return no return
     */
    @DeleteMapping("/remove-books")
    public ResponseEntity<Void> deleteAll() {
        try {
            List<BookDto> allBooksDto = bookService.getBooks();
            bookService.deleteAllBooks(allBooksDto);
        }catch (Exception e){
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    /**
     * Create book
     * @param bookDto
     * @return a new book dto
     */
    @PostMapping("/create-book")
    public ResponseEntity<BookDto> create(BookDto bookDto) {
        try{
            bookService.createBook(bookDto);
        }catch (Exception e){
            return new ResponseEntity<BookDto>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<BookDto>(bookDto, HttpStatus.OK);
    }

    /**
     * Update Book
     * @param bookDto
     * @return updating book dto
     */
    @PutMapping("/update-book")
    public ResponseEntity<BookDto> update(BookDto bookDto) {
        try{
            bookService.updateBook(bookDto);
        }catch (LibraryException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(bookDto, HttpStatus.OK);
    }

    /**
     * Find one Book by ID
     * @return bookDto
     */
    @GetMapping("/book")
    public ResponseEntity<BookDto> findById(Integer id){
        BookDto bookDto;
        try{
          bookDto = bookService.findBookById(id);
        }catch (LibraryException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookDto, HttpStatus.OK);
    }

    /**
     * Find book by title
     * @return book Dto
     */
    public ResponseEntity <BookDto> findByTitle(String title){
        BookDto bookDto;
        bookDto = bookService.findBookByTitle(title);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    /**
     * Find book by isbn
     * @return book Dto
     */
    public ResponseEntity <BookDto> findByIsbn(Integer isbn){
        BookDto bookDto;
        bookDto = bookService.findBookByIsbn(isbn);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
