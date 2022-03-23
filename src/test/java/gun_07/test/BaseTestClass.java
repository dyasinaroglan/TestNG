package gun_07.test;

import gun_07.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseTestClass {
    WebDriver driver;

    String url = "http://opencart.abstracta.us/";
    By myAccount = (By.cssSelector("a[title='My Account']"));
    By login = By.partialLinkText("Login");
    By lemail = By.id("input-email");
    By lpassword = By.id("input-password");
    By lsubmit = By.cssSelector("input[type='submit']");

    @BeforeTest
    @Parameters("browser")
    public void beforeTest(String browser){
        driver = Driver.getDriver();
    }
    @Test
    public void gotoUrl(){
        driver.get(url);
        driver.manage().window().maximize();
    }
    @AfterTest
    public void quitDriver(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       Driver.quitDriver(); //gun_07'nin Driver'ı
    }
    @Test(dependsOnMethods = {"gotoUrl"})
    @Parameters({"email","password"})
    public void login(String email, String password){
        driver.findElement(myAccount).click();
        driver.findElement(login).click();
        driver.findElement(lemail).sendKeys(email);
        driver.findElement(lpassword).sendKeys(password);
        driver.findElement(lsubmit).click();

    }
}
