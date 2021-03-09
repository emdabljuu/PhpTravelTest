//package
package com.travelers.tests;
//imports
import com.travelers.helpers.DriverFactory;
import com.travelers.helpers.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public abstract class BaseSeleniumTest {

    //range validation
    protected WebDriver driver;

    //Methods before main class @test
    @BeforeClass
    public void SetUp() throws IOException {
        System.out.println("Before class");
        //Loading driver path from resources
        String driverPath = "src/main/resources/executables.driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        //Creating new object
        driver = DriverFactory.getDriver(DriverType.FIREFOX);
    }
    //Methods after main class @test
    @AfterClass
    public void tearDown(){
        //Message in part AfterClass
        System.out.println("After class");
        //Browser close down
        driver.quit();
    }

}
