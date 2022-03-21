package gun_05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import utils.BaseStaticDriver;

public class StaleElement extends BaseStaticDriver {

    String url = "http://opencart.abstracta.us";
    By menuDesktops = By.xpath("//ul//*[text()='Desktops']");
    By lNotification = By.cssSelector("div.alert.alert-success");


    @Test
    public void gotoSite(){
        driver.get(url);
    }
    @Test(priority = 1,enabled = false)
    public void clickToDesktops(){
        clickTo(menuDesktops);
    }
    @Test(priority = 1)
    public void clickToDesktops1(){
        WebElement dt = driver.findElement(menuDesktops);
        driver.navigate().refresh();
        clickTo(dt);
        verifyNotification(lNotification,"successfull");

        /*
        bir selector refresh öncesi ya da ajax'ın ilgili elementi güncellemesi ya da değiştirmesi öncesi
        element halinde alınmışsa, refresh sonrası ya da ajax işlemi sonrası o element ile yapılcak işlemler StaleElement hatası verir.
        bu nedenle selectörlerin ne zaman element'e çevrilecekleri önemlidir.
         */
    }

}
