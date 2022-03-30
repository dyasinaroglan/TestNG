package gun_12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FindAllPO {

    public FindAllPO(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "input[name='search']")
    private WebElement searchText;

    @FindBy(css = "button[class='btn btn-default btn-lg']")
    private WebElement searchButton;

    @FindBy(css = ".caption h4")
    private List<WebElement> products;

    @FindBy(css = "ul.breadcrumb")
    private WebElement siteMap;

    public List<WebElement> getProducts() {
        return products;
    }

    public WebElement getSiteMap() {
        return siteMap;
    }

    public WebElement getSearchText() {
        return searchText;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }
    @FindAll({
            @FindBy(css = ".caption h4"),
            @FindBy(css = "p[class='price']")
    })
    private List<WebElement>isimVeFiyat;

    public List<WebElement> getIsimVeFiyat() {
        return isimVeFiyat;
    }
    @FindBys({
            @FindBy(css = ".caption h4"),  //PARENT--bunun altındaki bunu bul demek
            //'.caption h4 ün altında 'p[class='price'] ı bul
            @FindBy(css = "p[class='price']") //CHILD
    })
   WebElement findBys;

    public WebElement getFindBys() {
        return findBys;
    }
}
