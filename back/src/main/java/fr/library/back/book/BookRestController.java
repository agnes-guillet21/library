package fr.library.back.book;

import fr.library.back.LibraryRestController;
import fr.library.back.exception.LibraryException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookRestController implements LibraryRestController<BookDto> {

    private final BookService bookService;

    /**
     * Read - Get all books
     * @return - An Iterable object of Book full filled
     */
    @GetMapping()
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
    @DeleteMapping()
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
     * Delete one Book
     * @return no return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        try {
            bookService.deleteBook(id);
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
    @PostMapping()
    public ResponseEntity<BookDto> create(@RequestBody BookDto bookDto) {
        BookDto result;
        try{
            result = bookService.createBook(bookDto);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Update Book
     * @param bookDto
     * @return updating book dto
     */
    @PutMapping()
    public ResponseEntity<BookDto> update(@RequestBody BookDto bookDto) {
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
    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getById(@PathVariable Integer id){
        BookDto bookDto;
        try{
          bookDto = bookService.findBookById(id);
        }catch (LibraryException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookDto, HttpStatus.OK);
    }

}
