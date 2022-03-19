package ru.netology.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Product first = new Book(1, "Capital", 500, "Karl Marx");
    private Product second = new Smartphone(2, "3110", 870, "Nokia");
    private Product third = new Book(3, "Eugene Onegin", 400, "Alexander Pushkin");

    @BeforeEach
    public void shouldSetInitialState() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
    }

    @Test
    // Удаление продукта по существующему id
    public void shouldRemoveByExistentId() {

        repository.removeById(2);

        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{first, third};

        assertArrayEquals(actual, expected);
    }

    @Test
    // Удаление продукта по несуществующему id
    public void shouldRemoveByNonExistentId() {

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(23);
        });
    }
}