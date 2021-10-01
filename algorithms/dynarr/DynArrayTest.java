package com.company;

import org.junit.Assert;
import org.junit.Test;

public class DynArrayTest {


    @Test
    public void testInsertAtZeroSameBuffer(){
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        array.makeArray(16);
        array.append(2);
        array.insert(1, 0);
        Assert.assertEquals(2, array.count);
        Assert.assertEquals(16, array.capacity);
        Assert.assertEquals((Integer) 1, array.getItem(0));
    }

    @Test
    public void testInsertAtEndSameBuffer(){
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        array.makeArray(16);
        array.append(2);
        array.append(3);
        array.insert(1, 2);
        Assert.assertEquals(3, array.count);
        Assert.assertEquals(16, array.capacity);
        Assert.assertEquals((Integer) 1, array.getItem(2));
    }

    @Test
    public void testInsertAtMiddleSameBuffer(){
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        array.makeArray(16);
        array.append(2);
        array.append(3);
        array.insert(1, 1);
        Assert.assertEquals(3, array.count);
        Assert.assertEquals(16, array.capacity);
        Assert.assertEquals((Integer) 3, array.getItem(2));
    }


    @Test
    public void testInsertAtZeroDoubleBuffer(){
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        array.makeArray(16);
        array.append(2); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2);
        array.append(2); array.append(2); array.append(2); array.append(2);array.append(2); array.append(2); array.append(2); array.append(2);
        array.insert(1, 0);
        Assert.assertEquals(17, array.count);
        Assert.assertEquals(32, array.capacity);
        Assert.assertEquals((Integer) 1, array.getItem(0));
    }

    @Test
    public void testInsertAtMiddleDoubleBuffer(){
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        array.makeArray(16);
        array.append(2); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2);
        array.append(2); array.append(2); array.append(2); array.append(2);array.append(2); array.append(2); array.append(2); array.append(2);
        array.insert(1, 2);
        Assert.assertEquals(17, array.count);
        Assert.assertEquals(32, array.capacity);
        Assert.assertEquals((Integer) 1, array.getItem(2));
    }

    @Test
    public void testInsertAtEndDoubleBuffer(){
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        array.makeArray(16);
        array.append(2); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2);
        array.append(2); array.append(2); array.append(2); array.append(2);array.append(2); array.append(2); array.append(2); array.append(2);
        array.insert(1, 16);
        Assert.assertEquals(17, array.count);
        Assert.assertEquals(32, array.capacity);
        Assert.assertEquals((Integer) 1, array.getItem(16));
    }

    @Test
    public void testInsertBeforeLastDoubleBuffer(){
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        array.makeArray(16);
        array.append(2); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2);
        array.append(2); array.append(2); array.append(2); array.append(2);array.append(2); array.append(2); array.append(2); array.append(2);
        array.insert(1, 15);
        Assert.assertEquals(17, array.count);
        Assert.assertEquals(32, array.capacity);
        Assert.assertEquals((Integer) 2, array.getItem(16));
        Assert.assertEquals((Integer) 1, array.getItem(15));
    }

    @Test
    public void testInsertNegativeIndex(){
        boolean thrown = false;
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        array.makeArray(16);
        array.append(2);
        try {
            array.insert(1, -1);
        } catch (IndexOutOfBoundsException e) {
            thrown = true;
        }
        Assert.assertEquals(1, array.count);
        Assert.assertEquals(16, array.capacity);
        Assert.assertEquals(true, thrown);
    }

    @Test
    public void testInsertIndexOOB(){
        boolean thrown = false;
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        array.makeArray(16);
        array.append(2);
        try {
            array.insert(1, 10);
        } catch (IndexOutOfBoundsException e) {
            thrown = true;
        }
        Assert.assertEquals(1, array.count);
        Assert.assertEquals(16, array.capacity);
        Assert.assertEquals(true, thrown);
    }

    @Test
    public void testRemoveSameBufferEnd(){
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        array.makeArray(16);
        array.append(3);
        array.append(2);
        array.append(1);
        array.remove(2);
        Assert.assertEquals(2, array.count);
        Assert.assertEquals(16, array.capacity);
        Assert.assertEquals((Integer) 2, array.getItem(1));
        Assert.assertEquals((Integer) 3, array.getItem(0));
        boolean thrown = false;
        try {
            Assert.assertEquals((Integer) 1, array.getItem(2));
        } catch (Exception e) {
            thrown = true;
        }
        //  array.getItem(2);
        Assert.assertEquals(true, thrown);

    }

    @Test
    public void testRemoveSameBufferZero(){
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        array.makeArray(16);
        array.append(2);
        array.append(3);
        array.append(1);
        array.remove(0);
        Assert.assertEquals(2, array.count);
        Assert.assertEquals(16, array.capacity);
        Assert.assertEquals((Integer) 1, array.getItem(1));
        Assert.assertEquals((Integer) 3, array.getItem(0));
        boolean thrown = false;
        try {
            Assert.assertEquals((Integer) 1, array.getItem(2));
        } catch (Exception e) {
            thrown = true;
        }
        Assert.assertEquals(true, thrown);
    }

    @Test
    public void testRemoveSameBufferMiddle(){
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        array.makeArray(16);
        array.append(2);
        array.append(3);
        array.append(1);
        array.append(4);
        array.remove(3);
        array.remove(2);
        Assert.assertEquals(2, array.count);
        Assert.assertEquals(16, array.capacity);
        Assert.assertEquals((Integer) 3, array.getItem(1));
        Assert.assertEquals((Integer) 2, array.getItem(0));
        boolean thrown = false;
        try {
            Assert.assertEquals((Integer) 1, array.getItem(2));
        } catch (Exception e) {
            thrown = true;
        }
        Assert.assertEquals(true, thrown);
        thrown = false;
        try {
            Assert.assertEquals((Integer) 1, array.getItem(3));
        } catch (Exception e) {
            thrown = true;
        }
        Assert.assertEquals(true, thrown);
    }

    @Test
    public void testRemoveSameLargeBufferMiddle(){
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        array.makeArray(16);
        array.append(3); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2);
        array.append(2); array.append(2); array.append(2); array.append(2);array.append(2); array.append(2); array.append(2); array.append(2);
        array.append(2); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2);
        array.append(2); array.append(2); array.append(2); array.append(2);array.append(2); array.append(2); array.append(2);
        array.remove(0);
        Assert.assertEquals(30, array.count);
        Assert.assertEquals(32, array.capacity);
        Assert.assertEquals((Integer) 2, array.getItem(1));
        Assert.assertEquals((Integer) 2, array.getItem(0));
        boolean thrown = false;
        try {
            Assert.assertEquals((Integer) 1, array.getItem(31));
        } catch (Exception e) {
            thrown = true;
        }
        Assert.assertEquals(true, thrown);
    }

    @Test
    public void testRemoveSmallerBufferEnd(){
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        array.makeArray(30);
        Assert.assertEquals(30, array.capacity);
        array.append(3); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2);
        array.append(3); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2);
        array.append(3); array.append(2); array.append(2); array.append(3); array.append(2);
        array.remove(20);
        Assert.assertEquals(20, array.count);
        Assert.assertEquals(20, array.capacity);
        Assert.assertEquals((Integer) 3, array.getItem(19));
        Assert.assertEquals((Integer) 3, array.getItem(0));
        boolean thrown = false;
        try {
            Assert.assertEquals((Integer) 1, array.getItem(20));
        } catch (Exception e) {
            thrown = true;
        }
        Assert.assertEquals(true, thrown);
    }

    @Test
    public void testRemoveSmallerBufferZero(){
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        array.makeArray(30);
        array.append(3); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2);
        array.append(3); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2);
        array.append(3); array.append(2); array.append(3); array.append(2);
        array.remove(0);
        Assert.assertEquals(19, array.count);
        Assert.assertEquals(20, array.capacity);
        Assert.assertEquals((Integer) 2, array.getItem(18));
        Assert.assertEquals((Integer) 3, array.getItem(17));
        Assert.assertEquals((Integer) 2, array.getItem(0));
        boolean thrown = false;
        try {
            Assert.assertEquals((Integer) 2, array.getItem(20));
        } catch (Exception e) {
            thrown = true;
        }
        Assert.assertEquals(true, thrown);
    }

    @Test
    public void testRemoveSmallerBufferMiddle(){
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        array.makeArray(30);
        array.append(3); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2);
        array.append(3); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2);
        array.append(3); array.append(2); array.append(2); array.append(3); array.append(2);
        array.remove(2);
        Assert.assertEquals(20, array.count);
        Assert.assertEquals(20, array.capacity);
        Assert.assertEquals((Integer) 2, array.getItem(19));
        Assert.assertEquals((Integer) 3, array.getItem(18));
        Assert.assertEquals((Integer) 3, array.getItem(0));
        Assert.assertEquals((Integer) 3, array.getItem(7));
        boolean thrown = false;
        try {
            Assert.assertEquals((Integer) 2, array.getItem(20));
        } catch (Exception e) {
            thrown = true;
        }
        Assert.assertEquals(true, thrown);
    }

    @Test
    public void testRemoveNegative(){
        boolean thrown = false;
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        array.makeArray(16);
        array.append(2);
        array.append(2);
        try {
            array.remove(-1);
        } catch (IndexOutOfBoundsException e) {
            thrown = true;
        }
        Assert.assertEquals(2, array.count);
        Assert.assertEquals(16, array.capacity);
        Assert.assertEquals(true, thrown);
    }

    @Test
    public void testRemoveIndexOOO(){
        boolean thrown = false;
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        array.makeArray(16);
        array.append(2);
        array.append(2);
        try {
            array.remove(4);
        } catch (IndexOutOfBoundsException e) {
            thrown = true;
        }
        Assert.assertEquals(2, array.count);
        Assert.assertEquals(16, array.capacity);
        Assert.assertEquals(true, thrown);
    }

    @Test
    public void testRemoveIndexOOOLarge(){
        boolean thrown = false;
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        array.makeArray(16);
        array.append(2);
        array.append(2);
        try {
            array.remove(40);
        } catch (IndexOutOfBoundsException e) {
            thrown = true;
        }
        Assert.assertEquals(2, array.count);
        Assert.assertEquals(16, array.capacity);
        Assert.assertEquals(true, thrown);
    }

    @Test
    public void extraCapacityChangeTest(){
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        array.makeArray(30);
        Assert.assertEquals(30, array.capacity);
        array.append(1); array.append(1);  array.remove(0);
        Assert.assertEquals(1, array.count);
        Assert.assertEquals(20, array.capacity);
        array.append(3); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2);
        array.append(3); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2); array.append(2);
        array.append(3); array.append(2); array.append(2); array.append(3);
        Assert.assertEquals(40, array.capacity);
        array.remove(0);
        Assert.assertEquals(26, array.capacity);
    }


}
