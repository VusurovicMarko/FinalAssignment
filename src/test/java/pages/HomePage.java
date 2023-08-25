package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage extends BasePage{
    public static final String PAGE_URL = "https://www.booking.com/";

    public HomePage(WebDriver driver) {
        super(driver);

    }

    By popUpCloseIconBy = By.cssSelector(".abcc616ec7.cc1b961f14.c180176d40.f11eccb5e8.ff74db973c");
    By inputDestinationFieldBy = By.cssSelector(".b9b84f4305 input");
    By checkInCheckOutFieldBy = By.cssSelector(".b91c144835>span:nth-of-type(2)");
    By checkInAndOutDatesBy = By.cssSelector(".cf06f772fa");

    By guestsAndRoomsFieldBy = By.cssSelector(".d47738b911.b7d08821c3");
    By adultPlusIconBy = By.cssSelector(".a7a72174b8:nth-child(1) .bfb38641b0 >button:nth-of-type(2)");
    By adultCounterBy = By.cssSelector(".a7a72174b8:nth-child(1) .bfb38641b0 > span");
    By childPlusIconBy = By.cssSelector(".a7a72174b8:nth-child(2) .bfb38641b0 >button:nth-of-type(2)");
    By childCounterBy = By.cssSelector(".a7a72174b8:nth-child(2) .bfb38641b0 > span");
    By selectChildAgesBy = By.cssSelector("div[data-testid='kids-ages'] select");
    By roomsPlusIconBy = By.cssSelector(".a7a72174b8:nth-child(3) .bfb38641b0 >button:nth-of-type(2)");
    By roomsCounterBy = By.cssSelector(".a7a72174b8:nth-child(3) .bfb38641b0 > span");
    By adultChildRoomDoneBtnBy = By.cssSelector(".a5da3001f3.a73af396c3>button");

    By searchBtnBy = By.cssSelector("button[type='submit']");


    public void openPage(){
        goToPage(PAGE_URL);
    }

    public void dismissStartPopUp(){
        WebElement popUpCloseIcon = waitElement("visible", popUpCloseIconBy);  // wait to be visible
        popUpCloseIcon.click();
    }

    /**
     * enterDestination
     *
     * @param destination input destination
     */
    public void enterDestination(String destination){
        WebElement inField = waitElement("visible", inputDestinationFieldBy);
        inField.sendKeys(destination);
    }

    public void enterCheckInCheckOutDate(int fromDateIndex, int toDateIndex){
        WebElement field = waitElement("visible", checkInCheckOutFieldBy);
        field.click(); // open date dialog

        List<WebElement> dates = waitElements("visible", checkInAndOutDatesBy); // open date dialog
        dates.get(fromDateIndex).click();
        dates.get(toDateIndex).click();

        field.click(); // close date dialog
    }

    public void enterGuestsAndRooms(int noOfAdults, int noOfRooms, List<Integer> inputChildsAge){
        WebElement field = waitElement("visible", guestsAndRoomsFieldBy);
        field.click(); // open date dialog

        // adults
        WebElement adultPlusIcon = waitElement("clickable", adultPlusIconBy);
        WebElement adultCounter = waitElement("visible", adultCounterBy);
        for (int i=0; i<noOfAdults; i++){
            adultPlusIcon.click();
            System.out.println("Adults: "+ adultCounter.getText());
        }

        // rooms - first need to set Rooms after that Childs !!!
        WebElement roomsPlusIcon = waitElement("clickable", roomsPlusIconBy);
        WebElement roomsCounter = waitElement("visible", roomsCounterBy);
        for (int i=0; i<noOfRooms; i++){
            roomsPlusIcon.click();
            System.out.println("Rooms: "+ roomsCounter.getText());
        }

        // childs
        WebElement childPlusIcon = waitElement("clickable", childPlusIconBy);
        WebElement childCounter = waitElement("visible", childCounterBy);
        for (int i=0; i<inputChildsAge.size(); i++){
            childPlusIcon.click();
            System.out.println("Childs: "+ childCounter.getText());
        }
        List<WebElement> selectChildAges = waitElements("visible", selectChildAgesBy);
        for(int i=0; i<selectChildAges.size(); i++){
            Select select = new Select(selectChildAges.get(i));
            select.selectByValue(String.valueOf(inputChildsAge.get(i)));
        }

//        selectChildAges.get(0).click();
//        List<WebElement> options = new Select(selectChildAges.get(0)).getOptions();
//        for (WebElement option : options) {
//            String attr = option.getAttribute("value");
//            if (attr != null && attr.equalsIgnoreCase(String.valueOf(inputChildsAge.get(0)))) {
//                option.click();
//                break;
//            }
//        }
    }

    public void clickSearchBtn(){
        WebElement searchBtn = waitElement("clickable", searchBtnBy);
        searchBtn.click();
    }
}

