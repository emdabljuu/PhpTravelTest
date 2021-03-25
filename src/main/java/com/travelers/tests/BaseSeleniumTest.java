//package
package com.travelers.tests;
//imports
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.travelers.helpers.SeleniumHelper;
import com.travelers.drivers.DriverFactory;
import com.travelers.drivers.DriverType;
import com.travelers.exceptions.NoSuchDriverException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public abstract class BaseSeleniumTest {

    //range validation
    protected WebDriver driver;
    protected ExtentHtmlReporter reporter;
    protected ExtentReports reports;

    @BeforeTest
    public void setUpReporter() {
        System.out.println("Report is making...");
        reporter = new ExtentHtmlReporter("src//main//resources//reports//index.html");
        reports = new ExtentReports();
        reports.attachReporter(reporter);
    }

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

    @AfterTest
    public void tearDownReporter() {
        reporter.flush();
        reports.flush();
    }

    MediaEntityModelProvider getScreenshot() throws IOException {
        return MediaEntityBuilder.createScreenCaptureFromPath(SeleniumHelper.takeScreenshot(driver)).build();
    }

}
