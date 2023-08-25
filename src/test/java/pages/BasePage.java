package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class BasePage {
    protected final WebDriver driver;
    WebDriverWait webDriverWait;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void goToPage(String url){
        driver.get(url);
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public WebElement waitElement(String waitType, By locator){
        WebElement element = null;
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0)); // iskljucimo implicit wait
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
            switch (waitType){
                case "present" : { element = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator)); break; }
                case "visible" : { element =  webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));  break; }
                case "clickable" : { element =  webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));  break; }
                default: element = null;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
            element = null;
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // vracamo implicit wait
        return element;
    }

    public List<WebElement> waitElements(String waitType, By locator){
        List<WebElement> elements = new ArrayList<>();
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            switch (waitType){
                case "present" : { elements = webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator)); break;  }
                case "visible" : { elements = webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)); break;  }
                default: return null;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // vracamo implicit wait
        return elements;
    }

    public List<String> getElementsText(List<WebElement> inputWebElements){
        List<String> result = new ArrayList<>();
        for(WebElement element: inputWebElements){
            result.add( element.getText() );
        }
        return result;
    }

}
