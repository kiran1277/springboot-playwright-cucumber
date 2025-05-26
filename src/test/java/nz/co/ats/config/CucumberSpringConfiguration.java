package nz.co.ats.config;
import io.cucumber.spring.CucumberContextConfiguration;
import nz.co.ats.TestApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = TestApplication.class)
public class CucumberSpringConfiguration {
    // no code needed here – just used to trigger Spring context loading
}
