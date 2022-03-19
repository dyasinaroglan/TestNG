package gun_02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseStaticDriver;

import java.util.LinkedList;
import java.util.List;

import static utils.LocatorsClass.*;
import static utils.LocatersInterFace.*;

public class Test04_OpenCart extends BaseStaticDriver {
    WebDriver driver;

    String url = "http://opencart.abstracta.us/index.php?route=common/home";
    By lsearchInput = By.cssSelector("input[name='search']");
    By lsearchButton = By.cssSelector("#search button");
    List<String> menu = new LinkedList<>(){{
        add("Destop");
        add("Laptops & Notebooks");
    }};


    @Test
    public void menuList(){
        openSite(urlStaticClass);
        sendKeysTo(lsearchInput_interFace,"mac");
        clickTo(lsearchButtonStaticCLass);
        List<WebElement> menuler = driver.findElements(By.cssSelector(""));

        for (int i = 0; i < menuler.size(); i++) {
            Assert.assertEquals(menuler.get(i).getText(),menu.get(i));

        }

    }
}
