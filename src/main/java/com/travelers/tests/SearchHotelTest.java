package com.travelers.tests;

import com.travelers.helpers.TestListener;
import com.travelers.pages.HomePage;
import com.travelers.pages.ResultPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.travelers.helpers.ExcelHelper.readExcelFile;

@Listeners(TestListener.class)
public class SearchHotelTest extends BaseSeleniumTest{
    //Main Test
    @Test(dataProvider = "getData")
    public void searchHotelTest(String city, String checkInDate, String checkOutDate, String fHotel, String fPrice,
                                String sHotel, String sPrice, String tHotel, String tPrice)
                                throws InterruptedException, IOException {
        //Wait for website
        //driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);
        //Getting correct website address
        String website = "http://www.kurs-selenium.pl/demo/";
        //Hand website name over to driver
        driver.get(website);
        //Create new HomePage object
        HomePage homePage = new HomePage(driver);
        //Methods execution on homePage
        //Add cityName to constructor
        homePage.setCityName(city);
        //Add dateRange to constructor
        homePage.setDateRange(checkInDate, checkOutDate);
        //Add travellers to constructor
        homePage.setTravellersInput("6","3");
        //Start searching
        homePage.startSearch();
        //Get hotel Names
        Thread.sleep(4000);
        ResultPage resultPage = new ResultPage(driver);

        List<String> hotelNames = resultPage.getHotelNames();
        //SeleniumHelper.takeScreenshot(driver);
        Assert.assertEquals(hotelNames.get(0), fHotel);
        Assert.assertEquals(hotelNames.get(1), sHotel);
        Assert.assertEquals(hotelNames.get(2), tHotel);
        Assert.assertEquals(hotelNames.get(3), "Hyatt Regency Perth");
        Thread.sleep(4000);
        //Get hotels prices
        List<String> prices = resultPage.getHotelPrices();
        Assert.assertEquals(prices.get(0), fPrice);
        Assert.assertEquals(prices.get(1), sPrice);
        Assert.assertEquals(prices.get(2), tPrice);
        Assert.assertEquals(prices.get(3), "$150");


    }
    @DataProvider
    public Object[][] getData() throws IOException {
        Object[][] data = null;
        try {
            data = readExcelFile(new File("src/main/resources/Dane.xlsx"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
