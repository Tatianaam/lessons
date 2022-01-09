package Graph;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

public class SimpleGraphTest {
    @Test
    public void testWeakNodesTwo() {
        SimpleGraph simpleGraph = new SimpleGraph(5);
        simpleGraph.AddVertex(0);
        simpleGraph.AddVertex(1);
        simpleGraph.AddVertex(2);
        simpleGraph.AddVertex(3);
        simpleGraph.AddVertex(4);
        ArrayList<Vertex> result = simpleGraph.WeakVertices();
        Assert.assertEquals(5, result.size());
        simpleGraph.AddEdge(0, 1);
        simpleGraph.AddEdge(0, 2);
        simpleGraph.AddEdge(0, 3);
        simpleGraph.AddEdge(0, 4);
        simpleGraph.AddEdge(1, 2);
        simpleGraph.AddEdge(2, 3);
        simpleGraph.AddEdge(1, 4);
        result = simpleGraph.WeakVertices();
        Assert.assertEquals(0, result.size());
    }

    @Test
    public void testWeakNodes() {
        SimpleGraph simpleGraph = new SimpleGraph(9);
        simpleGraph.AddVertex(0);
        simpleGraph.AddVertex(1);
        simpleGraph.AddVertex(2);
        simpleGraph.AddVertex(3);
        simpleGraph.AddVertex(4);
        simpleGraph.AddVertex(5);
        simpleGraph.AddVertex(6);
        simpleGraph.AddVertex(7);
        simpleGraph.AddVertex(8);
        ArrayList<Vertex> result = simpleGraph.WeakVertices();
        Assert.assertEquals(9, result.size());
        simpleGraph.AddEdge(0, 1);
        simpleGraph.AddEdge(0, 2);
        simpleGraph.AddEdge(0, 3);
        simpleGraph.AddEdge(1, 6);
        simpleGraph.AddEdge(2, 3);
        simpleGraph.AddEdge(2, 5);
        simpleGraph.AddEdge(3, 5);
        simpleGraph.AddEdge(3, 6);
        simpleGraph.AddEdge(4, 6);
        simpleGraph.AddEdge(6, 7);
        simpleGraph.AddEdge(4, 7);
        simpleGraph.AddEdge(7, 8);
        result = simpleGraph.WeakVertices();
        Assert.assertEquals(2, result.size());
        Assert.assertEquals(1, result.get(0).Value);
        Assert.assertEquals(8, result.get(1).Value);
    }

    @Test
    public void testBFSOne() {
        SimpleGraph simpleGraph = new SimpleGraph(10);
        simpleGraph.AddVertex(0);
        simpleGraph.AddVertex(1);
        simpleGraph.AddVertex(2);
        simpleGraph.AddVertex(3);
        simpleGraph.AddVertex(4);
        simpleGraph.AddVertex(5);
        simpleGraph.AddVertex(6);
        simpleGraph.AddVertex(7);
        simpleGraph.AddVertex(8);
        simpleGraph.AddVertex(9);
        ArrayList<Vertex> result = simpleGraph.BreadthFirstSearch(0, 3);
        Assert.assertEquals(true, result.isEmpty());
        simpleGraph.AddEdge(0, 1);
        simpleGraph.AddEdge(0, 2);
        simpleGraph.AddEdge(1, 2);
        simpleGraph.AddEdge(1, 3);
        simpleGraph.AddEdge(1, 4);
        simpleGraph.AddEdge(3, 4);
        simpleGraph.AddEdge(4, 8);
        simpleGraph.AddEdge(2, 5);
        simpleGraph.AddEdge(2, 6);
        simpleGraph.AddEdge(5, 6);
        simpleGraph.AddEdge(6, 7);
        result = simpleGraph.BreadthFirstSearch(0, 3);
        Assert.assertEquals(3, result.size());
        Assert.assertEquals(3, result.get(result.size() - 1).Value);

        result = simpleGraph.BreadthFirstSearch(0, 6);
        Assert.assertEquals(3, result.size());
        Assert.assertEquals(2, result.get(1).Value);

        result = simpleGraph.BreadthFirstSearch(0, 7);
        Assert.assertEquals(4, result.size());
        Assert.assertEquals(2, result.get(1).Value);
        Assert.assertEquals(0, result.get(0).Value);
        Assert.assertEquals(6, result.get(2).Value);
        Assert.assertEquals(7, result.get(3).Value);

        result = simpleGraph.BreadthFirstSearch(1, 7);
        Assert.assertEquals(4, result.size());
        Assert.assertEquals(2, result.get(1).Value);
        Assert.assertEquals(1, result.get(0).Value);
        Assert.assertEquals(6, result.get(2).Value);
        Assert.assertEquals(7, result.get(3).Value);

    }


