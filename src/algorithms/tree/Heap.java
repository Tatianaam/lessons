package algorithms.tree;

import java.util.*;

class Heap {
    public int[] HeapArray;
    private int depth;

    public Heap() {
        HeapArray = null;
        depth = -1;
    }

    public void MakeHeap(int[] a, int depth) {
        int size = 0;
        this.depth = depth;
        while (depth >= 0)
            size += Math.pow(2, depth--);
        this.HeapArray = new int[size];
        Arrays.fill(this.HeapArray, -1);
        for (int i = 0; i < a.length; i++)
            this.Add(a[i]);
    }

    public int GetMax() {
        if (this.HeapArray == null || this.HeapArray[0] == -1) return -1;
        else {
            int result = this.HeapArray[0];
            int temp = -1;
            for (int i = this.HeapArray.length - 1; i >= 0; i--)
                if (this.HeapArray[i] != -1) {
                    temp = i;
                    break;
                }
            this.HeapArray[0] = this.HeapArray[temp];
            HeapArray[temp] = -1;
            for (int i = 0; depth !=0 && i <= this.HeapArray.length - Math.pow(2, depth);) {
                int max = this.HeapArray[2 * i + 1] > this.HeapArray[2 * i + 2] ?
                        2 * i + 1 : 2 * i + 2;
                if (HeapArray[i] < HeapArray[max]) {
                    temp = HeapArray[i];
                    HeapArray[i] = HeapArray[max];
                    HeapArray[max] = temp;
                    i = max;
                } else
                    break;
            }
            return result;
        }
    }

    public boolean Add(int key) {
        if (HeapArray[HeapArray.length - 1] != -1)
            return false;
        else {
            int child = -1;
            for (int i = 0; i < HeapArray.length; i++)
                if (this.HeapArray[i] == -1) {
                    child = i;
                    break;
                }
            HeapArray[child] = key;
            while (child > 0 && child < HeapArray.length) {
                int parent = child % 2 == 0 ?
                        (child - 2) / 2 : (child - 1) / 2;
                if (HeapArray[parent] < HeapArray[child]) {
                    int temp = HeapArray[parent];
                    HeapArray[parent] = HeapArray[child];
                    HeapArray[child] = temp;
                    child = parent;
                } else break;
            }
            return true;
        }
    }

}