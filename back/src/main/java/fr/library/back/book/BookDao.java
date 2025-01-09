package fr.library.back.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BookDao extends JpaRepository<BookEntity, Integer> {

    public BookEntity findByTitle(String title);
    public BookEntity findByIsbn(Integer isbn);
}
