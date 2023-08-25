package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;

import java.time.Duration;

public abstract class BaseTest {
    private DriverManager driverManager;
    protected WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(String browser) {
        try{
            driverManager = DriverManagerFactory.getDriverManager(browser);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage()) ;
            Assert.fail("Driver manager was not initialized correctly. Check input browser param.");
        }

        driver = driverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    @Parameters({"quit"})
    public void tearDown(String quit){
        if (quit.equalsIgnoreCase("Yes")){
            driverManager.quitDriver();
        }
    }

}
