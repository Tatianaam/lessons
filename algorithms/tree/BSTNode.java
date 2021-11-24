package Tree;

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
        if (temp.ToLeft) {
            temp.Node.LeftChild = new BSTNode<>(key, val, temp.Node);
        } else {
            temp.Node.RightChild = new BSTNode<>(key, val, temp.Node);
        }
        return true;
    }

    public BSTNode<T> FinMinMax(BSTNode<T> FromNode, boolean FindMax) {

        BSTNode<T> temp = FromNode;
        if (temp == null) return null;

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
        if (temp.Node.RightChild != null) {
            BSTNode<T> min = this.FinMinMax(temp.Node.RightChild, false);
            if (temp.Node.Parent == null) this.Root = min;
            if (!min.equals(temp.Node.RightChild)) {
                if (min.RightChild != null) {
                    min.Parent.LeftChild = min.RightChild;
                    min.RightChild.Parent = min.Parent;
                } else {
                    min.Parent.LeftChild = null;
                }
                min.RightChild = temp.Node.RightChild;
            }
            if (temp.Node.Parent != null) {
                if (temp.Node.Parent.RightChild != null && temp.Node.Parent.RightChild.equals(temp.Node))
                    temp.Node.Parent.RightChild = min;
                else
                    temp.Node.Parent.LeftChild = min;
            }
            min.LeftChild = temp.Node.LeftChild;
        } else {
            if (temp.Node.LeftChild == null && temp.Node.Parent != null) {
                if (temp.Node.Parent.RightChild != null && temp.Node.Parent.RightChild.equals(temp.Node))
                    temp.Node.Parent.RightChild = null;
                else
                    temp.Node.Parent.LeftChild = null;

            } else {
                if (temp.Node.Parent != null) {
                    if (temp.Node.Parent.RightChild != null && temp.Node.Parent.RightChild.equals(temp.Node))
                        temp.Node.Parent.RightChild = temp.Node.LeftChild;
                    else
                        temp.Node.Parent.LeftChild = temp.Node.LeftChild;
                }
                temp.Node.LeftChild.Parent = temp.Node.Parent;
            }
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


}