package ru.netology.domain;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("Вы пытаетесь удалить несуществующий элемент массива (с id = " + id + ")");
    }
}
