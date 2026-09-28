package ru.gr05507.ui;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {this.repository = repository; }

    public void addBook(String author, String title, String year, String info){
        if (author == null || author.isBlank()){
            throw new IllegalArgumentException("Введите автора");
        }
        if (title == null || title.isBlank()){
            throw new IllegalArgumentException("Введите название");
        }
        if (year == null || year.isBlank()){
            throw new IllegalArgumentException("Введите год издания");
        }

        int iYear = getYear(year);
        var book = new Book(author, title, iYear, info);
        repository.save(book);
    }

    private int getYear(String year){
        int iYear;
        try {
            iYear = Integer.parseInt(year);
        } catch (NumberFormatException ex){
            throw new IllegalArgumentException("Некорректный год", ex);
        }
        if(iYear > LocalDateTime.now().getYear()){
            throw new IllegalArgumentException("Некорректный год");
        }
        return iYear;
    }

    public List<Book> getAllBooks() { return repository.findAll(); }
}
