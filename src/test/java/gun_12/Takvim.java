package gun_12;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utils.BaseStaticDriver;

public class Takvim extends BaseStaticDriver {

    String url = "https://opencart.abstracta.us/index";
    By searchClick = By.cssSelector("input[name='search']");
    By searchButton = By.cssSelector("button[class='btn btn-default btn-lg']");
    By cinemaButton = By.cssSelector("img[class='img-responsive']");
    By dateButton = By.xpath("(//button[@class='btn btn-default'])[5]");

    By nextButton = By.xpath("(//th[@class='next'])[4]");
    By dateSelect = By.xpath("(//th[@class='picker-switch'])[4]");

    String year = "March 2022";

    @Test
    public void test1(){
        driver.get(url);
        clickTo(searchClick);
        sendKeysTo(searchClick,"cinema");
        clickTo(searchButton);
        clickTo(cinemaButton);
        clickTo(dateButton);

        while (true){
            if(driver.findElement(dateSelect).getText().equalsIgnoreCase(year))
                break;
                clickTo(nextButton);
            }
        }
    }


