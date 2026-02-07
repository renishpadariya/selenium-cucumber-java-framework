package com.qa.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver init_driver(String browser) {

        System.out.println("Browser name is: " + browser);

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            // Headless execution for CI
            if (isCI()) {
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
            }

            tlDriver.set(new ChromeDriver(options));
        }

        else if (browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();

            FirefoxOptions options = new FirefoxOptions();

            // Headless execution for CI
            if (isCI()) {
                options.addArguments("--headless");
            }

            tlDriver.set(new FirefoxDriver(options));
        }

        else if (browser.equalsIgnoreCase("safari")) {
            tlDriver.set(new SafariDriver());
        }

        else {
            throw new RuntimeException("Please pass a valid browser value");
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        getDriver().manage().window().maximize();

        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }

    // Detect CI environment
    private boolean isCI() {
        return System.getenv("CI") != null;
    }
}
