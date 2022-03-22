package gun_06.texts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BaseStaticDriver;
import utils.Driver;

import java.util.Locale;

public class TestClass4 {

    WebDriver driver;

    @BeforeTest
    @Parameters("browserName")
    public void beforeTest(String browser){  //string bir browser göndericem
        switch (browser.toLowerCase(Locale.ROOT)){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
        }
        driver = Driver.getDriver();
    }

    @Test
    public void gotoUrl(){
        driver.get("http://opencart.abstracta.us/");
    }
    @Test(dependsOnMethods = {"gotoUrl"})
    @Parameters("searchText")
    public void search(String text){
        driver.findElement(By.cssSelector("#search input")).sendKeys(text + Keys.ENTER);
    }
    @AfterTest
    @Parameters("browserName")
    public void afterTest(String bName){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
