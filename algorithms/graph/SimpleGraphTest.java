package Graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class SimpleGraphTest {

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
        Assert.assertEquals(true, simpleGraph.IsEdge(2, 1));
        Assert.assertEquals(true, simpleGraph.IsEdge(1, 0));
        Assert.assertEquals(false, simpleGraph.IsEdge(2, 0));

        simpleGraph.AddEdge(0, 2);
        Assert.assertEquals(true, simpleGraph.IsEdge(2, 1));
        Assert.assertEquals(true, simpleGraph.IsEdge(1, 0));
        Assert.assertEquals(true, simpleGraph.IsEdge(2, 0));

        simpleGraph.RemoveVertex(0);
        Assert.assertEquals(null, simpleGraph.vertex[0]);
        Assert.assertEquals(false, simpleGraph.IsEdge(0, 1));
        Assert.assertEquals(false, simpleGraph.IsEdge(0, 2));
        Assert.assertEquals(true, simpleGraph.IsEdge(1, 2));
        Assert.assertEquals(true, simpleGraph.IsEdge(2, 1));
        Assert.assertEquals(false, simpleGraph.IsEdge(1, 0));
        Assert.assertEquals(false, simpleGraph.IsEdge(2, 0));

        simpleGraph.AddVertex(8);
        Assert.assertEquals(8, simpleGraph.vertex[0].Value);
        Assert.assertEquals(false, simpleGraph.IsEdge(0, 1));
        Assert.assertEquals(false, simpleGraph.IsEdge(0, 2));
        Assert.assertEquals(true, simpleGraph.IsEdge(1, 2));
        Assert.assertEquals(true, simpleGraph.IsEdge(2, 1));
        Assert.assertEquals(false, simpleGraph.IsEdge(1, 0));
        Assert.assertEquals(false, simpleGraph.IsEdge(2, 0));

        simpleGraph.RemoveEdge(2, 1);
        Assert.assertEquals(false, simpleGraph.IsEdge(0, 1));
        Assert.assertEquals(false, simpleGraph.IsEdge(0, 2));
        Assert.assertEquals(false, simpleGraph.IsEdge(1, 2));
        Assert.assertEquals(false, simpleGraph.IsEdge(2, 1));
        Assert.assertEquals(false, simpleGraph.IsEdge(1, 0));
        Assert.assertEquals(false, simpleGraph.IsEdge(2, 0));

    }
}
