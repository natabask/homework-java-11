package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private Product book = new Book(1, "Capital", 500, "Karl Marx");

    @Test
    public void shouldReturnTrueIfNameContains() {
        boolean actual = book.matches("Capital");
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnFalseIfNameDoesntContains() {
        boolean actual = book.matches("Capitan");
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnTrueIfAuthorContains() {
        boolean actual = book.matches("Marx");
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnFalseIfAuthorDoesntContains() {
        boolean actual = book.matches("Pushkin");
        boolean expected = false;
        assertEquals(expected, actual);
    }
}