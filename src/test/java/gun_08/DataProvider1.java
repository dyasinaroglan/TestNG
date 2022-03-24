package gun_08;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {

    @Test(dataProvider = "getData")
    public void test1(String name, String userName, int age){
        System.out.println(name + "," + userName + "," + age);
    }

    @DataProvider
    public Object[][] getData(){
        Object[][] data = {{"ahmet","sönmez",25},{"yasin","aroglan",30}};
        return data;
    }
}