    @Test
    public void testDFSSingleElemnt() {
        SimpleGraph simpleGraph = new SimpleGraph(2);
        simpleGraph.AddVertex(1);
        simpleGraph.AddEdge(0, 0);
        ArrayList<Vertex> result = simpleGraph.DepthFirstSearch(0, 0);
        Assert.assertEquals(false, result.isEmpty());
    }

    @Test
    public void testDFSTwo() {
        SimpleGraph simpleGraph = new SimpleGraph(4);
        simpleGraph.AddVertex(0);
        simpleGraph.AddVertex(1);
        simpleGraph.AddVertex(2);
        simpleGraph.AddVertex(3);
        ArrayList<Vertex> result = simpleGraph.DepthFirstSearch(0, 3);
        Assert.assertEquals(true, result.isEmpty());
        simpleGraph.AddEdge(0, 1);
        simpleGraph.AddEdge(0, 2);
        simpleGraph.AddEdge(1, 2);
        simpleGraph.AddEdge(1, 3);
        result = simpleGraph.DepthFirstSearch(1, 3);
        Assert.assertEquals(3, result.get(result.size() - 1).Value);
    }

    @Test
    public void testDFSThree() {
        SimpleGraph simpleGraph = new SimpleGraph(6);
        simpleGraph.AddVertex(0);
        simpleGraph.AddVertex(1);
        simpleGraph.AddVertex(2);
        simpleGraph.AddVertex(3);
        simpleGraph.AddVertex(4);
        simpleGraph.AddVertex(5);
        ArrayList<Vertex> result = simpleGraph.DepthFirstSearch(0, 3);
        Assert.assertEquals(true, result.isEmpty());
        simpleGraph.AddEdge(0, 1);
        simpleGraph.AddEdge(0, 2);
        simpleGraph.AddEdge(1, 2);
        simpleGraph.AddEdge(1, 3);
        simpleGraph.AddEdge(2, 4);
        simpleGraph.AddEdge(4, 5);
        simpleGraph.AddEdge(2, 5);
        result = simpleGraph.DepthFirstSearch(1, 5);
        Assert.assertEquals(5, result.get(result.size() - 1).Value);
    }

    @Test
    public void testDFSFive() {
        SimpleGraph simpleGraph = new SimpleGraph(10);
        simpleGraph.AddVertex(0);
        simpleGraph.AddVertex(1);
        simpleGraph.AddVertex(2);
        simpleGraph.AddVertex(3);
        simpleGraph.AddVertex(4);
        simpleGraph.AddVertex(5);
        simpleGraph.AddVertex(6);
        simpleGraph.AddVertex(7);
        simpleGraph.AddVertex(8);
        simpleGraph.AddVertex(9);
        ArrayList<Vertex> result = simpleGraph.DepthFirstSearch(0, 3);
        Assert.assertEquals(true, result.isEmpty());
        simpleGraph.AddEdge(0, 5);
        simpleGraph.AddEdge(0, 7);
        simpleGraph.AddEdge(1, 6);
        simpleGraph.AddEdge(1, 8);
        simpleGraph.AddEdge(2, 3);
        simpleGraph.AddEdge(2, 7);
        simpleGraph.AddEdge(3, 8);
        simpleGraph.AddEdge(4, 9);
        simpleGraph.AddEdge(5, 6);
        simpleGraph.AddEdge(8, 9);
        result = simpleGraph.DepthFirstSearch(2, 9);
        Assert.assertEquals(9, result.get(result.size() - 1).Value);
    }

