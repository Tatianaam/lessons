package algorithms.hash;

public class BloomFilter
{
    public int filter_len;
    private int bits;

    public BloomFilter(int f_len)
    {
        filter_len = f_len;
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
        return result;
    }

    public void add(String str1)
    {
        bits = bits | hash1(str1);
        bits = bits | hash2(str1);
    }

    public boolean isValue(String str1)
    {
        return (bits | hash1(str1)) == bits && (bits | hash2(str1)) == bits;
    }
}
