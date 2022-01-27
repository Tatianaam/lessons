package algorithms.tree;

import org.junit.Assert;
import org.junit.Test;

public class AlgorithmsDataStructures2Test {

    //6 3 8 1 4 7 9
    @Test
    public void test() {
        int[] input = {4, 6, 3, 7, 1, 9, 8};
        int[] result = AlgorithmsDataStructures2.GenerateBBSTArray(input);
        Assert.assertEquals(6, result[0]);
    }

    @Test
    public void test1() {
        int[] input = {6};
        int[] result = AlgorithmsDataStructures2.GenerateBBSTArray(input);
        Assert.assertEquals(6, result[0]);
    }

    @Test
    public void test2() {
        int[] input = {6, 0};
        int[] result = AlgorithmsDataStructures2.GenerateBBSTArray(input);
        Assert.assertEquals(6, result[0]);
        Assert.assertEquals(0, result[1]);
    }

    @Test
    public void test3() {
        int[] input = {6, 0, 9};
        int[] result = AlgorithmsDataStructures2.GenerateBBSTArray(input);
        Assert.assertEquals(6, result[0]);
        Assert.assertEquals(0, result[1]);
        Assert.assertEquals(9, result[2]);
    }


    @Test
    public void test4() {
        int[] input = {9, 11, 2, 6, 17, 16};
        int[] result = AlgorithmsDataStructures2.GenerateBBSTArray(input);

    }

    @Test
    public void test5() {
        int[] input = {9, 18, 11, 6, 2, 19, 35, 25, 30, 17, 16, 20, 21, 22, 23};
        int[] result = AlgorithmsDataStructures2.GenerateBBSTArray(input);
        Assert.assertEquals(19, result[0]);
        Assert.assertEquals(11, result[1]);
        Assert.assertEquals(6, result[3]);
        Assert.assertEquals(23, result[2]);
        Assert.assertEquals(18, result[10]);
        Assert.assertEquals(35, result[14]);
        Assert.assertEquals(25, result[13]);
    }
}
