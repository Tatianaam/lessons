package algorithms.tree;

import java.util.*;

public class AlgorithmsDataStructures2 {
    public static int[] GenerateBBSTArray(int[] a) {
        int[] result = new int[a.length];
        Arrays.sort(a);
        result[0] = a[a.length/2];
        helper(a, result, 1, 0, a.length/2);
        helper(a, result, 2, a.length/2 + 1, a.length);
        return result;
    }

    private static void helper(int[] a, int[] result, int i, int start, int end) {
        if (start > end || i >= a.length) return;
        int temp = (end - start) / 2 + start;
        result[i] = a[temp];
        helper(a, result, 2 * i + 1, start, temp);
        helper(a, result, 2 * i + 2, temp+1, end);
    }
}

