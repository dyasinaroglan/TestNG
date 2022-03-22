package gun_06.texts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestClass3 {

    @Test
    @Parameters("name") //buradaki parametre ismi ile xml deki parametre ismi mutlaka aynı olacak
    public void isimYaz(String str){
        System.out.println(str);
    }
}
