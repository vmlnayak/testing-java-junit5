package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

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

    @Test
    @Disabled("Demo of timeout")
    void testTimeOut(){
        assertTimeout(Duration.ofMillis(100),  ()  -> {
            Thread.sleep(2000);
            System.out.println("I got here");
        });
    }

    @Test
    @Disabled("Demo of timeout")
    void testTimeOutPrempt(){
        assertTimeoutPreemptively(Duration.ofMillis(100),  ()  -> {
            Thread.sleep(2000);
            System.out.println("I got here promptly");
        });
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testOnMacOs() {

    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testOnWindowsOs() {

    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testOnJava8() {

    }

    @EnabledOnJre(JRE.OTHER)
    @Test
    void testOnJava18() {

    }

    @EnabledIfEnvironmentVariable(named = "USER", matches="vimalnayak")
    @Test
    void testOnEnvironVariable() {

    }
}