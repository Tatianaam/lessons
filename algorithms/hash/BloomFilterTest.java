package PowerSet;

import org.junit.Assert;
import org.junit.Test;

public class BloomFilterTest {

    @Test
    public void testBloomFilter(){
        BloomFilter bloomFilter = new BloomFilter(32);
        Assert.assertEquals(false, bloomFilter.isValue("0123456789"));
        bloomFilter.add("0123456789");
        Assert.assertEquals(true, bloomFilter.isValue("0123456789"));
        Assert.assertEquals(false, bloomFilter.isValue("012345678"));
        Assert.assertEquals(false, bloomFilter.isValue("123456789"));

        Assert.assertEquals(false, bloomFilter.isValue("1234567890"));
        bloomFilter.add("1234567890");
        Assert.assertEquals(true, bloomFilter.isValue("1234567890"));

      //  Assert.assertEquals(false, bloomFilter.isValue("2345678901"));
        bloomFilter.add("2345678901");
        Assert.assertEquals(true, bloomFilter.isValue("2345678901"));

        Assert.assertEquals(false, bloomFilter.isValue("3456789012"));
        bloomFilter.add("3456789012");
        Assert.assertEquals(true, bloomFilter.isValue("3456789012"));

        Assert.assertEquals(false, bloomFilter.isValue("4567890123"));
        bloomFilter.add("4567890123");
        Assert.assertEquals(true, bloomFilter.isValue("4567890123"));

      //  Assert.assertEquals(false, bloomFilter.isValue("5678901234"));
        bloomFilter.add("5678901234");
        Assert.assertEquals(true, bloomFilter.isValue("5678901234"));

       // Assert.assertEquals(false, bloomFilter.isValue("6789012345"));
        bloomFilter.add("6789012345");
        Assert.assertEquals(true, bloomFilter.isValue("6789012345"));

     //   Assert.assertEquals(false, bloomFilter.isValue("7890123456"));
        bloomFilter.add("7890123456");
        Assert.assertEquals(true, bloomFilter.isValue("7890123456"));

     //   Assert.assertEquals(false, bloomFilter.isValue("8901234567"));
        bloomFilter.add("8901234567");
        Assert.assertEquals(true, bloomFilter.isValue("8901234567"));

     //   Assert.assertEquals(false, bloomFilter.isValue("9012345678"));
        bloomFilter.add("9012345678");
        Assert.assertEquals(true, bloomFilter.isValue("9012345678"));
    }
}
