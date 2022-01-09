package Graph;

import java.util.*;

class Vertex {
    public int Value;
    public boolean hit;
    public Vertex(int val) {
        Value = val;
    }
}

class SimpleGraph {
    Vertex[] vertex;
    int[][] m_adjacency;
    int max_vertex;

    public SimpleGraph(int size) {
        max_vertex = size;
        m_adjacency = new int[size][size];
        vertex = new Vertex[size];
    }

    public void AddVertex(int value) {
        for (int i = 0; i < max_vertex; i++)
            if (vertex[i] == null) {
                vertex[i] = new Vertex(value);
                break;
            }
    }

    public void RemoveVertex(int v) {
        vertex[v] = null;
        for (int i = 0; i < max_vertex; i++) {
            m_adjacency[v][i] = 0;
            m_adjacency[i][v] = 0;
        }
    }

    public boolean IsEdge(int v1, int v2) {
        return m_adjacency[v1][v2] == 1 && m_adjacency[v2][v1] == 1;
    }

    public void AddEdge(int v1, int v2) {
        m_adjacency[v1][v2] = 1;
        m_adjacency[v2][v1] = 1;
    }

    public void RemoveEdge(int v1, int v2) {
        m_adjacency[v1][v2] = 0;
        m_adjacency[v2][v1] = 0;
    }


    public ArrayList<Vertex> WeakVertices() {
        Set<Integer> temp = new HashSet<>();
        clearHits();
        for (int v = 0; v < vertex.length; v++) {
            if (vertex[v].hit) continue;
            ArrayList<Integer> check = new ArrayList<>();
            for (int i = 0; i < vertex.length; i++)
                if (m_adjacency[v][i] == 1)
                    check.add(i);

            if (check.size() > 1)
                for (int i = 0; i < check.size() - 1; i++)
                    for (int j = i + 1; j < check.size(); j++)
                        if (m_adjacency[check.get(i)][check.get(j)] == 1) {
                            vertex[check.get(i)].hit = true;
                            vertex[check.get(j)].hit = true;
                            vertex[v].hit = true;
                            temp.add(check.get(i));
                            temp.add(check.get(j));
                            temp.add(v);
                        }

        }
        ArrayList<Vertex> result = new ArrayList<>();
        for (int i = 0; i < vertex.length; i++)
            if (!temp.contains(i)) result.add(vertex[i]);
        return result;
    }

    public ArrayList<Vertex> DepthFirstSearch(int VFrom, int VTo) {
        Stack<Integer> path = DFSHelper(VFrom, VTo);
        ArrayList<Vertex> result;
        if (path == null || path.empty())
            result = new ArrayList<>();
        else {
            result = new ArrayList<>(path.size());
            Stack<Vertex> temp = new Stack<>();
            while (!path.empty())
                temp.push(vertex[path.pop()]);
            while (!temp.empty())
                result.add(temp.pop());
        }
        return result;
    }

    public ArrayList<Vertex> BreadthFirstSearch(int VFrom, int VTo) {
        ArrayList<Vertex> result = new ArrayList<>();
        Stack<Integer> path = BFSHelper(VFrom, VTo);
        if (path != null)
            while (!path.empty())
                result.add(vertex[path.pop()]);
        return result;
    }

    public Stack<Integer> BFSHelper(int VFrom, int VTo) {
        clearHits();
        Queue<SimpleTreeNode<Integer>> queue = new Queue<>();
        SimpleTreeNode<Integer> tempFrom = new SimpleTreeNode<>(VFrom);
        SimpleTree<Integer> path = new SimpleTree<>(tempFrom);
        while (true) {
            if (!vertex[tempFrom.NodeValue].hit) {
                vertex[tempFrom.NodeValue].hit = true;
                for (int i = 0; i < vertex.length; i++) {
                    SimpleTreeNode<Integer> n;
                    n = new SimpleTreeNode<>(i);
                    if (i == VTo && m_adjacency[tempFrom.NodeValue][i] == 1) {
                        path.AddChild(tempFrom, n);
                        return getReversedPath(n);
                    } else if (m_adjacency[tempFrom.NodeValue][i] == 1 && !vertex[i].hit) {
                        path.AddChild(tempFrom, n);
                        queue.enqueue(n);
                    }
                }
            }
            if (queue.size() != 0)
                tempFrom = queue.dequeue();
            else
                return null;
        }
    }

    private Stack<Integer> getReversedPath(SimpleTreeNode<Integer> n) {
        Stack<Integer> temp = new Stack<>();
        while (n != null) {
            temp.push(n.NodeValue);
            n = n.Parent;
        }
        return temp;
    }

    private Stack<Integer> DFSHelper(int VFrom, int VTo) {
        Stack<Integer> path = new Stack<>();
        clearHits();
        while (true) {
            vertex[VFrom].hit = true;
            if ((!path.empty() && path.peek() != VFrom) || path.empty())
                path.push(VFrom);

            for (int i = 0; i < vertex.length; i++) {
                if (i == VTo && m_adjacency[VFrom][i] == 1) {
                    path.push(i);
                    return path;
                }
            }
            for (int i = 0; i < vertex.length; i++) {
                if (m_adjacency[VFrom][i] == 1 && !vertex[i].hit) {
                    VFrom = i;
                    break;
                }
            }
            if (!vertex[VFrom].hit) continue;
            path.pop();
            if (path.empty())
                return null;
            VFrom = path.peek();
        }
    }

    private void clearHits() {
        for (Vertex x : this.vertex)
            if (x != null)
                x.hit = false;
    }
}

class Queue<T> {

    private LinkedList<T> list;

    public Queue() {
        list = new LinkedList<>();
    }

    public void enqueue(T item) {
        list.addLast(item);
    }

    public T dequeue() {
        return list.size() == 0 ? null : list.removeFirst();
    }

    public int size() {
        return list.size();
    }

}

class SimpleTreeNode<T> {
    public T NodeValue;
    public SimpleTreeNode<T> Parent;
    public List<SimpleTreeNode<T>> Children;

    public SimpleTreeNode(T val) {
        NodeValue = val;
        Parent = null;
        Children = null;
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

        ParentNode.Children.add(NewChild);
        NewChild.Parent = ParentNode;
    }
}