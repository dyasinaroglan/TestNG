package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import java.time.Duration;

public class BaseStaticDriver {

    protected WebDriver driver;
    /*
    public ya da protected yapmazsam farklı package larda olduğu için sıkıntı çıkar, görmez.
    private yaparsam eğer yani kimse ulaşamasın diyorsam bu sefer methodla çağırırım
    aşağıda openSite() methodu
    */

    protected WebDriverWait wait;

    public BaseStaticDriver() {
        this.driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @AfterSuite
    public void afterSuite(){
        Driver.quitDriver();
    }
    public void openSite(String url){
        driver.get(url);
    }
    public void clickTo(By locator){ //By sınıfından bir locator göndereyim ki sadece ona tıklasın
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        //burada wait aynı zamanda element ürettiği için direkt click() yapıp alttakini silebiliriz
        //driver.findElement(By.cssSelector("#search button")).click();
    }
    public void sendKeysTo(By locator,String str){
       wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(str);

    }
}
