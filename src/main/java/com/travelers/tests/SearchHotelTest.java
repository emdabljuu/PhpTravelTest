package com.travelers.tests;

import com.travelers.pages.HomePage;
import org.testng.annotations.Test;


public class SearchHotelTest extends BaseSeleniumTest{
    //Main Test
    @Test
    public void searchHotelTest() throws InterruptedException {
        //Getting correct website address
        String website = "http://www.kurs-selenium.pl/demo/";
        //Hand website name over to driver
        driver.get(website);
        //Create new HomePage object
        HomePage homePage = new HomePage(driver);
        //Methods execution on homePage
        homePage.setCityName("Miami");
        homePage.setDateRange("01/02/2018", "07/02/2018");

    }
}
