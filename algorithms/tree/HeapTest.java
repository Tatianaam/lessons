package Tree;

import org.junit.Assert;
import org.junit.Test;

public class HeapTest {

    @Test
    public void test() {
        Heap heap = new Heap();
        Assert.assertEquals(-1, heap.GetMax());
        int[] input = {1, 5, 3, 7, 10, 9, 12};
        heap.MakeHeap(input, 2);
        Assert.assertEquals(12, heap.HeapArray[0]);
        Assert.assertEquals(1, heap.HeapArray[3]);
        Assert.assertEquals(9, heap.HeapArray[6]);
        Assert.assertEquals(12, heap.GetMax());
        Assert.assertEquals(10, heap.HeapArray[0]);
        Assert.assertEquals(9, heap.HeapArray[2]);
        Assert.assertEquals(3, heap.HeapArray[5]);
        Assert.assertEquals(true, heap.Add(14));
        Assert.assertEquals(14, heap.HeapArray[0]);
        Assert.assertEquals(false, heap.Add(15));
        Assert.assertEquals(14, heap.HeapArray[0]);
        Assert.assertEquals(10, heap.HeapArray[2]);
        Assert.assertEquals(14, heap.GetMax());
        Assert.assertEquals(10, heap.GetMax());
        Assert.assertEquals(9, heap.GetMax());
        Assert.assertEquals(7, heap.GetMax());
        Assert.assertEquals(5, heap.GetMax());
        Assert.assertEquals(3, heap.GetMax());
        Assert.assertEquals(-1, heap.HeapArray[1]);
        Assert.assertEquals(-1, heap.HeapArray[2]);
        Assert.assertEquals(-1, heap.HeapArray[5]);
        Assert.assertEquals(1, heap.GetMax());
        Assert.assertEquals(-1, heap.GetMax());


    }
}
