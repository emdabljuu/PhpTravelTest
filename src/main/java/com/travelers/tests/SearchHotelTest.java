package com.travelers.tests;

import com.travelers.pages.HomePage;
import org.testng.annotations.Test;


public class SearchHotelTest extends BaseSeleniumTest{

    @Test
    public void searchHotelTest() throws InterruptedException {
        //Getting correct website address
        String website = "http://www.kurs-selenium.pl/demo/";
        driver.get(website);
        HomePage homePage = new HomePage(driver);
        homePage.sendKeysToCityInput("Miami");

    }
}
