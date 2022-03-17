package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private Product book = new Book(1, "Capital", 500, "Karl Marx");

    @Test
    public void shouldReturnTrueIfNameContains() {
        assertTrue(book.matches("Capital"));
    }

    @Test
    public void shouldReturnFalseIfNameDoesntContains() {
        assertFalse(book.matches("Capitan"));
    }

    @Test
    public void shouldReturnTrueIfAuthorContains() {
        assertTrue(book.matches("Marx"));
    }

    @Test
    public void shouldReturnFalseIfAuthorDoesntContains() {
        assertFalse(book.matches("Pushkin"));
    }
}