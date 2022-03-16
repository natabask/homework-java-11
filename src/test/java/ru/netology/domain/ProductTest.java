package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Product product = new Product(1, "white dining table", 2500);

    @Test
    public void shouldReturnTrueIfNameContains() {
        boolean actual = product.matches("white");
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnFalseIfNameDoesntContains() {
        boolean actual = product.matches("black");
        boolean expected = false;
        assertEquals(expected, actual);
    }
}