package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    private Product smartphone = new Smartphone(1, "Honor", 2500, "HTC");

    @Test
    public void shouldReturnTrueIfNameContains() {
        boolean actual = smartphone.matches("Honor");
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnFalseIfDoesntContains() {
        boolean actual = smartphone.matches("iphone");
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnTrueIfVendorContains() {
        boolean actual = smartphone.matches("HTC");
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnFalseIfVendorDoesntContains() {
        boolean actual = smartphone.matches("apple");
        boolean expected = false;
        assertEquals(expected, actual);
    }
}