package ru.gr05507.application;

import ru.gr05507.domain.Book;
import ru.gr05507.domain.BookRepository;
import ru.gr05507.ui.ParsedBookInput;

import java.time.LocalDateTime;
import java.util.List;

public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {this.repository = repository; }

    public void addBook(ParsedBookInput parsedBook){
        int iYear = parsedBook.year();
        if(iYear > LocalDateTime.now().getYear()){
            throw new IllegalArgumentException("Некорректный год");
        }
        var book = new Book(parsedBook.author(),
                parsedBook.title(),
                iYear,
                parsedBook.info());

        repository.save(book);
    }

    public List<Book> getAllBooks() { return repository.findAll(); }
}
