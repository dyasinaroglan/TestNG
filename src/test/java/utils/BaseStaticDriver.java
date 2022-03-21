package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import java.time.Duration;

public class BaseStaticDriver {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BaseStaticDriver() {
        this.driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterSuite
    public void afterSuite(){
        sleep(2000);
        Driver.quitDriver();
    }
    public void openSite(String url){  //aldığı url yi get eden method
        driver.get(url);
    }
    public void clickTo(By locator){ //By sınıfından bir locator göndereyim ki sadece ona tıklasın
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        //burada wait aynı zamanda element ürettiği için direkt click() yapıp alttakini silebiliriz
        //driver.findElement(By.cssSelector("#search button")).click();
    }
    public void clickTo(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }
    public void sendKeysTo(By locator,String str){
       wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(str);
    }
    public void sendKeysTo(By locator,String str, boolean clear){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        if(clear)
            element.clear();
        element.sendKeys(str);
    }
    public void waitFor(By locator, WaitConditions waitCondition){
        switch (waitCondition){
            case exist:
                wait.until(ExpectedConditions.presenceOfElementLocated(locator));
                break;
            case clickable:
                wait.until(ExpectedConditions.elementToBeClickable(locator));
                break;
            case visible:
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                break;
        }
    }
    public void hover(WebElement element, long mılıs){
        new Actions(driver).moveToElement(element).pause(mılıs).build().perform();
        //webElement gönderdim movetoElement elemente gidecek
    }
    public void hover(WebElement element){
        hover(element,10); //şeklinde de yazabilirim
    }
    public void sleep(long milis){
       try {
           Thread.sleep(milis);
       }catch (InterruptedException e){
           e.printStackTrace();
       }
    }
    public void verifyNotification(By locator, String str){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Assert.assertTrue(notification.getText().toLowerCase().contains(str.toLowerCase()));
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