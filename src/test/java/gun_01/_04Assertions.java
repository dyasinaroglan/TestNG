package gun_01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _04Assertions {
    @Test
    public void test01() {
        int a = 2;
        int b = 3;
        /*
        if(a != b){
            throw new RuntimeException("Sayılar eşit değildir.");

        }

         */
        Assert.assertEquals(a,b,"hata");
    }
    @Test
    public void test02() {
        int a = 2;
        int b = 3;

        Assert.assertTrue(a==b, "hata");
    }
    @Test
    public void test03() {
        int a = 2;
        int b = 2;

        Assert.assertEquals(a,b, "sayılar eşit değil");
    }
    @Test
    void toplamTest(){
        int actual = topla(1,2,3,4,5,6);
        int expected = 21;
        Assert.assertEquals(actual,expected,"toplam sonucu hatalıdır.");
    }
    public int topla(int...sayılar){
        int toplam =0;
        for (int sayı : sayılar) {
            toplam+= sayı;
        }
        return toplam;
    }
    @Test
    public void test04(){
        String str = null;
        Assert.assertNull(str);
    }
}
