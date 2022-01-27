package algorithms.hash;

import java.lang.reflect.Array;

public class NativeCache<T> {

    public int size;
    public String[] slots;
    public T[] values;
    public int[] hits;
    private int count;

    public NativeCache(int sz, Class clazz) {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
        hits = new int[sz];
        count = 0;
    }


    public void put(String key, T value) {
        int temp;
        if (count + 1 > size) {
            temp = hits[0];
            for (int i = 0; i < size; i++)
                if (hits[i] < temp) temp = i;
            hits[temp] = 0;
        } else {
            temp = findSlot(key);
            count++;
        }
        slots[temp] = key;
        values[temp] = value;
        hits[temp] = 0;
    }

    //returns null if value for the key isn't in cache
    public T get(String key) {
        T result = null;
        int i = findSlot(key);
        if (i != -1 && key.equals(slots[i])) {
            hits[i]++;
            return values[i];
        } else {
            return null;
        }
    }

    private int findSlot(String key) {
        int hash = hash(key);
        if (slots[hash] != null) {
            int itr = 0;
            while (slots[hash] != null && itr <= size) {
                itr++;
                if (key.equals(slots[hash]))
                    return hash;
                hash += 3;
                if (hash >= size)
                    if (hash == size) hash = 0;
                    else hash = hash - size;
            }
        }
        return slots[hash] == null ? hash : -1;
    }


    private int hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash += key.charAt(i) * (i + 1);
        }
        hash %= 256;
        while (hash >= size)
            hash = hash / 3 + hash % 7;
        return hash;
    }

}
