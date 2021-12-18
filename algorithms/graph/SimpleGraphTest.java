package Graph;

import org.junit.Assert;
import org.junit.Test;

public class SimpleGraphTest {

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

        simpleGraph.AddEdge(0,1);
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

        simpleGraph.RemoveEdge(2,1);
        Assert.assertEquals(false, simpleGraph.IsEdge(0, 1));
        Assert.assertEquals(false, simpleGraph.IsEdge(0, 2));
        Assert.assertEquals(false, simpleGraph.IsEdge(1, 2));
        Assert.assertEquals(false, simpleGraph.IsEdge(2, 1));
        Assert.assertEquals(false, simpleGraph.IsEdge(1, 0));
        Assert.assertEquals(false, simpleGraph.IsEdge(2, 0));

    }
}
