package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BaseStaticDriver;

public class HomePage extends BaseStaticDriver {

    String url = "http://opencart.abstracta.us/index.php?route=common/home";
    By myAccount = By.cssSelector("a[title='My Account']");
    By login = By.linkText("Login");
    By lNotification = By.cssSelector("div.alert.alert-success");
    By lloginEmail = By.id("input-email");
    By lloginPassword = By.id("input-password");
    By lloginSubmitButton = By.xpath("//input[@value='Login'");
    By llogout = By.xpath("//div[@id='top-links']//a[text()='Logout']");
    By lEditAccountFirstName = By.id("input-firstname");
    By lEditAccountLastName = By.id("input-lastname");
    By lEditAccountTelephone = By.id("input-telephone");
    By lEditAccountContinueButton = By.id("//input[@value='continue']");


    public void goToSite(){
        driver.get(url);
    }
    public void goToLogin(){
        clickTo(myAccount);
        clickTo(login);
    }
    public void logınAs(String userName,String password){
        sendKeysTo(lloginEmail,userName);
        sendKeysTo(lloginPassword,password);
        clickTo(lloginSubmitButton);
        wait.until(ExpectedConditions.presenceOfElementLocated(llogout));

    }
    public void veryfyNotification(String str){
        verifyNotification(lNotification,str);
    }
    public void clickLinkTest(String str){
         clickTo(By.partialLinkText(str));
    }
    public void uptadeAccount(String name, String lastName, String telephone){
        sendKeysTo(lEditAccountFirstName, name, true);
        sendKeysTo(lEditAccountLastName,lastName,true);
        sendKeysTo(lEditAccountTelephone,telephone,true);
        clickTo(lEditAccountContinueButton);

    }
}
