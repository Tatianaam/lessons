package Tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SimpleTreeNodeTest {

    @Test
    public void testInsert(){

        SimpleTree<Integer> tree = new SimpleTree<>(null);
        Assert.assertEquals(0, tree.Count());
        Assert.assertEquals(0, tree.LeafCount());
        Assert.assertEquals(0, tree.FindNodesByValue(1).size());
        Assert.assertEquals(0, tree.GetAllNodes().size());

        SimpleTreeNode<Integer> node = new SimpleTreeNode<>(1, null);
        tree = new SimpleTree<>(node);
        Assert.assertEquals(1, tree.Count());
        Assert.assertEquals(1, tree.LeafCount());
        Assert.assertEquals(1, tree.FindNodesByValue(1).size());
        Assert.assertEquals(1, tree.GetAllNodes().size());
        Assert.assertEquals(0, node.level);

        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<>(1, node);
        tree.AddChild(node, node1);
        Assert.assertEquals(2, tree.Count());
        Assert.assertEquals(1, tree.LeafCount());
        Assert.assertEquals(2, tree.FindNodesByValue(1).size());
        Assert.assertEquals(2, tree.GetAllNodes().size());
        Assert.assertEquals(0, node.level);
        Assert.assertEquals(1, node1.level);

        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<>(1, node);
        tree.AddChild(node, node2);
        Assert.assertEquals(3, tree.Count());
        Assert.assertEquals(2, tree.LeafCount());
        Assert.assertEquals(3, tree.FindNodesByValue(1).size());
        Assert.assertEquals(3, tree.GetAllNodes().size());

        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<>(2, node);
        tree.AddChild(node1, node3);
        Assert.assertEquals(4, tree.Count());
        Assert.assertEquals(2, tree.LeafCount());
        Assert.assertEquals(3, tree.FindNodesByValue(1).size());
        Assert.assertEquals(4, tree.GetAllNodes().size());
        Assert.assertEquals(2, node3.level);

        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<>(3, node);
        tree.AddChild(node1, node4);
        Assert.assertEquals(5, tree.Count());
        Assert.assertEquals(3, tree.LeafCount());
        Assert.assertEquals(3, tree.FindNodesByValue(1).size());
        Assert.assertEquals(5, tree.GetAllNodes().size());
        List<SimpleTreeNode<Integer>> t = tree.GetAllNodes();

        tree.MoveNode(node4, node);
        Assert.assertEquals(3, node.Children.size());


        Assert.assertEquals(1, tree.FindNodesByValue(2).size());

        tree.DeleteNode(node1);
        Assert.assertEquals(3, tree.Count());
        Assert.assertEquals(2, tree.LeafCount());
        Assert.assertEquals(2, tree.FindNodesByValue(1).size());
        Assert.assertEquals(0, tree.FindNodesByValue(2).size());
        Assert.assertEquals(3, tree.GetAllNodes().size());
    }
}
