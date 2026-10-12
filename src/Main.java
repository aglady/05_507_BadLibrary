import ru.gr05507.ui.*;

public class Main {
    public static void main() {
        BookRepository repository = new InMemoryBookRepository();
        BookService service = new BookService(repository);
        BookController controller = new BookController(service);
        Window window = new Window(controller);
        controller.attachView(window);
        window.setVisible(true);
    }
}
