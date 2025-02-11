package fr.library.back.book;


import lombok.experimental.StandardException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@WebMvcTest(controllers = BookRestController.class)
class BookRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetBooks() throws Exception {
        mockMvc .perform(MockMvcRequestBuilders.get("/books"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.bookId").exists());
        }

    @Test
    public void testUpdateBook() throws Exception {
        mockMvc .perform(MockMvcRequestBuilders.put("/books"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testAddBook() throws Exception {
        mockMvc .perform((MockMvcRequestBuilders.post("/books")))
                .andExpect((MockMvcResultMatchers.status().isOk()));
    }

    @Test
    public void testDeleteBook() throws Exception {
        mockMvc .perform(MockMvcRequestBuilders.delete("/books"))
           .andExpect(MockMvcResultMatchers.status().isOk());
    }

    //test update si ca se passe mal
    @Test
    public void testIfUpdateBookFailed(){

    }

    // test if get empty field when post request
    @Test
    public void testIfEmptyField() throws Exception {
        mockMvc .perform((MockMvcRequestBuilders.post("/books")));
    }
}
