package com.travelers.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseSeleniumTest {

    protected WebDriver driver;

    @BeforeClass
    public void SetUp() {
        System.out.println("Before class");
        String driverPath = "src/main/resources/executables.drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown(){
        System.out.println("After class");
        //driver.quit();
    }

}
