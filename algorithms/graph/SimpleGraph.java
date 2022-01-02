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

    private Stack<Integer> DFSHelper(int VFrom, int VTo) {
        Stack<Integer> path = new Stack<>();
        clearHits();
        while (VFrom != -1) {
            vertex[VFrom].hit = true;
            if ((!path.empty() && path.peek() != VFrom) || path.empty())
                path.push(VFrom);

            for (int i = 0; i < vertex.length; i++) {
                if (m_adjacency[VFrom][i] == 1) {
                    if (i == VTo) {
                        path.push(i);
                        return path;
                    }
                    if (!vertex[i].hit) {
                        VFrom = i;
                        break;
                    }
                }
            }
            if (!vertex[VFrom].hit)
                continue;
            path.pop();
            if (path.empty())
                return null;
            VFrom = path.peek();
        }
        return path;
    }

    private void clearHits() {
        for (Vertex x : this.vertex)
            if (x != null)
                x.hit = false;
    }
}