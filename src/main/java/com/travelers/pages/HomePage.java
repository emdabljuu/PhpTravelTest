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

    //Constructor for class HomePage
    public HomePage(WebDriver driver) {
        //Class initialization
        PageFactory.initElements(driver, this);
    }

    public void sendKeysToCityInput(String cityName) throws InterruptedException {
        searchSpan.click();
        searchCityInput.sendKeys(cityName);
        Thread.sleep(6000);
        searchCityInput.sendKeys(Keys.ENTER);
    }

}
