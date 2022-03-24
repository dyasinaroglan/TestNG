package gun_07.testLoginComment;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestLogin extends DriverBaseClass {

    SitePage sitePage;

    @BeforeTest
    public void gotoURL(){
       sitePage = new SitePage(driver);   //1.siteye gittik
        sitePage.gotoUrl();
    }
    @Test(priority = 1)
    @Parameters({"username","password"})
    public void login(String username,String password){
        sitePage.login(username,password);   // 2.my account tıklandı. login butonu tıklandı ve email password girilerek submit yapıldı
    }
    @Test(priority = 2)
  public void contactus(){
        sitePage.contactUs();
  }
  @Test(priority = 3)
  @Parameters("text")
    public void writeMethod(String str){
        sitePage.writeComment(str);
  }
  @Test(priority = 3)
    public void submitClick(){
        sitePage.submitSon();
  }
  @Test(priority = 4)
    public void end(){
        sitePage.logout();
  }
}
