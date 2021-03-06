package com.travelers.pages;

import com.travelers.helpers.SeleniumHelper;
import org.apache.log4j.Logger;
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

    private Logger log = Logger.getLogger(HomePage.class);

    //Constructor for class HomePage
    public HomePage(WebDriver driver) {
        //Class initialization
        PageFactory.initElements(driver, this);
        this.helper = new SeleniumHelper(driver);
    }

    public void setCityName(String cityName) {
        log.info(("Input city"));
        searchSpan.click();
        searchCityInput.sendKeys(cityName);
        By locationlabel = By.className("select2-result-label");
        helper.waitForElementToBeDisplayed(locationlabel);
        searchCityInput.sendKeys(Keys.ENTER);
        log.info("City name set");
    }
//    public void setCityName(String cityName) {
//        searchSpan.click();
//        searchCityInput.sendKeys(cityName);
//        By locationlabel = By.xpath("//div[@class = 'select2-result-label']");
//        helper.waitForElementToBeDisplayed(locationlabel);
//        searchCityInput.sendKeys(Keys.ENTER);
//    }


    public void setDateRange(String checkInDate, String checkOutDate){
        //checkIn.click();
        log.info("Setting date range");
        checkIn.sendKeys(checkInDate);
        //checkOut.click();
        checkOut.sendKeys(checkOutDate);
        log.info("Date range is set");
    }
    //Public class, set number of travellers by sendKeys
    public void setTravellersInput(String adults, String child){
        log.info("Set field adults");
        travellersInput.click();
        //Clear default values and set adults number
        adultsNumber.clear();
        adultsNumber.sendKeys(adults);
        log.info("Adults have been added");
        //Clear default values and set child number
        log.info("Set field children");
        childNumber.clear();
        childNumber.sendKeys(child);
        log.info("Children have been added");
    }

    //Public class, start searching
    public void startSearch(){
        log.info("Start searching");
        searchButton.click();
    }

}


