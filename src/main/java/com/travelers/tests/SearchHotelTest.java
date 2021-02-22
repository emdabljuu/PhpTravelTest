package com.travelers.tests;

import com.travelers.pages.HomePage;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class SearchHotelTest extends BaseSeleniumTest{
    //Main Test
    @Test
    public void searchHotelTest() throws InterruptedException {
        //Wait for website
        driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);
        //Getting correct website address
        String website = "http://www.kurs-selenium.pl/demo/";
        //Hand website name over to driver
        driver.get(website);
        //Create new HomePage object
        HomePage homePage = new HomePage(driver);
        //Methods execution on homePage
        //Add cityName to constructor
        homePage.setCityName("Dubai");
        //Add dateRange to constructor
        homePage.setDateRange("01/02/2018", "07/02/2018");
        //Add travellers to constructor
        homePage.setTravellersInput("6","3");
        //Start searching
        homePage.startSearch();
        //Get hotel Names
        Thread.sleep(4000);
        homePage.getHotelNames();
        Thread.sleep(4000);
        //Get hotels prices
        homePage.getHotelPrices();

    }
}
