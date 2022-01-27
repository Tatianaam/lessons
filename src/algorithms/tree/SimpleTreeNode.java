package algorithms.tree;

import java.util.*;

public class SimpleTreeNode<T> {
    public T NodeValue;
    public SimpleTreeNode<T> Parent;
    public List<SimpleTreeNode<T>> Children;
    public int level;
    public boolean checked;

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

    public ArrayList<T> EvenTrees() {
        if (this.Root == null || this.Root.Children == null || this.Root.Children.isEmpty()) return new ArrayList<>();
        List<SimpleTreeNode<T>> nodes = GetAllNodes();
        if (nodes.size() % 2 == 1) return new ArrayList<>();
        boolean[][] matrix = getMatrix(new boolean[nodes.size()][nodes.size() + 1], nodes);
        ArrayList<T> result = new ArrayList<>();
        for (int i = nodes.size() - 1; i > 0; i--) {
            if (nodes.get(i).checked) continue;
            int count = 0;
            count = getNumberOfNodes(count, matrix, i, nodes);
            if (count != 0) {
                count++;
                int temp = i;
                while (count % 2 == 1) {
                    if (temp == 0) break;
                    nodes.get(temp).checked = true;
                    temp = nodes.indexOf(nodes.get(temp).Parent);
                    count = getNumberOfNodes(count, matrix, temp, nodes);
                    count++;
                }
                nodes.get(temp).checked = true;
                if (temp == 0) continue;
                result.add(nodes.get(temp).Parent.NodeValue);
                result.add(nodes.get(temp).NodeValue);
            }
        }
        return result;
    }

    private int getNumberOfNodes(int count, boolean[][] matrix, int i, List<SimpleTreeNode<T>> nodes) {
        if (!matrix[i][matrix.length])
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] && !nodes.get(j).checked)
                    count++;
            }
        return count;
    }

    private boolean[][] getMatrix(boolean[][] matrix, List<SimpleTreeNode<T>> nodes) {
        for (int i = 0; i < nodes.size(); i++) {
            SimpleTreeNode<T> temp = nodes.get(i);
            temp.checked = false;
            if (temp.Children != null && !temp.Children.isEmpty())
                for (SimpleTreeNode<T> n : temp.Children) {
                    matrix[i][nodes.indexOf(n)] = true;
                }
            else
                matrix[i][nodes.size()] = true;
        }
        return matrix;
    }

}
