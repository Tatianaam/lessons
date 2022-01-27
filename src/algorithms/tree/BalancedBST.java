package algorithms.tree;

import java.util.*;

class BSTNode {
    public int NodeKey;
    public BSTNode Parent;
    public BSTNode LeftChild;
    public BSTNode RightChild;
    public int Level;

    public BSTNode(int key, BSTNode parent) {
        NodeKey = key;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
        if (parent != null)
            Level = parent.Level + 1;
    }
}

class BalancedBST {
    public BSTNode Root;

    public BalancedBST() {
        Root = null;
    }

    public void GenerateTree(int[] a) {
        Arrays.sort(a);
        this.Root = treeGeneratorHelper(a, this.Root, 0, a.length);
    }

    private BSTNode treeGeneratorHelper(int[] a, BSTNode node, int start, int end) {
        if (start == end)
            return null;
        BSTNode temp = null;
        if (end - start == 2 && a[start] == a[end - 1]) {
            temp = new BSTNode(a[start], node);
            temp.RightChild = new BSTNode(a[end - 1], temp);
        } else {
            int i = (end - start) / 2 + start;
            temp = new BSTNode(a[i], node);
            temp.LeftChild = treeGeneratorHelper(a, temp, start, i);
            temp.RightChild = treeGeneratorHelper(a, temp, i + 1, end);
        }
        return temp;
    }

    public boolean IsBalanced(BSTNode root_node) {
        if (root_node.RightChild != null) {
            if (root_node.LeftChild != null)
                return IsBalanced(root_node.RightChild) && IsBalanced(root_node.LeftChild);
            else if (root_node.RightChild.LeftChild != null || root_node.RightChild.RightChild != null)
                return false;
            else
                return true;
        } else {
            if (root_node.LeftChild != null)
                if (root_node.LeftChild.LeftChild != null || root_node.LeftChild.RightChild != null)
                    return false;
                else
                    return true;
            else
                return true;
        }
    }

}
