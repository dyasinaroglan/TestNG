package gun_11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseStaticDriver;
import static gun_11.RandomUrunLocators.*;

import java.lang.annotation.Target;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Pattern;


public class RandomUrun extends BaseStaticDriver {
    List<WebElement> products;
    List<WebElement> productPrice;
    List<WebElement> productAddToCarts;
    Object[] myUrun;

    @Test
    public void test1(){
        driver.get(url);
        sendKeysTo(lsearch,"ipod" + Keys.ENTER);
        products = driver.findElements(lproductNames);  //oluşturduğumuz products listesinin içine lproductNames leri attık
        for (WebElement product : products) {
            Assert.assertTrue(product.getText().toLowerCase().contains("ipod"));
            //ürünün ismi yani getText() i ipod içeriyor mu diye kontrol ettik.hepsi ipod içeriyor mu bakıyoruz
        }
    }
    @Test(priority = 1)
    public void test2(){
        productPrice = driver.findElements(lproductPrices);
        productAddToCarts = driver.findElements(lproductAddToCarts);

        int rUrun = new Random().nextInt(productPrice.size());
        myUrun = new Object[]{
                products.get(rUrun).getText(), getPriceAsNumber(productPrice.get(rUrun).getText())};
        productAddToCarts.get(rUrun).click();
        //wait.until(ExpectedConditions.elementToBeClickable(lcart)).click();
        wait.until(ExpectedConditions.not(ExpectedConditions.textMatches(lcart, Pattern.compile(".*Loading.*")))); //loading yazısı bitene kadar bekle
        // TODO: 29.03.2022 nokta : karakter demek burada * ise ya hiç karakter olmayacak ya da istediği kadar karakter olacak, ikiside kabul
        // TODO: 29.03.2022 eskisi olmayıncaya kadar bekle. bunun olmamasını istiyorsam başına not eklerim

        driver.findElement(lcart).click();

        WebElement cartPanel = wait.until(ExpectedConditions.visibilityOfElementLocated(lCartPanel));
        Assert.assertTrue(cartPanel.getText().contains(myUrun[0].toString()));
        Assert.assertTrue(cartPanel.getText().contains(products.get(rUrun).getText()));

    }
    @Test(priority = 2)
    public void test3(){

        String urunAdı = driver.findElement(lCartTableUrunIsimleri).getText();
        String urunFıyatı = driver.findElement(lCartTotal).getText();
        //başka yöntem
        //String urunFıyatı1 = driver.findElement(RelativeLocator.with(By.cssSelector("td")).toRightOf(lCartTotalText)).getText();

        Assert.assertEquals(urunAdı, myUrun[0]);
        Assert.assertEquals(getPriceAsNumber(urunFıyatı), myUrun[1]);
        //Assert.assertEquals(getPriceAsNumber(urunFıyatı1), myUrun[1]);
    }

    //hepsinde geçerli olacak Double bir method yazarız.
    public Double getPriceAsNumber(String text){
        String str = text.split("\n")[0].replaceAll("[^0-9.]","");
        return Double.parseDouble(str)/100;
    }
    /*
    $122.00
    Ex Tax: $100.00
     */

}

interface RandomUrunLocators{

    String url = "http://opencart.abstracta.us/";
    By lsearch = By.cssSelector("input[name='search']");
    By lproductNames = By.cssSelector(".caption a");
    By lproductPrices = By.xpath("//div[@class='caption']/p[2]");
    By lproductAddToCarts = By.xpath("//button[contains(@onclick,'cart.add')]");
    By lcart = By.xpath("//div[@id='cart']");
    By lCartPanel = By.cssSelector("ul.dropdown-menu.pull-right");

    By lCartTableUrunIsimleri = By.xpath("//table[@class='table table-striped']//td[2]");
    By lCartTotal = By.xpath("//table[@class='table table-bordered']//tr[4]/td[2]");
    By lCartTotalText = By.xpath("//td[./*[text()='Total']]");




}





