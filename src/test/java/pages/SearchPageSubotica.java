package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPageSubotica extends BasePage{
    By headerTitleBy = By.cssSelector(".efdb2b543b.e4b7a69a57 h1");

    By dateFromDataBy = By.cssSelector(".b91c144835 button:nth-of-type(1)");
    By dateToDataBy = By.cssSelector(".b91c144835 button:nth-of-type(2)");
    By guestRoomsDateBy = By.cssSelector(".d67edddcf0 button");

    By apartmentCardsPlaceBy = By.cssSelector("span[data-testid='address']");

    public SearchPageSubotica(WebDriver driver) {
        super(driver);
    }

    public String getHeaderTitle(){
        WebElement headerTitle = waitElement("visible", headerTitleBy);
        return headerTitle.getText();
    }

    public String getDateData(){
        WebElement dateFrom = waitElement("visible", dateFromDataBy);
        WebElement dateTo = waitElement("visible", dateToDataBy);
        return dateFrom.getText() + "-" + dateTo.getText();
    }

    public String getGuestAndRoomData(){
        WebElement data = waitElement("visible", guestRoomsDateBy);
        return data.getText();
    }

    public List<String> getApartmentCardsPlace(){
        List<WebElement> places = waitElements("visible", apartmentCardsPlaceBy);
        return getElementsText(places);
    }
}
