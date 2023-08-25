package selenium_core;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager{
    @Override
    public void createDriver() {
        // WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        // options.addArguments("--incognito");
        driver = new ChromeDriver(options);
    }
}
