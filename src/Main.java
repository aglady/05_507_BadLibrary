import ru.gr05507.application.BookService;
import ru.gr05507.domain.BookRepository;
import ru.gr05507.infrastructure.InMemoryBookRepository;
import ru.gr05507.ui.*;

public class Main {
    public static void main() {
        BookRepository repository = new InMemoryBookRepository();
        BookService service = new BookService(repository);
        BookInputParser parser = new BookInputParser();
        BookController controller = new BookController(service, parser);
        Window window = new Window(controller);
        controller.attachView(window);
        window.setVisible(true);
        controller.viewOpened();
    }
}