    @Test
    public void testDFSFour() {
        SimpleGraph simpleGraph = new SimpleGraph(8);
        simpleGraph.AddVertex(0);
        simpleGraph.AddVertex(1);
        simpleGraph.AddVertex(2);
        simpleGraph.AddVertex(3);
        simpleGraph.AddVertex(4);
        simpleGraph.AddVertex(5);
        simpleGraph.AddVertex(6);
        simpleGraph.AddVertex(7);
        ArrayList<Vertex> result = simpleGraph.DepthFirstSearch(0, 3);
        Assert.assertEquals(true, result.isEmpty());
        simpleGraph.AddEdge(0, 1);
        simpleGraph.AddEdge(0, 2);
        simpleGraph.AddEdge(1, 3);
        simpleGraph.AddEdge(2, 3);
        simpleGraph.AddEdge(3, 4);
        simpleGraph.AddEdge(3, 6);
        //  simpleGraph.AddEdge(6, 5);
        //  simpleGraph.AddEdge(4, 5);
        simpleGraph.AddEdge(7, 0);
        result = simpleGraph.DepthFirstSearch(7, 2);
        Assert.assertEquals(2, result.get(result.size() - 1).Value);
    }

    @Test
    public void testDFS() {
        SimpleGraph simpleGraph = new SimpleGraph(13);
        simpleGraph.AddVertex(1);
        simpleGraph.AddVertex(2);
        simpleGraph.AddVertex(3);
        simpleGraph.AddVertex(4);
        simpleGraph.AddVertex(5);
        ArrayList<Vertex> result = simpleGraph.DepthFirstSearch(0, 4);
        Assert.assertEquals(true, result.isEmpty());
        simpleGraph.AddEdge(0, 1);
        simpleGraph.AddEdge(1, 2);
        simpleGraph.AddEdge(0, 2);
        simpleGraph.AddEdge(2, 3);
        simpleGraph.AddEdge(3, 4);
        result = simpleGraph.DepthFirstSearch(0, 4);
        Assert.assertEquals(1, result.get(0).Value);
        Assert.assertEquals(5, result.get(4).Value);
        Assert.assertEquals(4, result.get(3).Value);
        simpleGraph.AddVertex(6);
        simpleGraph.AddVertex(7);
        simpleGraph.AddVertex(8);
        simpleGraph.AddVertex(9);
        simpleGraph.AddVertex(10);
        simpleGraph.AddEdge(4, 5);
        simpleGraph.AddEdge(4, 6);
        simpleGraph.AddEdge(6, 7);
        simpleGraph.AddEdge(7, 8);
        simpleGraph.AddEdge(7, 9);
        simpleGraph.AddVertex(11);
        simpleGraph.AddVertex(12);
        simpleGraph.AddVertex(13);
        simpleGraph.AddEdge(8, 10);
        simpleGraph.AddEdge(10, 11);
        simpleGraph.AddEdge(10, 12);
        result = simpleGraph.DepthFirstSearch(0, 9);
        Assert.assertEquals(1, result.get(0).Value);
        Assert.assertEquals(8, result.get(6).Value);
        Assert.assertEquals(10, result.get(7).Value);
    }

    @Test
    public void testOne() {
        SimpleGraph simpleGraph = new SimpleGraph(1);
        simpleGraph.AddVertex(1);
        ArrayList<Vertex> result = simpleGraph.DepthFirstSearch(0, 0);
        Assert.assertEquals(0, result.size());
    }

