package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    private Product smartphone = new Smartphone(1, "Honor", 2500, "HTC");

    @Test
    public void shouldReturnTrueIfNameContains() {
        assertTrue(smartphone.matches("Honor"));
    }

    @Test
    public void shouldReturnFalseIfDoesntContains() {
        assertFalse(smartphone.matches("iphone"));
    }

    @Test
    public void shouldReturnTrueIfVendorContains() {
        assertTrue(smartphone.matches("HTC"));
    }

    @Test
    public void shouldReturnFalseIfVendorDoesntContains() {
        assertFalse(smartphone.matches("apple"));
    }
}