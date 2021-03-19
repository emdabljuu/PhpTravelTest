package com.travelers.utils;

import com.travelers.helpers.DriverType;
import com.travelers.helpers.NoSuchDriverException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;

import java.io.File;
import java.io.IOException;

public class DriverFactory {

    private static WebDriver driverInstance;
    public static WebDriver getDriver(DriverType driverType) throws NoSuchDriverException, IOException {
        if(driverInstance == null) {
            getSpecificDriver(driverType);
            driverInstance.manage().window().maximize();
        }
        return driverInstance;
    }

    private static void getSpecificDriver(DriverType driverType) throws NoSuchDriverException, IOException {

        switch (driverType) {
            case IE:
                File ieExe = new File("src/main/resources/executables.driver/IEDriverServer.exe");
                InternetExplorerDriverService ieService = new InternetExplorerDriverService.Builder()
                        .usingDriverExecutable(ieExe)
                        .usingAnyFreePort().build();
                driverInstance = new InternetExplorerDriver(ieService);
            break;

            case CHROME:
                File chromeExe = new File("src/main/resources/executables.driver/chromedriver1.exe");
                ChromeDriverService chromeService = new ChromeDriverService.Builder()
                        .usingDriverExecutable(chromeExe)
                        .usingAnyFreePort().build();
                driverInstance = new ChromeDriver(chromeService);
            break;

            case FIREFOX:
                File firefoxExe = new File("src/main/resources/executables.driver/geckodriver.exe");
                GeckoDriverService geckoDriverService = new GeckoDriverService.Builder()
                        .usingDriverExecutable(firefoxExe)
                        .usingAnyFreePort().build();
                driverInstance = new FirefoxDriver(geckoDriverService);
            break;

            default:
                System.out.println("Brak drivera danego typu");
                throw new NoSuchDriverException();
        }
    }

    public static void resetDriver() {
        driverInstance = null;
    }
}
