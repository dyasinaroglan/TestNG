package gun_01;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class _06Ornek {
    /*
      https://opensource-demo.orangehrmlive.com/index.php/auth/login
        @BeforeClass"da
            driver tanimlayin
        @Test
            siteye gidin, title"i assert edin

        @Test
            login olun, login oldugunuzu assert edin

        @AfterClass
            driveri kapatin
     */
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    void siteGit(){
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        Assert.assertTrue(driver.getTitle().contains("OrangeHRM"));
    }
    @Test(dependsOnMethods = "siteGit")
    public void alogın(){
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();

        String welcomeText = driver.findElement(By.id("welcome")).getText();
        Assert.assertTrue(welcomeText.contains("welcome"));

        String welcomeText = driver.findElement(By.linkText("Welcome kanth")).getText();
        Assert.assertTrue(welcomeText.contains("welcome kanth"));

    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
