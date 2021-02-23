package com.travelers.pages;

import com.travelers.helpers.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Class contains HomePage's Web Elements
public class HomePage {
    //Find hotel/city search
    @FindBy (xpath = "//*[@id=\"s2id_autogen8\"]/a/span[1]")
    private WebElement searchSpan;

    @FindBy (xpath = "//*[@id=\"select2-drop\"]/div/input")
    private WebElement searchCityInput;
    //find checkin date
    @FindBy (name = "checkin")
    private WebElement checkIn;
    //find checkout date
    @FindBy (name = "checkout")
    private  WebElement checkOut;
    //find travellers
    @FindBy (id = "travellersInput")
    private  WebElement travellersInput;
    //find Adults
    @FindBy (name = "adults")
    private  WebElement adultsNumber;
    //find Child
    @FindBy (name = "child")
    private  WebElement childNumber;
    //Find search Button
    @FindBy (xpath = "//*[@id=\"hotels\"]/form/div[5]/button")
    private WebElement searchButton;
    //Find table with results
    @FindBy (xpath = "//table[@class='bgwhite table table-striped']")
    private WebElement resultsTable;

    private SeleniumHelper helper;

    //Constructor for class HomePage
    public HomePage(WebDriver driver) {
        //Class initialization
        PageFactory.initElements(driver, this);
        this.helper = new SeleniumHelper(driver);
    }

    public void setCityName(String cityName) {
        searchSpan.click();
        searchCityInput.sendKeys(cityName);
        By locationlabel = By.xpath("//div[@class = 'select2-result-label']");
        helper.waitForElementToBeDisplayed(locationlabel);
        searchCityInput.sendKeys(Keys.ENTER);
    }

    public void setDateRange(String checkInDate, String checkOutDate){
        //checkIn.click();
        checkIn.sendKeys(checkInDate);
        //checkOut.click();
        checkOut.sendKeys(checkOutDate);

    }
    //Public class, set number of travellers by sendKeys
    public void setTravellersInput(String adults, String child){
        travellersInput.click();
        //Clear default values and set adults number
        adultsNumber.clear();
        adultsNumber.sendKeys(adults);
        //Clear default values and set child number
        childNumber.clear();
        childNumber.sendKeys(child);
    }

    //Public class, start searching
    public void startSearch(){
        searchButton.click();
    }

    //Public class, analyze table with results
    public List<String> getHotelNames(){
        List<String> hotelNames = new ArrayList<>();
        List<WebElement> hotelNameWebElements = resultsTable.findElements(By.xpath("//h4//b"));
        for(WebElement hotelNameWebElement: hotelNameWebElements) {
            System.out.println(hotelNameWebElement.getText());
            hotelNames.add(hotelNameWebElement.getText());
        }
        return hotelNames;
    }

    //Public class, get Hotel Prices
    public List<String> getHotelPrices() {
        List<WebElement> hotelPrices = resultsTable.findElements(By.xpath("//div[contains(@class,'price_tab')]//b"));
        List<String> prices = hotelPrices.stream().map(element -> element.getText()).collect(Collectors.toList());
        System.out.println(prices);
        return prices;
    }
}


