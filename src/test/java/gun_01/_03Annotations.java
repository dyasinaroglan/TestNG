package gun_01;

import org.testng.annotations.*;

public class _03Annotations {

    @Test  //methodun bir test methodunu olduğunu belirtir.
    void test01(){
        System.out.println("test1");
    }
    @Test
    void test02(){
        System.out.println("test2");
    }
    @BeforeTest
    void beforeTest(){
        System.out.println("BeforeTest");
    }
    @AfterTest   //Test, TestNG xml'de belirtilen tanımlamadı.
    void afterTest(){
        System.out.println("AfterTest");
    }
    @BeforeMethod
    void beforeMethod(){
        System.out.println("beforeMethod");
    }
    @AfterMethod
    void afterMethod(){
        System.out.println("afterMethod");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass");
    }
    @AfterClass
    protected void afterClass(){
        System.out.println("afterClass");
    }
    @BeforeSuite
    public void beforeSuit(){
        System.out.println("beforeSuite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite");
    }
    @BeforeGroups
    void beforeGroups(){
        System.out.println("beforeGroups");
    }
    @AfterGroups
    void afterGroups(){
        System.out.println("afterGroups");
    }
}
