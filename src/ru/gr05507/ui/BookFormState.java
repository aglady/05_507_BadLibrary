package ru.gr05507.ui;

public record BookFormState(
        boolean addEnabled,
        String status,
        String erorr
) {

    public static BookFormState init () {
        return new BookFormState(false,"Заполнить форму",null);
    }

    public static BookFormState setReady (){
        return new BookFormState(true,"Добавить",null);
    }

    public static BookFormState setError (String message){
        return new BookFormState(false,"Ошибка",message);
    }
}
