package Tree;

import java.util.*;

class aBST {
    public Integer Tree[];

    public aBST(int depth) {
        int tree_size = 0;
        while (depth >= 0)
            tree_size += Math.pow(2, depth--);
        Tree = new Integer[tree_size];
        for (int i = 0; i < tree_size; i++) Tree[i] = null;
    }

    public Integer FindKeyIndex(int key) {
        int i = 0;
        if(Tree[i] == null) return 0;
        while (i < Tree.length) {
            if (Tree[i] == null) return -i;
            if (key == Tree[i]) return i;
            if (key < Tree[i])
                i = 2 * i + 1;
            else
                i = 2 * i + 2;
        }
        return null;
    }

    public int AddKey(int key) {
        Integer insert = FindKeyIndex(key);
        if (insert == null)
            insert = -1;
        else if (insert <= 0) {
            insert = -1 * insert;
            Tree[insert] = key;
        }
        return insert;
    }

}
