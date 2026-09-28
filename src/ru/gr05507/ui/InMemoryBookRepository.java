package ru.gr05507.ui;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBookRepository implements BookRepository{

    private final List<Book> books = new ArrayList<>();
    @Override
    public void save(Book book) {
        books.add(book);
    }

    @Override
    public List<Book> findAll() {
        return List.copyOf(books);
    }
}
