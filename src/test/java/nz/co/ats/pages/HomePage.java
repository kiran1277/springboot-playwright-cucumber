package nz.co.ats.pages;

import com.microsoft.playwright.Page;
import nz.co.ats.config.PlaywrightFactory;
import org.springframework.stereotype.Component;

@Component
public class HomePage {
    private Page page;

    public void navigateToHome() {
        page= PlaywrightFactory.getPage();
        page.navigate("https://google.com");
    }

    public String getTitle() {
        return page.title();
    }
}
