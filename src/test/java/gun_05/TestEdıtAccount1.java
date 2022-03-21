package gun_05;

import org.testng.annotations.Test;
import pages.BaseTest;
import pages.HomePage;

public class TestEdıtAccount1 extends BaseTest {
     /*
    Senaryo 4
      1- Siteyi açınız.
      2- Edit Account a tıklatınız.
      3- Yeni isim ve soyisim göndererek Continue yapınız.
      4- İşlem sonucunu kontrol ediniz.
      5- Bu işlemi 2 kez çalıştırarak eski haline getiriniz.
     */

    HomePage homePage = new HomePage();

    @Test
    public void test_GotoSite(){
        homePage.goToSite();
    }
    @Test(priority = 1, dependsOnMethods = {"test_GotoSite"})
    public void test_Login(){
        homePage.goToLogin();
        homePage.logınAs("testngkurs@gmail.com","testngkurs");
    }
    @Test(priority = 2, dependsOnMethods = {"test_Login"})
    public void test_updateMyAccount(){
        homePage.clickLinkTest("Edit Account");
        homePage.uptadeAccount("A","A","123");
        homePage.veryfyNotification("successfull");
    }
    @Test(dependsOnMethods = {"test_GotoSite", "test_Login"})
    public void test_UpdateMyAccount2(){
        homePage.clickLinkTest("Edit Account");
        homePage.uptadeAccount("testngkurs", "testngkurs", "123456789");
        homePage.veryfyNotification("successfull");
    }
}

/*
        priority siralama verir.
        önceki test basarisiz olsa da pesinen gelen test calistirilir.

        dependsOnMethods  ise bagimlilik ifade eder.
        Bagimli oldugu test basarili olursa o test calisir,
        basarisiz olursa o test skip edilir.

     */
