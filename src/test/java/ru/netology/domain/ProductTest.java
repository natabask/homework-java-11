package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Product product = new Product(1, "white dining table", 2500);

    @Test
    public void shouldReturnTrueIfNameContains() {
        assertTrue(product.matches("white"));
    }

    @Test
    public void shouldReturnFalseIfNameDoesntContains() {
        assertFalse(product.matches("black"));
    }
}