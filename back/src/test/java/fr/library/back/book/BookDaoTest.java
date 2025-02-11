package fr.library.back.book;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.print.Book;
import java.util.List;

public class BookDaoTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookDao bookDao;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddBook(){
        BookEntity book = new BookEntity(44,"un lire parmis tant d'autres", "une description", "un auteur", 55);
        BookEntity savedBook = bookDao.save(book);
       Assertions.assertNotNull(savedBook);
        Assertions.assertEquals("un lire parmis tant d'autres", savedBook.getTitle());
    }

    @Test
    public void testGetListOfBook(){
        List<BookEntity> books = bookDao.findAll();
        Assertions.assertNotNull(books);
    }

    @Test
    public void DeleteBook(){
        BookEntity book = new BookEntity(66,"un livre parmis encore un", "une description, encore une", "un auteur, encore", 66);
        bookDao.deleteById(book.getId());
        BookEntity deletedBook = bookDao.findById(book.getId()).orElse(null);
        Assertions.assertNull(deletedBook);
    }

    @Test
    public void testGetBook(){
    }

    @Test
    public void testUpdateBook(){
    }


    @Test
    public void testFindBookById(){
    }

    @Test
    public void  testFindBookByIsbn(){

    }
}
