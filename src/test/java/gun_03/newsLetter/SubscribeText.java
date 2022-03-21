package gun_03.newsLetter;

import org.testng.annotations.Test;
import pages.HomePage;
import utils.BaseStaticDriver;

public class SubscribeText extends BaseStaticDriver {

    @Test
    public void testLogın(){
       HomePage homePage = new HomePage();
       homePage.goToSite();
       homePage.goToLogin();
       sleep(4000);
    }
}
