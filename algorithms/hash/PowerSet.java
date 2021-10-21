package PowerSet;

public class PowerSet {

    public int size;
    public String[] slots;

    public PowerSet() {
        slots = new String[20000];
    }

    public void emptySet() {
        slots = new String[0];
        size = 0;
    }

    public int size() {
        return this.size;
    }

    public void put(String value) {
        int hash = hashFun(value);
        if (slots[hash] != null) {
            int temp = 0;
            while (slots[hash] != null && temp <= size) {
                if (slots[hash].equals(value))
                    return;
                temp++;
                hash = hash + 3;
                if (hash >= 20000) {
                    if (hash == 20000) hash = 0;
                    else hash = hash - 20000;
                }
            }
        }
        if (slots[hash] == null) {
            slots[hash] = value;
            size++;
        }
    }

    public boolean get(String value) {
        if (size == 0) return false;
        int temp = seekSlot(value);
        return temp != -1 && value.equals(slots[temp]) ? true : false;
    }

    public boolean remove(String value) {
        if (this.size == 0) return false;
        String tempArr[][] = this.getNonEmpty();
        for (int i = 0; i < tempArr[1].length; i++) {
            if (tempArr[0][i].equals(value)) {
                slots[Integer.valueOf(tempArr[1][i])] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    public PowerSet intersection(PowerSet set2) {
        PowerSet temp = new PowerSet();
        if (this.size == 0 || set2.size == 0) return temp;
        String[] tempArr = set2.getNonEmpty()[0];
        for (int i = 0; i < tempArr.length; i++) {
            if (this.get(tempArr[i]))
                temp.put(tempArr[i]);
        }
        if (temp.size() == 0) temp.emptySet();
        return temp;
    }

    public PowerSet union(PowerSet set2) {
        PowerSet temp = new PowerSet();
        String[] tempArr;
        if (this.size != 0) {
            tempArr = this.getNonEmpty()[0];
            for (String s : tempArr) {
                temp.put(s);
            }
        }
        if (set2.size != 0){
            tempArr = set2.getNonEmpty()[0];
            for (String s : tempArr) {
                temp.put(s);
            }
        }
        if (temp.size == 0) temp.emptySet();
        return temp;
    }

    public PowerSet difference(PowerSet set2) {
        PowerSet temp = new PowerSet();
        if (this.size == 0) return temp;
        String[] tempArr = this.getNonEmpty()[0];
        for (String s : tempArr) {
            if (!set2.get(s))
                temp.put(s);
        }
        if (temp.size == 0) temp.emptySet();
        return temp;
    }

    public boolean isSubset(PowerSet set2) {
        String[] temp = set2.getNonEmpty()[0];
        for (String s : temp) {
            if (!this.get(s))
                return false;
        }
        return true;
    }

    public String[][] getNonEmpty() {
        String[][] temp = new String[2][this.size];
        for (int i = 0, j = 0; i < 20000 && j < temp[1].length; i++) {
            if (slots[i] != null) {
                temp[0][j] = slots[i];
                temp[1][j] = String.valueOf(i);
                j++;
            }
        }
        return temp;
    }

    private int hashFun(String value) {
        int temp = 0;
        byte[] tempArr = value.getBytes();
        for (byte b : tempArr)
            temp += b;
        temp = temp % 128;
        while (temp >= 20000)
            temp = temp / 2 + temp % 7;
        return temp;
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
                if (hash >= 20000) {
                    if (hash == 20000) hash = 0;
                    else hash = hash - 20000;
                }
            }
        }
        if (slots[hash] == null)
            return hash;
        else return -1;
    }
}
