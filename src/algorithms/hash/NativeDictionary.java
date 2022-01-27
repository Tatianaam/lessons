package algorithms.hash;

import java.lang.reflect.Array;

class NativeDictionary<T>
{
    public int size;
    public String [] slots;
    public T [] values;

    public NativeDictionary(int sz, Class clazz)
    {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key)
    {
        int temp = 0;
        byte[] tempArr = key.getBytes();
        for (byte b : tempArr)
            temp += b;
        temp = temp % 128;
        while (temp >= size)
            temp = temp / 4 + temp % 3;
        return temp;
    }

    public boolean isKey(String key)
    {
        int temp = seekSlot(key);
        return temp != -1 && key.equals(slots[temp]) ? true : false;
    }

    public void put(String key, T value)
    {
        int temp = seekSlot(key);
        if (temp != -1) {
            slots[temp] = key;
            values[temp] = value;
        }
    }

    public T get(String key)
    {
        int temp = seekSlot(key);
        return temp != -1 && key.equals(slots[temp]) ? values[temp] : null;
    }

    private int seekSlot(String value) {
        int hash = hashFun(value);
        if (slots[hash] != null) {
            int temp = 0;
            while (slots[hash] != null && temp <= size) {
                if (slots[hash].equals(value))
                    return hash;
                temp++;
                hash = hash + 3;
                if (hash >= size) {
                    if (hash == size) hash = 0;
                    else hash = hash - size;
                }
            }
        }
        if (slots[hash] == null)
            return hash;
        else return -1;
    }
}