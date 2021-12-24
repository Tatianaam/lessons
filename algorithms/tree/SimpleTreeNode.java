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

    public ArrayList<T> EvenTrees() {
        if (this.Root == null || this.Root.Children == null || this.Root.Children.isEmpty()) return new ArrayList<T>();
        int size = this.Count();
        if (size % 2 == 1) return new ArrayList<T>();
        ArrayList<SimpleTreeNode<T>> nodes = getNodes(this.Root, new ArrayList<>(size));
        boolean[][] matrix = getMatrix(new boolean[size][size + 1], nodes);
        ArrayList<Integer> checked = new ArrayList<>();
        ArrayList<T> first = new ArrayList<>();
        ArrayList<T> second = new ArrayList<>();
        for (int i = size - 1; i > 0; i--) {
            int count = 0;
            count = getNumberOfNodes(count, matrix, i, checked);
            if (count != 0) {
                count++;
                while (count % 2 == 1) {
                    count = getNumberOfNodes(count, matrix, nodes.indexOf(nodes.get(i).Parent), checked);
                }
                first.add(nodes.get(i).Parent.NodeValue);
                second.add(nodes.get(i).NodeValue);
            }
        }
        ArrayList<T> result = new ArrayList<>();
        for (int i = 0; i < first.size(); i++) {
            result.add(first.get(i));
            result.add(second.get(i));
        }
        return result;
    }

    private int getNumberOfNodes(int count, boolean[][] matrix, int i, ArrayList<Integer> checked) {
        if (!matrix[i][matrix.length])
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] && !checked.contains(i))
                    count++;
            }
        checked.add(i);
        return count;
    }


    private ArrayList<SimpleTreeNode<T>> getNodes(SimpleTreeNode<T> node, ArrayList<SimpleTreeNode<T>> nodes) {
        if (node == null) return nodes;
        nodes.add(node);
        if (node.Children == null || node.Children.isEmpty()) return nodes;
        for (SimpleTreeNode<T> n : node.Children)
            getNodes(n, nodes);
        return nodes;
    }

    private boolean[][] getMatrix(boolean[][] matrix, ArrayList<SimpleTreeNode<T>> nodes) {
        for (int i = 0; i < nodes.size(); i++) {
            SimpleTreeNode<T> temp = nodes.get(i);
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
