package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;

public class Driver {
    //singleton static driver. Driver class'ı bize driver üretecek.
    private static WebDriver driver; //dışardan kimse ulaşamıyor. sadece methotlarla alabilirim.

    public static WebDriver getDriver(){
        return getDriver("chrome");

    }
    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            switch (browser.toLowerCase(Locale.ROOT)) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }
        }
            return driver;
        }
        public static void quitDriver(){
            if (driver != null){
                driver.quit();
                driver = null;
            }
        }
    }



