import ru.gr05507.application.BookService;
import ru.gr05507.domain.BookRepository;
import ru.gr05507.infrastructure.InMemoryBookRepository;
import ru.gr05507.ui.*;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

public class Main {
    public static void main() {
        BookRepository repository = new InMemoryBookRepository();
        Clock clock = Clock.systemDefaultZone();
//        Clock clock = Clock.fixed(
//                Instant.parse("2035-08-29T00:00:00Z"),
//                ZoneId.systemDefault()
//        );
        BookService service = new BookService(repository, clock);
        BookInputParser parser = new BookInputParser();
        BookController controller = new BookController(service, parser);
        Window window = new Window(controller);
        controller.attachView(window);
        window.setVisible(true);
        controller.viewOpened();
    }
}
