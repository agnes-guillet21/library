package fr.library.back.author;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthorDao extends JpaRepository<AuthorEntity, Integer> {

}
