package com.travelers.pages;

import com.travelers.helpers.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultPage {
    @FindBy(xpath = "//table[@class='bgwhite table table-striped']")
    private WebElement resultsTable;

    private SeleniumHelper helper;

    public ResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        helper = new SeleniumHelper(driver);
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
