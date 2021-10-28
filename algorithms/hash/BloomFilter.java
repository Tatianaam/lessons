package PowerSet;

public class BloomFilter
{
    public int filter_len;
    private int [] bits;

    public BloomFilter(int f_len)
    {
        filter_len = f_len;
        bits = new int[filter_len];
    }

    public int hash1(String str1)
    {
        // 17
        int result = 0;
        for(int i=0; i<str1.length(); i++)
        {
            int code = (int)str1.charAt(i);
            result = result * 17 + code;
        }

        if (result < 0) result*=-1;
        while (result >= filter_len)
            result = result % filter_len;

        return result;
    }
    public int hash2(String str1)
    {
        // 223
        int result = 0;
        for(int i=0; i<str1.length(); i++)
        {
            int code = (int)str1.charAt(i);
            result = result * 223 + code;
        }
        if (result < 0) result*=-1;
        while (result >= filter_len)
            result = result % filter_len;

        return result;
    }

    public void add(String str1)
    {
        bits[hash1(str1)] = 1;
        bits[hash2(str1)] = 1;
    }

    public boolean isValue(String str1)
    {
        return bits[hash1(str1)] == 1 && bits[hash2(str1)] == 1;
    }
}
