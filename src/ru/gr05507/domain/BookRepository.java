package ru.gr05507.domain;

import java.util.List;

public interface BookRepository {
    void save(Book book);
    List<Book> findAll();
}
