package com.sample.test.demo;

import static org.testng.Assert.fail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

    private Configuration config;
    public static WebDriver driver;
    protected String url;

    @BeforeClass(alwaysRun = true)
    public void init() throws Throwable {
        config = new Configuration();
        url = config.getUrl();
        initializelDriver();
        navigateToSite();
    }

    private void navigateToSite() {
        driver.get(url);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        try {
            driver.quit();

        } catch (Exception e) {
        }
    }

    private void initializelDriver() {
        if (config.getBrowser().equalsIgnoreCase("chrome")) {
//            if (config.getPlatform().equalsIgnoreCase("mac")) {
//                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/mac/chromedriver");
//            } else {
//                System.setProperty("webdriver.chrome.driver",
//                        "src/test/resources/chromedriver/windows/chromedriver.exe");
//            }
        	WebDriverManager.chromedriver().setup();
        	ChromeOptions options = new ChromeOptions();
        	options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
        }
        else {
            fail("Unsupported bfrowser " + config.getBrowser());
        }
       
    }


}
