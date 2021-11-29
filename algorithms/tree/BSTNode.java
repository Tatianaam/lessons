package Tree;

import java.io.*;
import java.util.*;

class BSTNode<T> {
    public int NodeKey;
    public T NodeValue;
    public BSTNode<T> Parent;
    public BSTNode<T> LeftChild;
    public BSTNode<T> RightChild;

    public BSTNode(int key, T val, BSTNode<T> parent) {
        NodeKey = key;
        NodeValue = val;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

class BSTFind<T> {

    public BSTNode<T> Node;

    public boolean NodeHasKey;

    public boolean ToLeft;

    public BSTFind() {
        Node = null;
    }
}

class BST<T> {
    BSTNode<T> Root;

    public BST(BSTNode<T> node) {
        Root = node;
    }

    public BSTFind<T> FindNodeByKey(int key) {
        BSTFind<T> result = new BSTFind<>();
        if (this.Root == null) return result;
        BSTNode<T> temp = findHelper(this.Root, key);
        result.Node = temp;
        if (temp.NodeKey == key) {
            result.NodeHasKey = true;
            result.ToLeft = false;
        } else {
            result.NodeHasKey = false;
            result.ToLeft = key < temp.NodeKey;
        }
        return result;
    }

    private BSTNode<T> findHelper(BSTNode<T> node, int key) {
        if (node.NodeKey == key) return node;

        if (key < node.NodeKey)
            return node.LeftChild != null ? findHelper(node.LeftChild, key) : node;
        else
            return node.RightChild != null ? findHelper(node.RightChild, key) : node;
    }

    public boolean AddKeyValue(int key, T val) {
        BSTFind<T> temp = this.FindNodeByKey(key);
        if (temp.Node == null) {
            this.Root = new BSTNode<>(key, val, null);
            return true;
        }
        if (temp.NodeHasKey) return false;
        if (temp.ToLeft)
            temp.Node.LeftChild = new BSTNode<>(key, val, temp.Node);
        else
            temp.Node.RightChild = new BSTNode<>(key, val, temp.Node);
        return true;
    }

    public BSTNode<T> FinMinMax(BSTNode<T> FromNode, boolean FindMax) {

        BSTNode<T> temp = FromNode;

        if (FindMax) {
            while (temp.RightChild != null) {
                temp = temp.RightChild;
            }
        } else {
            while (temp.LeftChild != null) {
                temp = temp.LeftChild;
            }
        }
        return temp;
    }

    public boolean DeleteNodeByKey(int key) {
        BSTFind<T> temp = this.FindNodeByKey(key);
        if (temp.Node == null || !temp.NodeHasKey) return false;
        BSTNode<T> min = null;
        if (temp.Node.RightChild != null) {
            min = this.FinMinMax(temp.Node.RightChild, false);
            if (!min.equals(temp.Node.RightChild)) {
                if (min.RightChild != null) {
                    min.Parent.LeftChild = min.RightChild;
                    min.RightChild.Parent = min.Parent;
                } else {
                    min.Parent.LeftChild = null;
                }
                min.RightChild = temp.Node.RightChild;
                temp.Node.RightChild.Parent = min;
            }
        }
        if (temp.Node.LeftChild != null) {
            if (min != null) {
                min.LeftChild = temp.Node.LeftChild;
                temp.Node.LeftChild.Parent = min;
            } else {
                min = temp.Node.LeftChild;
            }
        }
        if (temp.Node.Parent != null) {
            if (temp.Node.Parent.RightChild != null && temp.Node.Parent.RightChild.equals(temp.Node))
                temp.Node.Parent.RightChild = min;
            else
                temp.Node.Parent.LeftChild = min;
            if (min != null)
                min.Parent = temp.Node.Parent;
        } else {
            this.Root = min;
            if (min != null)
                min.Parent = null;
        }
        return true;
    }

    public int Count() {
        return countHelper(this.Root);
    }

    private int countHelper(BSTNode<T> node) {
        if (node == null) return 0;
        return 1 + countHelper(node.LeftChild) + countHelper(node.RightChild);
    }

    public ArrayList<BSTNode> WideAllNodes() {
        ArrayList<BSTNode> result = new ArrayList<>();
        if (this.Root != null) {
            result.add(this.Root);
            for (int i = 0; i < result.size(); i++) {
                if (result.get(i).LeftChild != null) result.add(result.get(i).LeftChild);
                if (result.get(i).RightChild != null) result.add(result.get(i).RightChild);
            }
        }
        return result;
    }

    public ArrayList<BSTNode> DeepAllNodes(int order) {
        ArrayList<BSTNode> result = new ArrayList<>();
        if (this.Root == null) return result;

        switch (order) {
            case 0:
                inOrder(result, this.Root);
                break;
            case 1:
                postOrder(result, this.Root);
                break;
            case 2:
                preOrder(result, this.Root);
        }
        return result;
    }

    private void inOrder(ArrayList<BSTNode> result, BSTNode node) {

        if (node.LeftChild != null)
            inOrder(result, node.LeftChild);

        result.add(node);

        if (node.RightChild != null)
            inOrder(result, node.RightChild);
    }

    private void postOrder(ArrayList<BSTNode> result, BSTNode node) {
        if (node.LeftChild != null)
            postOrder(result, node.LeftChild);

        if (node.RightChild != null)
            postOrder(result, node.RightChild);

        result.add(node);
    }

    private void preOrder(ArrayList<BSTNode> result, BSTNode node) {

        result.add(node);

        if (node.LeftChild != null)
            preOrder(result, node.LeftChild);

        if (node.RightChild != null)
            preOrder(result, node.RightChild);
    }


}