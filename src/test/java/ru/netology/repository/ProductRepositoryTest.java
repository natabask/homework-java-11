package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Product first = new Book(1, "Capital", 500, "Karl Marx");
    private Product second = new Smartphone(2, "3110", 870, "Nokia");
    private Product third = new Book(3, "Eugene Onegin", 400, "Alexander Pushkin");
    private Product fourth = new Smartphone(4, "Honor", 2000, "HTC");

    @Test
    // Сохранение всех продуктов
    public void shouldSearchById() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{first, second, third, fourth};

        assertArrayEquals(actual, expected);
    }

    @Test
    // Удаление продукта по id
    public void shouldRemoveById() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

        repository.removeById(3);

        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{first, second, fourth};

        assertArrayEquals(actual, expected);
    }
}