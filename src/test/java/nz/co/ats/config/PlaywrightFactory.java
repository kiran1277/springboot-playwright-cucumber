package nz.co.ats.config;

import com.microsoft.playwright.*;

public class PlaywrightFactory {

    private static final ThreadLocal<Playwright> playwrightThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<Browser> browserThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> contextThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<Page> pageThreadLocal = new ThreadLocal<>();

    public static void init(String browserName) {
        Playwright playwright = Playwright.create();
        playwrightThreadLocal.set(playwright);

        BrowserType browserType = switch (browserName.toLowerCase()) {
            case "firefox" -> playwright.firefox();
            case "webkit" -> playwright.webkit();
            default -> playwright.chromium(); // default
        };

        Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        browserThreadLocal.set(browser);

        BrowserContext context = browser.newContext();
        contextThreadLocal.set(context);

        Page page = context.newPage();
        pageThreadLocal.set(page);
    }

    public static Page getPage() {
        return pageThreadLocal.get();
    }

    public static void cleanup() {
        if (contextThreadLocal.get() != null) contextThreadLocal.get().close();
        if (browserThreadLocal.get() != null) browserThreadLocal.get().close();
        if (playwrightThreadLocal.get() != null) playwrightThreadLocal.get().close();

        contextThreadLocal.remove();
        browserThreadLocal.remove();
        playwrightThreadLocal.remove();
        pageThreadLocal.remove();
    }
}
