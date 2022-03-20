package gun_03.newsLetter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    String url = "http://opencart.abstracta.us/index.php?route=common/home";
    By myAccount = By.cssSelector("a[title='My Account']");
    By login = By.linkText("Login");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void goToSite(){
        driver.get(url);
    }
    public void goToLogin(){
        driver.findElement(myAccount).click();
        driver.findElement(login).click();
    }
}
