package fr.library.back.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookDao extends JpaRepository<BookEntity, Integer> {

     BookEntity findByTitle(String title);
     BookEntity findByIsbn(Integer isbn);

    @Query(nativeQuery = true, value = "select * from book ORDER BY add_date DESC LIMIT 4")//pas terrible
    List<BookEntity> findOrderByAddDateDesc();

}
