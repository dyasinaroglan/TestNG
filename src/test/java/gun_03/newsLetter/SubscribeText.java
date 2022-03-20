package gun_03.newsLetter;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.BaseStaticDriver;

public class SubscribeText extends BaseStaticDriver {

    @Test
    public void testLogın(){
       HomePage homePage = new HomePage(driver);
       homePage.goToSite();
       homePage.goToLogin();
       sleep(4000);
    }
}
