// File: src/test/java/nz/co/ats/hooks/Hooks.java
package nz.co.ats.steps;

import com.microsoft.playwright.Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import nz.co.ats.config.PlaywrightFactory;
import org.springframework.beans.factory.annotation.Value;

public class Hooks {

    @Value("${browser:chromium}")
    private String browserName;

    @Before
    public void setUp() {
        PlaywrightFactory.init(browserName);
    }

    @After
    public void tearDown(Scenario scenario) {
        Page page = PlaywrightFactory.getPage();

        if (scenario.isFailed()) {
            try {
                byte[] screenshot = page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
                scenario.attach(screenshot, "image/png", "Failure Screenshot");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        PlaywrightFactory.cleanup();
    }
}
