package ru.gr05507.ui;

import java.util.List;

public interface BookView {
    String getAuthor();
    String getTitle();
    String getYear();
    String getInfo();
    void clearInput();
    void showBooks(List<Book> books);
    void showError(String Message);
}
