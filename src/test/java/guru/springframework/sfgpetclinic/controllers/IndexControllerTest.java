package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    private IndexController indexController;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @Test
    void index() {
        assertEquals("index", indexController.index(), "Wrong index returned");
        assertEquals("index", indexController.index(), () -> "Another expensive way to get error message");
    }

    @Test
    void oupsHandler() {

        assertThrows(ValueNotFoundException.class, ()  ->  {
            indexController.ooosHandler();
        });
    }
}