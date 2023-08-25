package selenium_core;

import org.openqa.selenium.InvalidArgumentException;

public final class DriverManagerFactory {

    private DriverManagerFactory() {}

    public static DriverManager getDriverManager (String browser) throws InvalidArgumentException {
        DriverManager driverManager;
        browser = browser.toUpperCase();
        switch (browser) {
            case "CHROME": {
                driverManager = new ChromeDriverManager();
            }
            break;
            case "FIREFOX": {
                driverManager = new FirefoxDriverManager();
            }
            break;
            default:
                throw new InvalidArgumentException("Browser: " + browser + " is not supported!");
        }
        return driverManager;
    }
}
