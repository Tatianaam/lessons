package algorithms.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class SimpleTreeNodeTest {

    @Test
    public void testEven() {
        SimpleTree<Integer> tree = new SimpleTree<>(null);
        Assert.assertEquals(0, tree.Count());
        ArrayList<Integer> result = tree.EvenTrees();
        Assert.assertEquals(0, result.size());
        SimpleTreeNode<Integer> node = new SimpleTreeNode<>(1, null);
        tree = new SimpleTree<>(node);
        Assert.assertEquals(1, tree.Count());
        result = tree.EvenTrees();
        Assert.assertEquals(0, result.size());
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<>(2, node);
        tree.AddChild(node, node1);
        Assert.assertEquals(2, tree.Count());
        result = tree.EvenTrees();
        Assert.assertEquals(0, result.size());
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<>(3, node);
        tree.AddChild(node1, node2);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<>(4, node);
        tree.AddChild(node, node3);
        Assert.assertEquals(4, tree.Count());
        result = tree.EvenTrees();
        Assert.assertEquals(2, result.size());
        Assert.assertEquals(1, result.get(0).intValue());
        Assert.assertEquals(2, result.get(1).intValue());
        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<>(5, node);
        tree.AddChild(node3, node4);
        Assert.assertEquals(5, tree.Count());
        result = tree.EvenTrees();
        Assert.assertEquals(0, result.size());
        SimpleTreeNode<Integer> node5 = new SimpleTreeNode<>(6, node);
        tree.AddChild(node, node5);
        Assert.assertEquals(6, tree.Count());
        result = tree.EvenTrees();
        Assert.assertEquals(4, result.size());
        Assert.assertEquals(1, result.get(0).intValue());
        Assert.assertEquals(4, result.get(1).intValue());
        Assert.assertEquals(1, result.get(2).intValue());
        Assert.assertEquals(2, result.get(3).intValue());
    }

    @Test
    public void testNotEven(){
        SimpleTree<Integer> tree = new SimpleTree<>(null);
        ArrayList<Integer> result = tree.EvenTrees();
        SimpleTreeNode<Integer> node = new SimpleTreeNode<>(1, null);
        tree = new SimpleTree<>(node);
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<>(2, node);
        tree.AddChild(node, node1);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<>(3, node);
        tree.AddChild(node, node2);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<>(4, node);
        tree.AddChild(node, node3);
        result = tree.EvenTrees();
        Assert.assertEquals(0, result.size());
    }

    @Test
    public void testEvenSecond(){
        SimpleTree<Integer> tree = new SimpleTree<>(null);
        ArrayList<Integer> result = tree.EvenTrees();
        SimpleTreeNode<Integer> node = new SimpleTreeNode<>(1, null);
        tree = new SimpleTree<>(node);
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<>(2, node);
        tree.AddChild(node, node1);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<>(3, node);
        tree.AddChild(node, node2);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<>(4, node);
        tree.AddChild(node, node3);
        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<>(5, node);
        tree.AddChild(node3, node4);
        SimpleTreeNode<Integer> node5 = new SimpleTreeNode<>(6, node);
        tree.AddChild(node, node5);
        Assert.assertEquals(6, tree.Count());
        result = tree.EvenTrees();
        Assert.assertEquals(2, result.size());
        Assert.assertEquals(1, result.get(0).intValue());
        Assert.assertEquals(4, result.get(1).intValue());
    }

    @Test
    public void testEVenThird(){
        SimpleTree<Integer> tree = new SimpleTree<>(null);
        ArrayList<Integer> result = tree.EvenTrees();
        SimpleTreeNode<Integer> node = new SimpleTreeNode<>(1, null);
        tree = new SimpleTree<>(node);
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<>(2, node);
        tree.AddChild(node, node1);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<>(3, node);
        tree.AddChild(node, node2);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<>(4, node);
        tree.AddChild(node, node3);
        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<>(5, node);
        tree.AddChild(node2, node4);
        SimpleTreeNode<Integer> node5 = new SimpleTreeNode<>(6, node);
        tree.AddChild(node3, node5);
        SimpleTreeNode<Integer> node6 = new SimpleTreeNode<>(7, node);
        tree.AddChild(node4, node6);
        SimpleTreeNode<Integer> node7 = new SimpleTreeNode<>(8, node);
        tree.AddChild(node4, node7);
        SimpleTreeNode<Integer> node8 = new SimpleTreeNode<>(9, node);
        tree.AddChild(node5, node8);
        SimpleTreeNode<Integer> node9 = new SimpleTreeNode<>(10, node);
        tree.AddChild(node5, node9);
        SimpleTreeNode<Integer> node10 = new SimpleTreeNode<>(11, node);
        tree.AddChild(node7, node10);
        SimpleTreeNode<Integer> node11 = new SimpleTreeNode<>(12, node);
        tree.AddChild(node7, node11);
        SimpleTreeNode<Integer> node12 = new SimpleTreeNode<>(13, node);
        tree.AddChild(node7, node12);
        SimpleTreeNode<Integer> node13 = new SimpleTreeNode<>(14, node);
        tree.AddChild(node9, node13);
        SimpleTreeNode<Integer> node14 = new SimpleTreeNode<>(15, node);
        tree.AddChild(node9, node14);
        SimpleTreeNode<Integer> node15 = new SimpleTreeNode<>(16, node);
        tree.AddChild(node9, node15);
        SimpleTreeNode<Integer> node16 = new SimpleTreeNode<>(17, node);
        tree.AddChild(node12, node16);
        SimpleTreeNode<Integer> node17 = new SimpleTreeNode<>(18, node);
        tree.AddChild(node15, node17);
        Assert.assertEquals(18, tree.Count());
        result = tree.EvenTrees();
        Assert.assertEquals(8, result.size());
        Assert.assertEquals(true, result.contains(node9.NodeValue));
        Assert.assertEquals(true, result.contains(node7.NodeValue));
        Assert.assertEquals(true, result.contains(node.NodeValue));
        Assert.assertEquals(true, result.contains(node15.NodeValue));
        Assert.assertEquals(true, result.contains(node12.NodeValue));
        Assert.assertEquals(true, result.contains(node3.NodeValue));
        Assert.assertEquals(true, result.contains(node2.NodeValue));
        Assert.assertEquals(false, result.contains(node4.NodeValue));
        Assert.assertEquals(false, result.contains(node5.NodeValue));
        Assert.assertEquals(false, result.contains(node8.NodeValue));

    }


    @Test
    public void testEvenFour(){
        SimpleTree<Integer> tree = new SimpleTree<>(null);
        ArrayList<Integer> result = tree.EvenTrees();
        SimpleTreeNode<Integer> node = new SimpleTreeNode<>(1, null);
        tree = new SimpleTree<>(node);
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<>(2, node);
        tree.AddChild(node, node1);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<>(3, node);
        tree.AddChild(node1, node2);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<>(4, node);
        tree.AddChild(node2, node3);
        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<>(5, node);
        tree.AddChild(node3, node4);
        SimpleTreeNode<Integer> node5 = new SimpleTreeNode<>(6, node);
        tree.AddChild(node4, node5);
        result = tree.EvenTrees();
        Assert.assertEquals(4, result.size());
        Assert.assertEquals(true, result.contains(node2.NodeValue));
        Assert.assertEquals(true, result.contains(node1.NodeValue));
        Assert.assertEquals(true, result.contains(node4.NodeValue));
        Assert.assertEquals(true, result.contains(node3.NodeValue));

    }

    @Test
    public void testInsert() {

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
        //  List<SimpleTreeNode<Integer>> t = tree.GetAllNodes();

        Assert.assertEquals(2, node.Children.size());
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


    @Test
    public void leaveCountTest() {
        SimpleTree<Integer> tree = new SimpleTree<>(null);
        Assert.assertEquals(0, tree.Count());
        Assert.assertEquals(0, tree.LeafCount());

        SimpleTreeNode<Integer> node = new SimpleTreeNode<>(1, null);
        tree = new SimpleTree<>(node);
        Assert.assertEquals(1, tree.Count());
        Assert.assertEquals(1, tree.LeafCount());

        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<>(2, node);
        tree.AddChild(node, node1);
        Assert.assertEquals(2, tree.Count());
        Assert.assertEquals(1, tree.LeafCount());

        SimpleTreeNode<Integer> node13 = new SimpleTreeNode<>(2, node);
        tree.AddChild(node1, node13);
        Assert.assertEquals(3, tree.Count());
        Assert.assertEquals(1, tree.LeafCount());

        SimpleTreeNode<Integer> node11 = new SimpleTreeNode<>(2, node);
        tree.AddChild(node, node11);
        Assert.assertEquals(4, tree.Count());
        Assert.assertEquals(2, tree.LeafCount());

        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<>(2, null);
        tree.AddChild(node, node2);
        Assert.assertEquals(5, tree.Count());
        Assert.assertEquals(3, tree.LeafCount());

        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<>(2, null);
        tree.AddChild(node2, node3);
        Assert.assertEquals(6, tree.Count());
        Assert.assertEquals(3, tree.LeafCount());

        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<>(2, null);
        tree.AddChild(node2, node4);
        Assert.assertEquals(7, tree.Count());
        Assert.assertEquals(4, tree.LeafCount());

        SimpleTreeNode<Integer> node44 = new SimpleTreeNode<>(2, null);
        tree.AddChild(node2, node44);
        Assert.assertEquals(8, tree.Count());
        Assert.assertEquals(5, tree.LeafCount());

        SimpleTreeNode<Integer> node440 = new SimpleTreeNode<>(2, node);
        tree.AddChild(node44, node440);
        Assert.assertEquals(9, tree.Count());
        Assert.assertEquals(5, tree.LeafCount());

        SimpleTreeNode<Integer> node4440 = new SimpleTreeNode<>(2, node);
        tree.AddChild(node44, node4440);
        Assert.assertEquals(10, tree.Count());
        Assert.assertEquals(6, tree.LeafCount());

        SimpleTreeNode<Integer> node4441 = new SimpleTreeNode<>(2, node);
        tree.AddChild(node4440, node4441);
        Assert.assertEquals(11, tree.Count());
        Assert.assertEquals(6, tree.LeafCount());

        SimpleTreeNode<Integer> node0 = new SimpleTreeNode<>(2, node);
        tree.AddChild(node44, node0);
        Assert.assertEquals(12, tree.Count());
        Assert.assertEquals(7, tree.LeafCount());

        tree.DeleteNode(node2);
        Assert.assertEquals(4, tree.Count());
        Assert.assertEquals(2, tree.LeafCount());

        SimpleTreeNode<Integer> node110 = new SimpleTreeNode<>(2, node);
        tree.AddChild(node11, node110);
        Assert.assertEquals(5, tree.Count());
        Assert.assertEquals(2, tree.LeafCount());

        SimpleTreeNode<Integer> node111 = new SimpleTreeNode<>(2, node);
        tree.AddChild(node11, node111);
        Assert.assertEquals(6, tree.Count());
        Assert.assertEquals(3, tree.LeafCount());

        tree.DeleteNode(node110);
        Assert.assertEquals(5, tree.Count());
        Assert.assertEquals(2, tree.LeafCount());
    }
}
