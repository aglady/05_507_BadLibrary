package ru.gr05507.ui;

import java.time.LocalDateTime;

public class BookInputParser {
    public ParsedBookInput parse(String author, String title, String year, String info) {
        if (author == null || author.isBlank()){
            throw new IllegalArgumentException("Введите автора");
        }
        if (title == null || title.isBlank()){
            throw new IllegalArgumentException("Введите название");
        }
        return new ParsedBookInput(author, title, getYear(year), info);
    }

    private int getYear(String year){
        if (year == null || year.isBlank()){
            throw new IllegalArgumentException("Введите год издания");
        }

        int iYear;
        try {
            iYear = Integer.parseInt(year);
        } catch (NumberFormatException ex){
            throw new IllegalArgumentException("Некорректный год", ex);
        }
        return iYear;
    }
}
