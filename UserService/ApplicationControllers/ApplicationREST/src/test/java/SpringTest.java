import appcontroller.UserServiceApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = UserServiceApplication.class)
public interface SpringTest {
    String BASE_URL = "http://localhost:";
}
