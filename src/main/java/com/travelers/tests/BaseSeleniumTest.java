//package
package com.travelers.tests;
//imports
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseSeleniumTest {

    //range validation
    protected WebDriver driver;

    //Methods before main class @test
    @BeforeClass
    public void SetUp() {
        System.out.println("Before class");
        //Loading driver path from resources
        String driverPath = "src/main/resources/executables.driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        //Creating new object
        driver = new ChromeDriver();
        //maximizing browser window
        driver.manage().window().maximize();
    }
    //Methods after main class @test
    @AfterClass
    public void tearDown(){
        //Message in part AfterClass
        System.out.println("After class");
        //Browser close down
        //driver.quit();
    }

}
