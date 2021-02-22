package com.travelers.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Class contains HomePage's Web Elements
public class HomePage {
    //Find hotel/city search
    @FindBy (xpath = "//*[@id=\"s2id_autogen8\"]/a/span[1]")
    private WebElement searchSpan;

    @FindBy (xpath = "//*[@id=\"select2-drop\"]/div/input")
    private WebElement searchCityInput;
    //Find checkin date
    @FindBy (name = "checkin")
    private WebElement checkIn;
    //find checkout date
    @FindBy (name = "checkout")
    private  WebElement checkOut;

    //Constructor for class HomePage
    public HomePage(WebDriver driver) {
        //Class initialization
        PageFactory.initElements(driver, this);
    }

    public void setCityName(String cityName) throws InterruptedException {
        searchSpan.click();
        searchCityInput.sendKeys(cityName);
        Thread.sleep(4000);
        searchCityInput.sendKeys(Keys.ENTER);
    }

    public void setDateRange(String checkInDate, String checkOutDate){
        //checkIn.click();
        checkIn.sendKeys(checkInDate);
        //checkOut.click();
        checkOut.sendKeys(checkOutDate);
        checkOut.click();

    }

}