    @Ignore
    @Test
    public void addVertex() {
        SimpleGraph simpleGraph = new SimpleGraph(3);
        Assert.assertEquals(null, simpleGraph.vertex[0]);
        simpleGraph.AddVertex(5);
        Assert.assertEquals(5, simpleGraph.vertex[0].Value);
        Assert.assertEquals(null, simpleGraph.vertex[1]);
        simpleGraph.AddVertex(3);
        Assert.assertEquals(3, simpleGraph.vertex[1].Value);
        Assert.assertEquals(null, simpleGraph.vertex[2]);
        simpleGraph.AddVertex(7);
        Assert.assertEquals(7, simpleGraph.vertex[2].Value);

        Assert.assertEquals(false, simpleGraph.IsEdge(0, 1));
        Assert.assertEquals(false, simpleGraph.IsEdge(0, 2));
        Assert.assertEquals(false, simpleGraph.IsEdge(1, 2));

        simpleGraph.AddEdge(0, 1);
        Assert.assertEquals(true, simpleGraph.IsEdge(0, 1));
        Assert.assertEquals(false, simpleGraph.IsEdge(0, 2));
        Assert.assertEquals(false, simpleGraph.IsEdge(1, 2));

        simpleGraph.AddEdge(1, 2);
        Assert.assertEquals(true, simpleGraph.IsEdge(0, 1));
        Assert.assertEquals(false, simpleGraph.IsEdge(0, 2));
        Assert.assertEquals(true, simpleGraph.IsEdge(1, 2));
        Assert.assertEquals(false, simpleGraph.IsEdge(2, 1));
        //    Assert.assertEquals(true, simpleGraph.IsEdge(1, 0));
        //   Assert.assertEquals(false, simpleGraph.IsEdge(2, 0));

        simpleGraph.AddEdge(0, 2);
        //  Assert.assertEquals(true, simpleGraph.IsEdge(2, 1));
        //   Assert.assertEquals(true, simpleGraph.IsEdge(1, 0));
        //    Assert.assertEquals(true, simpleGraph.IsEdge(2, 0));

        simpleGraph.RemoveVertex(0);
        Assert.assertEquals(null, simpleGraph.vertex[0]);
        Assert.assertEquals(false, simpleGraph.IsEdge(0, 1));
        Assert.assertEquals(false, simpleGraph.IsEdge(0, 2));
        Assert.assertEquals(true, simpleGraph.IsEdge(1, 2));
        //  Assert.assertEquals(true, simpleGraph.IsEdge(2, 1));
        Assert.assertEquals(false, simpleGraph.IsEdge(1, 0));
        Assert.assertEquals(false, simpleGraph.IsEdge(2, 0));

        simpleGraph.AddVertex(8);
        Assert.assertEquals(8, simpleGraph.vertex[0].Value);
        Assert.assertEquals(false, simpleGraph.IsEdge(0, 1));
        Assert.assertEquals(false, simpleGraph.IsEdge(0, 2));
        Assert.assertEquals(true, simpleGraph.IsEdge(1, 2));
        //      Assert.assertEquals(true, simpleGraph.IsEdge(2, 1));
        Assert.assertEquals(false, simpleGraph.IsEdge(1, 0));
        Assert.assertEquals(false, simpleGraph.IsEdge(2, 0));

        simpleGraph.RemoveEdge(2, 1);
        Assert.assertEquals(false, simpleGraph.IsEdge(0, 1));
        Assert.assertEquals(false, simpleGraph.IsEdge(0, 2));
        Assert.assertEquals(true, simpleGraph.IsEdge(1, 2));
        Assert.assertEquals(false, simpleGraph.IsEdge(2, 1));
        Assert.assertEquals(false, simpleGraph.IsEdge(1, 0));
        Assert.assertEquals(false, simpleGraph.IsEdge(2, 0));

    }
}
