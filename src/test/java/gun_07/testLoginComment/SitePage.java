package gun_07.testLoginComment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SitePage extends TestLogin{
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js = (JavascriptExecutor) driver;

    String url = "https://opencart.abstracta.us/";
    By myAccount = By.cssSelector("a[title='My Account']");
    By login = By.partialLinkText("Login");
    By lemail = By.cssSelector("input[id='input-email']");
    By lpassword = By.cssSelector("input[id='input-password']");
    By lsubmit = By.cssSelector("input[type='submit']");

    By lcontactUs = By.xpath("//a[text()='Contact Us']");
    By enquiryMessage = By.cssSelector("textarea[id='input-enquiry']");
    By lsubmitSon = By.cssSelector("input[type='submit']");
    By llogOut = By.partialLinkText("Logout");


    public SitePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void gotoUrl(){
        driver.get(url);
    }
    public void login(String email,String password){
        driver.findElement(myAccount).click();
        driver.findElement(login).click();
        driver.findElement(lemail).sendKeys(email);
        driver.findElement(lpassword).sendKeys(password);
        driver.findElement(lsubmit).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(llogOut));
        sleep(2000);
    }
    public void contactUs(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(lcontactUs)).click();
    }
    public void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void writeTo(By locator, String text1){
      wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text1);
    }
    public void writeComment(String str){
        writeTo(enquiryMessage,str);
    }
    public void submitSon(){
        scrollIntoView(lsubmitSon);
        wait.until(ExpectedConditions.elementToBeClickable(lsubmitSon)).click();
    }
    public void scrollIntoView(By locator){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
    }
    public void logout(){
        driver.findElement(myAccount).click();
        driver.findElement(llogOut).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(login));
    }
}
