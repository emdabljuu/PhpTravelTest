package com.travelers.helpers;

import com.travelers.helpers.DriverFactory;
import com.travelers.helpers.SeleniumHelper;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        try {
            System.out.println("On test failure");
            SeleniumHelper.takeScreenshot(DriverFactory.getDriver(DriverType.FIREFOX));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
