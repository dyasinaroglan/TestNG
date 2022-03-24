package gun_08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseStaticDriver;

public class DataProvider2 extends BaseStaticDriver {
    /*
        https://opencart.abstracta.us/index
        adresinin login kisminda
        10 farkli yetkisiz kullanici ve sifre ile giris yapmaya calisin
        siteye girilemedigini asset edin.
     */
    //Öncelikle bir DataProvider oluşturmamız ve Object üreten bir method yazmamız gerekir.


    String url = "https://opencart.abstracta.us/index.php?route=account/login";
    public static By lUsername = By.id("input-email");
    public static By lPassword = By.id("input-password");
    public static By lLoginSubmit = By.cssSelector("input[value='Login']");
    public static By lLogout = By.xpath("//a[text()='Logout']");
    public static By lNotification = By.cssSelector("div.alert.alert-danger");
    By warningWrite = By.cssSelector("div[class='alert alert-danger alert-dismissible']");
    By myAccount = By.cssSelector("a[title='My Account']");

    @Test(dataProvider = "data")
    public void test1(String email,String password, int durum){
        driver.get(url);
        sendKeysTo(lUsername,email,true);
        sendKeysTo(lPassword,password,true);
        clickTo(lLoginSubmit);
        if(durum == 0){
            wait.until(ExpectedConditions.presenceOfElementLocated(warningWrite));
            System.out.println(driver.findElement(warningWrite).getText());
        }else{
            wait.until(ExpectedConditions.presenceOfElementLocated(lLogout)).click();

        }
    }
    @DataProvider(name = "data")
    public Object[][] getData() {
        Object[][] data = {
                {"hleetham0@usnews.com", "Dz7pYk", 0},
                {"mvawton1@ebay.co.uk", "P6uQ10x07pbo", 0},
                {"ijonuzi2@blogger.com", "ueQsdRg", 0},
                {"rhackley3@phpbb.com", "BrQmT8OQy3d8", 0},
                {"testngkurs@gmail.com, testngkurs", 1},
        };
        return data;
    }
}
