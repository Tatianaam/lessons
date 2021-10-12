public class HashTable {
    public int size;
    public int step;
    public String[] slots;

    public HashTable(int sz, int stp) {
        size = sz;
        step = stp;
        slots = new String[size];
        for (int i = 0; i < size; i++) slots[i] = null;
    }

    public int hashFun(String value) {
        int temp = 0;
        byte[] tempArr = value.getBytes();
        for (byte b : tempArr)
            temp += b;
        temp = temp % 128;
        while (temp >= size)
            temp = temp / 4 + temp % 3;
        return temp;
    }

    public int seekSlot(String value) {
        int hash = hashFun(value);
        if (slots[hash] == null) {
            slots[hash] = value;
            return hash;
        } else {
            int temp = 0;
            while (slots[hash] != null && temp <= size) {
                if (slots[hash].equals(value))
                    return hash;
                temp++;
                hash = hash + step;
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



    public int put(String value) {
        int temp = seekSlot(value);
        if (temp != -1)
            slots[temp] = value;
        return temp;
    }

    public int find(String value) {
        return seekSlot(value);
    }
}