package gun_06.texts;

import org.testng.annotations.Test;

public class TestClass2 {

    @Test(groups = {"A"},dependsOnMethods = {"test6"})
    public void test4(){
        System.out.println("test4");
    }
    @Test(groups = {"B"})
    public void test5(){
        System.out.println("test5");
    }
    @Test(groups = {"A","B","C"})
    public void test6(){
        System.out.println("test6");
    }
}
