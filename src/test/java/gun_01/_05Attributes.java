package gun_01;

import org.testng.annotations.Test;

import java.lang.annotation.Repeatable;

public class _05Attributes {
    /*
    priority test önceliğini verir.  -5000, +5000
    küçük değerli olan önceliklidir.
    priority yazılmazsa default her testin prioritys' O dır.
    priority
     */

    @Test(testName = "5 NOLU TEST",priority =2)    //CTRL+SPACE    //test'e isim verdik
    public void test05(){
        String str = "1";

    }
    //enable attribute'u methodun çalıştırılıp çalıştırılmayacağını gösterir.
    @Test(testName = "3 nolu test",priority = 0, enabled = false)
    public void test03(){
        System.out.println("test3");
    }
    @Test(testName = "5 nolu test",priority = 1)
    public void test01(){
        System.out.println("test5");
    }
    //testin ne kadar süreceğini sınırlar
    @Test(testName = "4 nolu test",timeOut = 2000)
    public void test4(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test4");
    }
    //invocationCount, bu methodun kaç defa tekrarlanacağını belirtir.
    @Test(testName = "6 nolu test",priority = 1, invocationCount = 4)
    public void test6(){
        System.out.println("test6");
    }

}
