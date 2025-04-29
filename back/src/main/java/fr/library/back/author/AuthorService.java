package fr.library.back.author;

import fr.library.back.book.BookDao;
import fr.library.back.book.BookEntity;
import fr.library.back.book.BookMapper;
import fr.library.back.exception.LibraryException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AuthorService {


    private AuthorDao authorDao;

    public AuthorService(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public List<AuthorDto> getAuthors() throws LibraryException {
        List<AuthorEntity> authorEntities = authorDao.findAll();
       return AuthorMapper.mapEntities(authorEntities);
   }

   public AuthorDto findAuthorById(Integer id) throws LibraryException {
       AuthorDto authorDto = null;
        try{
            AuthorEntity authorEntity =  authorDao.findById(id).get();
            authorDto = AuthorMapper.map(authorEntity);
        }catch (NoSuchElementException e){
           System.out.println("Recovery error : " + e.getMessage());
           throw new LibraryException("No author find with this ID");
       }
        return authorDto;
   }



   public AuthorDto createAuthor(AuthorDto authorDto) throws LibraryException {
        AuthorEntity authorEntity = authorDao.save(AuthorMapper.map(authorDto));
        return AuthorMapper.map(authorEntity);
   }

    /**
     *
     * @param authorDto
     * @return AuthorDto
     * @throws LibraryException
     */
   public AuthorDto updateAuthor(AuthorDto authorDto)  throws LibraryException{
        AuthorEntity authorEntity;
        try{
            authorEntity = authorDao.save(AuthorMapper.map(authorDto));
        }catch (NoSuchElementException e){
            System.out.println("Recovery error : " + e.getMessage());
            throw new LibraryException("Can't update this author");
        }
       return  AuthorMapper.map(authorEntity);
   }

    /**
     * @param id
     * @throws LibraryException
     */
    public void deleteAuthor(Integer id) throws LibraryException  {
        try {
            if (!authorDao.existsById(id)) {
                throw new LibraryException("Auteur avec l'ID " + id + " non trouvé");
            }
            authorDao.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Impossible de supprimer l'auteur : contrainte d'intégrité", e);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Erreur lors de la suppression de l'auteur", e);
        }
    }

}



