package gun_03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseStaticDriver;

import java.util.List;

public class _01OpenCartMenuHover extends BaseStaticDriver {
    //5.soru
    @Test
    public void testHoverMenu(){
        String url = "http://opencart.abstracta.us/index.php?route=common/home";
        By mainMenu = By.cssSelector("ul.nav.navbar-nav>li");
        driver.get(url);
        List<WebElement> elementsOfMenuItems = driver.findElements(mainMenu);

        for (WebElement menuItem : elementsOfMenuItems) {
            hover(menuItem,300);
            if(menuItem.findElements(By.cssSelector("div.dropdown-inner")).size()>0) {//size 0 dan büyükse yani altta bir tane bile menu açılıyorsa bunları göster
                System.out.println("alt menu var." + menuItem.findElements(By.cssSelector("div.dropdown-inner li")).size());
                Assert.assertTrue(menuItem.findElement(By.cssSelector(".dropdown-inner")).isDisplayed());
            }else {
                System.out.println("alt menu yoktur.");
            }
            //menuItem'ın içinden css'i .dropdown-inner olanları görüntüle diyorum
            //elementin altından bul demek--->menuItem.findElement()    elementin altından element bul.

        }

    }

}
