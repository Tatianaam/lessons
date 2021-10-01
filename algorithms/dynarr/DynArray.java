public class DynArray<T>
{
    public T [] array;
    public int count;
    public int capacity;
    Class clazz;

    public DynArray(Class clz)
    {
        clazz = clz;
        // new DynArray<Integer>(Integer.class);
        count = 0;
        makeArray(16);
    }

    public void makeArray(int new_capacity)
    {
        if (new_capacity >= 16)
            capacity = new_capacity;
        T [] temp;
        if (array != null && array.length != 0) {
            temp = array.clone();
            array = (T[]) Array.newInstance(this.clazz, new_capacity);
            for (int i = 0; i < new_capacity && i < temp.length; i++)
                array [i] = temp [i];
        } else
            array = (T[]) Array.newInstance(this.clazz, new_capacity);

    }

    public T getItem(int index)
    {
        if (index >= capacity || index < 0)
            throw new IndexOutOfBoundsException();
        return array[index];
    }

    public void append(T itm)
    {
        if (count + 1 > capacity)
            makeArray(capacity * 2);
        array [count] = itm;
        count++;
    }

    public void insert(T itm, int index)
    {
        if (index < 0 || index > count)
            throw new IndexOutOfBoundsException();

        if (index == count) {
            append(itm);
            return;
        }

        if (count + 1 > capacity)
            makeArray(capacity * 2);

        for (int i = count - 1 ; i >= index; i--)
            array [i + 1] = array [i];
        array [index] = itm;

        count++;

    }

    public void remove(int index)
    {
        if (index < 0 || index >= count)
            throw new IndexOutOfBoundsException();

        removeHelper(index);

        if (((int)(capacity / 1.5) >= 16) && (count - 1 <= (int)(capacity / 1.5)) )
            makeArray((int)(capacity / 1.5));

        count--;
    }

    private void removeHelper(int index) {
        for (int i = index + 1; i < count; i++)
            array [i - 1] = array [i];
    }

}
