package gun_02;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import utils.Driver;

public class Test01 {

    WebDriver driver;

    @Test
    void t1(){
        driver= Driver.getDriver();
        //Driver class'ının altındaki driver dan çağırıyorum.

    }
    @Test
    void t2(){
        driver.get("https://www.google.com");

        Test02 test02 = new Test02(); // Test02 classından dan nesne oluşturdum.
        test02.t3(); //t3 yahoo ya gidecek ama ikiside aynı driver da açılacak. farklı sayfalarda açılmayacak.
        //çünkü driver tanımlandıysa bir kere tekrardan farklı bir driver tanımlanmayacak, daha önceden tanımlanan driverdan devam edecek.
        //singleton bu demek. bir sefer çalıştırıp aynı driver ı kullanıyoruz.

        Test03 test03 = new Test03(driver);
        test03.t3();

    }
    @AfterTest
    public void afterTest(){
        Driver.quitDriver();
    }
}
