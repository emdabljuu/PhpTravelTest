package com.travelers.helpers;

import com.travelers.drivers.DriverType;
import com.travelers.drivers.DriverFactory;
import com.travelers.exceptions.NoSuchDriverException;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import org.apache.log4j.Logger;

public class TestListener implements ITestListener {

    Logger log = Logger.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.debug("On test start");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        try {
            log.debug("On test failure");
            SeleniumHelper.takeScreenshot(DriverFactory.getDriver(DriverType.CHROME));
        } catch (IOException | NoSuchDriverException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.debug("On test success");
    }

}
