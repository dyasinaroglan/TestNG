package gun_12;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseStaticDriver;

import java.util.Locale;

public class FindAll extends BaseStaticDriver {

    FindAllPO po;
    String searchText = "mac";

    @Test
    public void test1(){
       po = new FindAllPO(driver);
       driver.get("http://opencart.abstracta.us/");
       po.getSearchText().sendKeys(searchText);
       po.getSearchButton().click();
       Assert.assertTrue(po.getSiteMap().getText().contains("Search"));
       //açılan ekranda search ekranı var mı yok mu?

    }
    @Test
    public void test2(){
        for (WebElement productName : po.getProducts()) {
            System.out.println(productName.getText());
            Assert.assertTrue(productName.getText().toLowerCase(Locale.ROOT).contains(searchText));

        }
    }
    @Test
    public void test3(){
        System.out.println("-------------------");
        for (WebElement element : po.getIsimVeFiyat()) {
            System.out.println(element.getText());

        }
    }
    @Test
    public void test4(){
        System.out.println(po.getFindBys().getText());
    }
}
