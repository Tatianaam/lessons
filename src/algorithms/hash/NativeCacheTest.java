package algorithms.hash;

import org.junit.Assert;
import org.junit.Test;

public class NativeCacheTest {

    @Test
    public void testPutAndGet() {
        NativeCache nativeCache = new NativeCache(7, String.class);
        Assert.assertEquals(null, nativeCache.get("1"));
        nativeCache.put("1", "Q");
        Assert.assertEquals("Q", nativeCache.get("1"));
        nativeCache.put("2", "W");
        Assert.assertEquals("W", nativeCache.get("2"));
    }

    @Test
    public void testHits() {
        NativeCache nativeCache = new NativeCache(7, String.class);
        nativeCache.put("1", "Q");
        Assert.assertEquals(0, nativeCache.hits[2]);
        nativeCache.put("2", "W");
        Assert.assertEquals(0, nativeCache.hits[3]);
        nativeCache.get("1");
        nativeCache.get("1");
        nativeCache.get("2");
        Assert.assertEquals(2, nativeCache.hits[2]);
        Assert.assertEquals(1, nativeCache.hits[3]);
    }

    @Test
    public void testReplacement() {
        NativeCache nativeCache = getFilled();
        for (int i = 0; i < 5; i++)
            if (i != 0) nativeCache.get(String.valueOf(i));

        // 3 2 1 0 4
        for (int i = 0; i < 5; i++)
            if (i != 3) {
                Assert.assertEquals(3, nativeCache.hits[1]);
            } else {
                Assert.assertEquals(2, nativeCache.hits[3]);
            }

        nativeCache.put("7", "7");

        Assert.assertEquals(null, nativeCache.get("0"));
        Assert.assertEquals("7", nativeCache.get("7"));
        Assert.assertEquals(1, nativeCache.hits[3]);

    }

    private NativeCache getFilled() {
        NativeCache nativeCache = new NativeCache(5, String.class);
        for (int i = 0; i < 5; i++) {
            String temp = String.valueOf(i);
            nativeCache.put(temp, temp);
            nativeCache.get(temp);
            nativeCache.get(temp);
        }
        for (int i = 0; i < 5; i++)
            Assert.assertEquals(2, nativeCache.hits[i]);
        return nativeCache;
    }

}
