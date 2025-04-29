package fr.library.back.author;


import fr.library.back.book.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorRestController {

    private final AuthorService authorService;

    @GetMapping()
    public ResponseEntity<Iterable<AuthorDto>> getAll(){
        List<AuthorDto> allAuthors = new ArrayList<>();
          try {
              allAuthors = authorService.getAuthors();
           }catch (Exception e){
                return new ResponseEntity<Iterable<AuthorDto>>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
        return new ResponseEntity<Iterable<AuthorDto>>(allAuthors, HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<AuthorDto> create (@RequestBody AuthorDto authorDto){
        AuthorDto result;
        try{
            result = authorService.createAuthor(authorDto);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
