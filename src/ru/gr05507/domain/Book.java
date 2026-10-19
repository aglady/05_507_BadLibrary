package ru.gr05507.domain;

import java.time.LocalDateTime;

public record Book(
    String author,
    String title,
    int year,
    String info
) {
    public Book {
        if (author == null || author.isBlank()){
            throw new IllegalArgumentException("Введите автора");
        }
        if (title == null || title.isBlank()){
            throw new IllegalArgumentException("Введите название");
        }
        if(year <= 0){
            throw new IllegalArgumentException("Некорректный год");
        }
    }
}


