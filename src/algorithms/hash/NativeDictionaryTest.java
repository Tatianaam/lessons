package algorithms.hash;

import org.junit.Assert;
import org.junit.Test;

public class NativeDictionaryTest {

    @Test
    public void testDictionary() {
        NativeDictionary<String> dictionary = new NativeDictionary<String>(17, String.class);
        Assert.assertEquals(false, dictionary.isKey("123"));
        Assert.assertEquals(null, dictionary.get("123"));
        dictionary.put("123", "123");
        Assert.assertEquals(true, dictionary.isKey("123"));
        Assert.assertEquals("123", dictionary.get("123"));
        dictionary.put("123","qwe");
        Assert.assertEquals(true, dictionary.isKey("123"));
        Assert.assertEquals("qwe", dictionary.get("123"));
        Assert.assertEquals(false, dictionary.isKey("124"));
        Assert.assertEquals(null, dictionary.get("1123"));
        dictionary.put("1234","qwer");
        dictionary.put("123","qwer");
        Assert.assertEquals(true, dictionary.isKey("123"));
        Assert.assertEquals("qwer", dictionary.get("123"));
        Assert.assertEquals(true, dictionary.isKey("1234"));
        Assert.assertEquals("qwer", dictionary.get("1234"));
    }
}
