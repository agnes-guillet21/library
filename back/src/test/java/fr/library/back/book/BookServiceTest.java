package fr.library.back.book;

import fr.library.back.exception.LibraryException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

class BookServiceTest {

    @InjectMocks // utilisation de bookDao  parce qu il est declarer ds le service
    private BookService bookService;

    @Mock // declaration du mock
    private BookDao bookDao;

    //Mock sur les services utilisés par le mock injecter Book service ( en gros les services utilise par la classe qu on teste)


    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findByIdTest() throws LibraryException {
        //given
        Mockito.when(bookDao.findById(Mockito.anyInt())).thenReturn(Optional.of(new BookEntity(42, "test", "test", "test", 55)));
        //when
        var result = this.bookService.findBookById(42);

        // Then
        Assertions.assertNotNull(result);
        Assertions.assertEquals(42, result.getId());
        Assertions.assertEquals(42, result.getId());
    }

//
//    //test findbookbyIsbn
//    @Test
//    void findByIsbnTest() throws LibraryException{
//        //given
//        Mockito.when(bookDao.findByIsbn(Mockito.anyInt()));
//
//        //when
//        var result = this.bookService.findBookByIsbn(1);
//
//        //then
//        Assertions.assertNotNull(result);
//        Assertions.assertEquals(1, result.getId(), result.getTitle());
//    }
//
//    //test findbookbyIsbn
//    @Test
//    void findByIsbnTitle() throws LibraryException{
//        //given
//        Mockito.when(bookDao.findByTitle(Mockito.anyString()));
//
//        //when
//        var result = this.bookService.findBookByTitle("rebelle");
//
//        //then
//        Assertions.assertNotNull(result);
//        Assertions.assertEquals(1, result.getId(), result.getTitle());
//    }
}
