package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void groupedAssertion() {
        //given
        Person person = new Person(1L, "Vimal",  "Nayak");
        //then
        assertAll("Test property set",
                () -> assertEquals("Vimal", person.getFirstName()),
                () -> assertEquals("Nayak", person.getLastName()));
    }

    @Test
    void groupedAssertionMesgs() {
        //given
        Person person = new Person(1L, "Vimal",  "Nayak");
        //then
        assertAll("Test property set",
                () -> assertEquals("Vimal", person.getFirstName(), "First name failed"),
                () -> assertEquals("Nayak", person.getLastName(), "Last name failed"));
    }
}