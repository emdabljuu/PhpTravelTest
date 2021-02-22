package com.travelers.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Class contains HomePage's Web Elements
public class HomePage {
    //Find hotel/city search
    @FindBy (xpath = "//*[@id=\"select2-drop\"]/div/input")
    private WebElement searchSpan;

    @FindBy (xpath = "//input[@class='select2-input']")
    private WebElement searchCityInput;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void sendKeysToCityInput(String cityName){
        searchSpan.click();
        //searchCityInput.sendKeys(cityName);
    }

}
