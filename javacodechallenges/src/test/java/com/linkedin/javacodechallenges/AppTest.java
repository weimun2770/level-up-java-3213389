package com.linkedin.javacodechallenges;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private final ByteArrayOutputStream printOut = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(printOut));
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    public void personAttributes_firstName() {
        Person person = new Person("John", "Cena", 43);
        assertEquals("John", person.getFirstName());

        person.setFirstName("Tony");
        assertEquals("Tony", person.getFirstName());

        person.setFirstName("Michelle");
        assertNotEquals("Megan", person.getFirstName());
    }

    @Test
    public void personAttributes_lastName() {
        Person person = new Person("John", "Cena", 43);
        assertEquals("Cena", person.getLastName());

        person.setLastName("Wood");
        assertEquals("Wood", person.getLastName());

        person.setLastName("Kester");
        assertNotEquals("Megan", person.getLastName());
    }

    @Test
    public void personAttributes_age() {
        Person person = new Person("John", "Cena", 43);
        assertEquals(43, person.getAge());

        person.setAge(23);
        assertEquals(23, person.getAge());

        person.setAge(65);
        assertNotEquals(48, person.getAge());
    }

    @Test
    public void personAttributes_introduction() {
        Person person = new Person("John", "Cena", 43);
        assertNotNull(person.getIntroduction());
    }
}
