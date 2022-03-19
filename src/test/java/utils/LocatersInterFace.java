package utils;

import org.openqa.selenium.By;

public interface LocatersInterFace {
    //bunlara public static final dememe gerek yok çünkü
    //bunlar doğuştan public static final

     String url_interFace = "http://opencart.abstracta.us/index.php?route=common/home";
     By lsearchInput_interFace = By.cssSelector("input[name='search']");
     By lsearchButton_interFace = By.cssSelector("#search button");
}
