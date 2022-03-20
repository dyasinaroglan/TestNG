package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    public void hover(WebElement element, long mılıs){
        new Actions(driver).moveToElement(element).pause(mılıs).build().perform();
        //webElement gönderdim movetoElement elemente gidecek
    }
    public void hover(WebElement element){
        hover(element,50); //şeklinde de yazabilirim
    }
    public void sleep(long milis){
       try {
           Thread.sleep(milis);
       }catch (InterruptedException e){
           e.printStackTrace();
       }
    }
}


      /*
        //null return eder.
        driver.findElements(By.cssSelector("ul#asd")).get(0); //0. indexli elementi verir.
        //hata return eder.
        driver.findElement(By.cssSelector("ul#asd"));  //buda ilk bulduğu elementi verir. yani ikisi de bu şekilde aynı elemeti verir.

         */
         // TODO: 20.03.2022 ancak aradaki en önemli fark  ikinci olan element bulamazsa hata return eder.
         //todo diğeri ise null return eder.