package com.travelers.tests;

import com.travelers.pages.HomePage;
import com.travelers.pages.ResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
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
        ResultPage resultPage = new ResultPage(driver);

        List<String> hotelNames = resultPage.getHotelNames();
        Assert.assertEquals(hotelNames.get(0), "Jumeirah Beach Hotel");
        Assert.assertEquals(hotelNames.get(1), "Oasis Beach Tower");
        Assert.assertEquals(hotelNames.get(2), "Rose Rayhaan Rotana");
        Assert.assertEquals(hotelNames.get(3), "Hyatt Regency Perth");
        Thread.sleep(4000);
        //Get hotels prices
        List<String> prices = resultPage.getHotelPrices();
        Assert.assertEquals(prices.get(0), "$22");
        Assert.assertEquals(prices.get(1), "$50");
        Assert.assertEquals(prices.get(2), "$80");
        Assert.assertEquals(prices.get(3), "$150");

    }
}
