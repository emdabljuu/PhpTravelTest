//package
package com.travelers.tests;
//imports
import com.travelers.helpers.DriverFactory;
import com.travelers.helpers.DriverType;
import com.travelers.helpers.NoSuchDriverException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseSeleniumTest {

    //range validation
    protected WebDriver driver;

    //Methods before main class @test
    @BeforeClass
    public void SetUp() throws NoSuchDriverException {
        System.out.println("Before class");
        driver = DriverFactory.getDriver(DriverType.CHROME);
    }
    //Methods after main class @test
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        //Message in part AfterClass
        System.out.println("After class");
        //Browser close down
        driver.quit();
        driver = null;
    }

}
