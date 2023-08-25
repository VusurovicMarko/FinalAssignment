package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.ArrayList;
import java.util.List;

public class BookingTest extends BaseTest{

    @Test
    public void testDestinationKopaonik(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.dismissStartPopUp();

        homePage.enterDestination("Kopaonik");

        int fromDate = 27; // 28 Avgust
        int toDate = 45;  // 15 September
        homePage.enterCheckInCheckOutDate(fromDate, toDate);

        int noOfAdults = 1;  // default is '2'
        int noOfRooms = 1;   // default is '1'
        List<Integer> childAges = new ArrayList<Integer>();  // default is '0'
        childAges.add(5);
        homePage.enterGuestsAndRooms(noOfAdults, noOfRooms, childAges);
        homePage.clickSearchBtn();

        SearchPageKopaonik searchResulPage = new SearchPageKopaonik(driver);
        Assert.assertEquals(searchResulPage.getPageTitle(), "Booking.com: Hotels in Kopaonik. Book your hotel now!",
            "[]Search page title doesn't match");

        Assert.assertTrue(searchResulPage.getHeaderTitle().contains("Kopaonik: "), "[]Header title doesn't contains string.");

        String expectedDateRangeData = "Mon, Aug 28-Fri, Sep 15";
        Assert.assertEquals(searchResulPage.getDateData(), expectedDateRangeData, "[]Date data doesn't match.");

        String expectedGuestRoomData = "Mon, 28 Aug-Mon, 28 Aug";
        Assert.assertTrue(searchResulPage.getGuestAndRoomData().contains("3 adults"), "[]Guest-Rooms adults data doesn't match.");
        Assert.assertTrue(searchResulPage.getGuestAndRoomData().contains("1 child"), "[]Guest-Rooms child data doesn't match.");
        System.out.println("Guest data: "+searchResulPage.getGuestAndRoomData());
        Assert.assertTrue(searchResulPage.getGuestAndRoomData().contains("2 rooms"), "[]Guest-Rooms rooms data doesn't match.");

        List<String> places = searchResulPage.getApartmentCardsPlace();
        int i = 0;
        for(String place: places){
            Assert.assertEquals(place, "Kopaonik", "[x-"+i+"]Place doesn't match.");
            i ++;
        }
    }

    @Test
    public void testDestinationNoviSad(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.dismissStartPopUp();

        homePage.enterDestination("Novi Sad");

        int fromDate = 25; // 26 Avgust
        int toDate = 30;  // 31 Avgust
        homePage.enterCheckInCheckOutDate(fromDate, toDate);

        int noOfAdults = 2;  // default is '2'
        int noOfRooms = 2;   // default is '1'
        List<Integer> childAges = new ArrayList<Integer>();  // default is '0'
        childAges.add(6);
        homePage.enterGuestsAndRooms(noOfAdults, noOfRooms, childAges);
        homePage.clickSearchBtn();

        SearchPageNoviSad pageNoviSad = new SearchPageNoviSad(driver);
        Assert.assertEquals(pageNoviSad.getPageTitle(), "Booking.com: Hotels in Novi Sad. Book your hotel now!",
                "[]Search page title doesn't match");

        Assert.assertTrue(pageNoviSad.getHeaderTitle().contains("Novi Sad: "), "[]Header title doesn't contains string.");

        String expectedDateRangeData = "Sat, Aug 26-Thu, Aug 31";
        Assert.assertEquals(pageNoviSad.getDateData(), expectedDateRangeData, "[]Date data doesn't match.");

        String expectedGuestRoomData = "Sat, Aug 26-Thu, Aug 31";
        Assert.assertTrue(pageNoviSad.getGuestAndRoomData().contains("4 adults"), "[]Guest-Rooms adults data doesn't match.");
        Assert.assertTrue(pageNoviSad.getGuestAndRoomData().contains("1 child"), "[]Guest-Rooms child data doesn't match.");
        Assert.assertTrue(pageNoviSad.getGuestAndRoomData().contains("3 rooms"), "[]Guest-Rooms rooms data doesn't match.");

        List<String> places = pageNoviSad.getApartmentCardsPlace();
        int i = 0;
        for(String place: places){
            Assert.assertEquals(place, "Novi Sad", "[x-"+i+"]Place doesn't match.");
            i ++;
        }
    }

