package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Product first = new Book(1, "Capital", 500, "Karl Marx");
    private Product second = new Smartphone(2, "3110", 870, "Nokia");
    private Product third = new Book(3, "Eugene Onegin", 400, "Alexander Pushkin");
    private Product fourth = new Smartphone(4, "Honor", 2000, "HTC");
    private Product fifth = new Book(5, "Three Musketeers", 370, "Alexander Duma");

    @BeforeEach
    public void shouldSetUpInitialState() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }

    @Test
    // Поиск книги по названию
    public void shouldSearchBookByName() {
        Product[] actual = manager.searchBy("Onegin");
        Product[] expected = {third};

        assertArrayEquals(actual, expected);
    }

    @Test
    // Поиск книги по автору
    public void shouldSearchBookByAuthor() {
        Product[] actual = manager.searchBy("Karl Marx");
        Product[] expected = {first};

        assertArrayEquals(actual, expected);
    }

    @Test
    // Поиск смартфона по названию
    public void shouldSearchSmartphoneByName() {
        Product[] actual = manager.searchBy("3110");
        Product[] expected = {second};

        assertArrayEquals(actual, expected);
    }

    @Test
    // Поиск смартфона по производителю
    public void shouldSearchSmartphoneByVendor() {
        Product[] actual = manager.searchBy("HTC");
        Product[] expected = {fourth};

        assertArrayEquals(actual, expected);
    }

    @Test
    //Несколько товаров подходят под один поисковый запрос
    public void shouldSearchWhenSomeMatch() {
        Product[] actual = manager.searchBy("Alexander");
        Product[] expected = {third, fifth};

        assertArrayEquals(actual, expected);
    }

    @Test
    //Ни один из товаров не подходит под поисковый запрос
    public void shouldSearchWhenNothingMatches() {
        Product[] actual = manager.searchBy("iphone");
        Product[] expected = {};

        assertArrayEquals(actual, expected);
    }
}