package fr.library.back.book;


import fr.library.back.image.ImageEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class BookDaoTest {

    @Autowired
    private BookDao bookDao;

//    @Test
//    public void testAddBook(){
//        BookEntity book = new BookEntity(null, "un lire parmis tant d'autres", "une description", "un auteur", 55, new ImageEntity());
//
//        BookEntity savedBook = bookDao.save(book);
//
//        Assertions.assertNotNull(savedBook);
//        Assertions.assertEquals("un lire parmis tant d'autres", book.getTitle());
//        Assertions.assertNotNull(book.getId(), "L'ID ne doit pas être null");
//        Assertions.assertTrue(book.getId() > 0, "L'ID doit etre superieur a 0");
//    }

    @Test
    public void testGetListOfBook(){
        List<BookEntity> books = bookDao.findAll();
        Assertions.assertNotNull(books);
    }

//    @Test
//    public void DeleteBook(){
//        BookEntity book = new BookEntity(66,"un livre parmis encore un", "une description, encore une", "un auteur, encore", 66, new ImageEntity());
//        bookDao.deleteById(book.getId());
//        BookEntity deletedBook = bookDao.findById(book.getId()).orElse(null);
//        Assertions.assertNull(deletedBook);
//    }

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
