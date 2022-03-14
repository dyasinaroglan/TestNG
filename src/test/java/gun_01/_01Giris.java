package gun_01;

import org.testng.annotations.Test;

public class _01Giris {

    int num = 10;

    {
        System.out.println("instance intiliazer");
    }

    public _01Giris(){
        System.out.println("constructor");
        System.out.println(num);
    }
    @Test
    void test01(){
        System.out.println("testNG");

    }
    @Test
    void test02(){
        System.out.println("testNG-1");

    }


    /*
    functional testlerin yapılması için bir tool
    Assertion
    Testleri organize eder
    TestNG-Junıt
    Annotations
    @Test
    @BeforeClass
    @AfterTest

     */
}
