package session3;

import com.microsoft.playwright.*;

import java.util.Arrays;

public class LaunchOptionsDemo {
        /*
        * 1. headless: true/false
        * 2. slowMo: number (ms)
        * 3. channel: "chrome", "chromium", "msedge", "firefox", "chromium-edge"
        * 4. args: array of string (command line arguments to pass to the browser instance)
        * 5. executablePath: string (path to the browser executable)
        * 6. env: object (environment variables to pass to the browser process)
        * 7. timeout: number (ms) - maximum time to wait for the browser instance to start
        * 8. proxy: object (proxy settings for the browser instance)
        * 9. downloadsPath: string (path to save downloaded files)
        * 10. firefoxUserPrefs: object (Firefox user preferences)
        */

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();


        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions();
        options.setHeadless(false);
        options.setSlowMo(500);

        options.setChannel("chrome");
        //options.setExecutablePath("/path/to/chrome");
        options.setArgs(Arrays.asList( "--start-maximized","--disable-notifications"));

        options.setTimeout(30000);

        //options.setProxy(new ProxySettings("http://proxyserver:8080"));

        //options.setFirefoxUserPrefs(Map.of("browser.startup.homepage", "https://www.google.com"));
        Browser browser = playwright.chromium().launch(options);



        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page =  context.newPage();
        page.navigate("https://www.yatra.com");






    }



}
