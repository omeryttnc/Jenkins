package utilities;

import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class Driver {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private Driver(){}

    public static WebDriver getDriver(){

        if(driver.get() == null){
            switch (ConfigurationReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver.set( new ChromeDriver());
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver.set(new InternetExplorerDriver());
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver.set( new SafariDriver());
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--no-sandbox");
                    chromeOptions.addArguments("--headless");
                    chromeOptions.addArguments("disable-gpu");
                    chromeOptions.addArguments("window-size=1920,1080");
                    driver.set(new ChromeDriver(chromeOptions));
                    break;
            }
        }
        driver.get().manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        //waitForPageToLoad(200);
        //driver.get().manage().window().maximize();
        return driver.get();

    }
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
    public static void closeDriver(){
        driver.get().close();
    }
    public static void quitDriver(){
        driver.get().quit();
        driver.remove();
    }
}