    @Test
    public void testDestinationSubotica(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.dismissStartPopUp();

        homePage.enterDestination("Subotica");

        int fromDate = 31; // 01 Septembar
        int toDate = 34;  // 04 Septembar
        homePage.enterCheckInCheckOutDate(fromDate, toDate);

        int noOfAdults = 3;  // default is '2'
        int noOfRooms = 3;   // default is '1'
        List<Integer> childAges = new ArrayList<Integer>();  // default is '0'
        childAges.add(12);
        homePage.enterGuestsAndRooms(noOfAdults, noOfRooms, childAges);
        homePage.clickSearchBtn();

        SearchPageSubotica pageSubotica = new SearchPageSubotica(driver);
        Assert.assertEquals(pageSubotica.getPageTitle(), "Booking.com: Hotels in Subotica. Book your hotel now!",
                "[]Search page title doesn't match");

        Assert.assertTrue(pageSubotica.getHeaderTitle().contains("Subotica: "), "[]Header title doesn't contains string.");

        String expectedDateRangeData = "Fri, Sep 1-Mon, Sep 4";
        Assert.assertEquals(pageSubotica.getDateData(), expectedDateRangeData, "[]Date data doesn't match.");

        String expectedGuestRoomData = "Fri, Sep 1-Mon, Sep 4";
        Assert.assertTrue(pageSubotica.getGuestAndRoomData().contains("5 adults"), "[]Guest-Rooms adults data doesn't match.");
        Assert.assertTrue(pageSubotica.getGuestAndRoomData().contains("1 child"), "[]Guest-Rooms child data doesn't match.");
        Assert.assertTrue(pageSubotica.getGuestAndRoomData().contains("4 rooms"), "[]Guest-Rooms rooms data doesn't match.");

        List<String> places = pageSubotica.getApartmentCardsPlace();
        int i = 0;
        for(String place: places){
            Assert.assertEquals(place, "Subotica", "[x-"+i+"]Place doesn't match.");
            i ++;
        }
    }
    @Test
    public void testDestinationNis(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.dismissStartPopUp();

        homePage.enterDestination("Niš");

        int fromDate = 25; // 26 Avgust
        int toDate = 32;  // 02 Septembar
        homePage.enterCheckInCheckOutDate(fromDate, toDate);

        int noOfAdults = 1;  // default is '2'
        int noOfRooms = 1;   // default is '1'
        List<Integer> childAges = new ArrayList<Integer>();  // default is '0'
        childAges.add(15);
        homePage.enterGuestsAndRooms(noOfAdults, noOfRooms, childAges);
        homePage.clickSearchBtn();

        SearchPageNis pageNis = new SearchPageNis(driver);
        Assert.assertEquals(pageNis.getPageTitle(), "Booking.com: Hotels in Niš. Book your hotel now!",
                "[]Search page title doesn't match");

        Assert.assertTrue(pageNis.getHeaderTitle().contains("Niš: "), "[]Header title doesn't contains string.");

        String expectedDateRangeData = "Sat, Aug 26-Sat, Sep 2";
        Assert.assertEquals(pageNis.getDateData(), expectedDateRangeData, "[]Date data doesn't match.");

        String expectedGuestRoomData = "Sat, Aug 26-Sat, Sep 2";
        Assert.assertTrue(pageNis.getGuestAndRoomData().contains("3 adults"), "[]Guest-Rooms adults data doesn't match.");
        Assert.assertTrue(pageNis.getGuestAndRoomData().contains("1 child"), "[]Guest-Rooms child data doesn't match.");
        Assert.assertTrue(pageNis.getGuestAndRoomData().contains("2 rooms"), "[]Guest-Rooms rooms data doesn't match.");

        List<String> places = pageNis.getApartmentCardsPlace();
        int i = 0;
        for(String place: places){
            Assert.assertEquals(place, "Niš", "[x-"+i+"]Place doesn't match.");
            i ++;
        }
    }

    @Test
    public void testDestinationDivcibare(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.dismissStartPopUp();

        homePage.enterDestination("Divčibare");

        int fromDate = 30; // 31 Avgust
        int toDate = 37;  // 02 Septembar
        homePage.enterCheckInCheckOutDate(fromDate, toDate);

        int noOfAdults = 4;  // default is '2'
        int noOfRooms = 2;   // default is '1'
        List<Integer> childAges = new ArrayList<Integer>();  // default is '0'
        homePage.enterGuestsAndRooms(noOfAdults, noOfRooms, childAges);
        homePage.clickSearchBtn();

        SearchPageDivcibare pageDivcibare = new SearchPageDivcibare(driver);
        Assert.assertEquals(pageDivcibare.getPageTitle(), "Booking.com: Hotels in Divčibare. Book your hotel now!",
                "[]Search page title doesn't match");

        Assert.assertTrue(pageDivcibare.getHeaderTitle().contains("Divčibare: "), "[]Header title doesn't contains string.");

        String expectedDateRangeData = "Thu, Aug 31-Thu, Sep 7";
        Assert.assertEquals(pageDivcibare.getDateData(), expectedDateRangeData, "[]Date data doesn't match.");

        String expectedGuestRoomData = "Thu, Aug 31-Thu, Sep 7";
        Assert.assertTrue(pageDivcibare.getGuestAndRoomData().contains("6 adults"), "[]Guest-Rooms adults data doesn't match.");
        Assert.assertTrue(pageDivcibare.getGuestAndRoomData().contains("0 child"), "[]Guest-Rooms child data doesn't match.");
        Assert.assertTrue(pageDivcibare.getGuestAndRoomData().contains("3 rooms"), "[]Guest-Rooms rooms data doesn't match.");

        List<String> places = pageDivcibare.getApartmentCardsPlace();
        int i = 0;
        for(String place: places){
            Assert.assertEquals(place, "Divčibare", "[x-"+i+"]Place doesn't match.");
            i ++;
        }
    }
}
