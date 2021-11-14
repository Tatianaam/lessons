package Tree;

import java.util.*;

public class SimpleTreeNode<T> {
    public T NodeValue;
    public SimpleTreeNode<T> Parent;
    public List<SimpleTreeNode<T>> Children;
    public int level;

    public SimpleTreeNode(T val, SimpleTreeNode<T> parent) {
        NodeValue = val;
        Parent = parent;
        Children = null;
        level = 0;
    }
}

class SimpleTree<T> {
    public SimpleTreeNode<T> Root;

    public SimpleTree(SimpleTreeNode<T> root) {
        Root = root;
    }

    public void AddChild(SimpleTreeNode<T> ParentNode, SimpleTreeNode<T> NewChild) {
        if (ParentNode.Children == null)
            ParentNode.Children = new ArrayList<>();

        NewChild.level = ParentNode.level + 1;
        ParentNode.Children.add(NewChild);
        NewChild.Parent = ParentNode;
    }

    public void DeleteNode(SimpleTreeNode<T> NodeToDelete) {
        NodeToDelete.Parent.Children.remove(NodeToDelete);
    }

    public List<SimpleTreeNode<T>> GetAllNodes() {
        List<SimpleTreeNode<T>> nodes = new ArrayList<>();
        goOver(this.Root, nodes);
        return nodes;
    }

    private void goOver(SimpleTreeNode<T> node, List<SimpleTreeNode<T>> nodes) {
        if (node == null)
            return;
        nodes.add(node);
        if (node.Children == null)
            return;
        for (SimpleTreeNode<T> n : node.Children)
            goOver(n, nodes);
    }

    public List<SimpleTreeNode<T>> FindNodesByValue(T val) {
        List<SimpleTreeNode<T>> nodes = new ArrayList<>();
        search(this.Root, nodes, val);
        return nodes;
    }

    private void search(SimpleTreeNode<T> node, List<SimpleTreeNode<T>> nodes, T value) {
        if (node == null)
            return;
        if (node.NodeValue.equals(value))
            nodes.add(node);
        if (node.Children == null)
            return;
        for (SimpleTreeNode<T> n : node.Children)
            search(n, nodes, value);
    }

    public void MoveNode(SimpleTreeNode<T> OriginalNode, SimpleTreeNode<T> NewParent) {
        OriginalNode.Parent.Children.remove(OriginalNode);
        OriginalNode.Parent = NewParent;
        if (NewParent.Children == null) NewParent.Children = new ArrayList<>();
        NewParent.Children.add(OriginalNode);
    }

    public int Count() {
        int result = 0;
        if (this.Root == null)
            return result;
        else return countHelper(this.Root, result);
    }

    private int countHelper(SimpleTreeNode<T> node, int result) {
        if (node == null) return 0;
        result++;
        if (node.Children == null)
            return result;
        for (SimpleTreeNode<T> n : node.Children) {
            result = countHelper(n, result);
        }
        return result;
    }


    public int LeafCount() {
        if (this.Root == null)
            return 0;
        if (this.Root.Children == null)
            return 1;
        int result = 0;
        result = leafCountHelper(this.Root, result);
        return result;
    }

    private int leafCountHelper(SimpleTreeNode<T> node, int result) {
        if (node == null)
            return 0;
        if (node.Children == null)
            return 1;
        int temp = 0;
        for (SimpleTreeNode<T> n : node.Children) {
            temp = temp + leafCountHelper(n, 0);
        }
        return result + temp;
    }

}
