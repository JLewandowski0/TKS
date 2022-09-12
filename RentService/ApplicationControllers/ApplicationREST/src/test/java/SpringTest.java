import appcontroller.RentServiceApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = RentServiceApplication.class)
public interface SpringTest {
    String BASE_URL = "http://localhost:";
}
