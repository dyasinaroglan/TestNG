package gun_06.texts;

import org.testng.annotations.Test;

public class TestClass1 {

    @Test(groups = {"A"})
    public void test1(){
        System.out.println("test1");
    }
    @Test(groups = {"A","B"})
    public void test2(){
        System.out.println("test2");
    }
    @Test(groups = {"B"})
    public void test3(){
        System.out.println("test3");
    }
}
