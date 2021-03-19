//package
package com.travelers.tests;
//imports
import com.travelers.utils.DriverFactory;
import com.travelers.helpers.DriverType;
import com.travelers.helpers.NoSuchDriverException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public abstract class BaseSeleniumTest {

    //range validation
    protected WebDriver driver;

    //Methods before main class @test
    @BeforeMethod
    public void SetUp() throws NoSuchDriverException, IOException {
        System.out.println("Before class");
        driver = DriverFactory.getDriver(DriverType.CHROME);
    }
    //Methods after main class @test
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        //Message in part AfterClass
        System.out.println("After class");
        //Browser close down
        driver.quit();
        DriverFactory.resetDriver();
    }

}
