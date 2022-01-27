package algorithms.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class BSTNodeTest {

    @Test
    public void test(){
        //add & count
        BST<Integer> tree = new BST<>(null);
        Assert.assertEquals(0, tree.Count());
        Assert.assertEquals(null, tree.FindNodeByKey(5).Node);
        Assert.assertEquals(false, tree.FindNodeByKey(5).NodeHasKey);
        tree.AddKeyValue(5, 5);
        Assert.assertEquals(1, tree.Count());
        Assert.assertEquals(5, tree.FindNodeByKey(5).Node.NodeKey);
        Assert.assertEquals(true, tree.FindNodeByKey(5).NodeHasKey);
        //not present
        Assert.assertEquals(false, tree.FindNodeByKey(0).NodeHasKey);
        Assert.assertEquals(true, tree.FindNodeByKey(0).ToLeft);
        Assert.assertEquals(false, tree.FindNodeByKey(8).NodeHasKey);
        Assert.assertEquals(false, tree.FindNodeByKey(8).ToLeft);

        Assert.assertEquals(false, tree.FindNodeByKey(3).NodeHasKey);
        tree.AddKeyValue(3, 3);
        Assert.assertEquals(2, tree.Count());
        Assert.assertEquals(3, tree.FindNodeByKey(3).Node.NodeKey);
        tree.AddKeyValue(8, 8);
        Assert.assertEquals(3, tree.Count());
        Assert.assertEquals(8, tree.FindNodeByKey(8).Node.NodeKey);
        tree.AddKeyValue(7, 7);
        Assert.assertEquals(4, tree.Count());
        Assert.assertEquals(7, tree.FindNodeByKey(7).Node.NodeKey);
        tree.AddKeyValue(2, 2);
        Assert.assertEquals(5, tree.Count());
        Assert.assertEquals(2, tree.FindNodeByKey(2).Node.NodeKey);
        Assert.assertEquals(true, tree.AddKeyValue(4, 4));
        Assert.assertEquals(6, tree.Count());
        Assert.assertEquals(4, tree.FindNodeByKey(4).Node.NodeKey);
        Assert.assertEquals(false, tree.AddKeyValue(4, 4));
        Assert.assertEquals(6, tree.Count());
        Assert.assertEquals(4, tree.FindNodeByKey(4).Node.NodeKey);

        //not present
        Assert.assertEquals(false, tree.FindNodeByKey(6).NodeHasKey);
        Assert.assertEquals(true, tree.FindNodeByKey(6).ToLeft);
        Assert.assertEquals(7, tree.FindNodeByKey(6).Node.NodeKey);
        Assert.assertEquals(false, tree.FindNodeByKey(9).NodeHasKey);
        Assert.assertEquals(false, tree.FindNodeByKey(9).ToLeft);
        Assert.assertEquals(8, tree.FindNodeByKey(9).Node.NodeKey);


        //max
        Assert.assertEquals(8, tree.FinMinMax(tree.Root, true).NodeKey);
        Assert.assertEquals(4, tree.FinMinMax(tree.Root.LeftChild, true).NodeKey);
        Assert.assertEquals(8, tree.FinMinMax(tree.Root.RightChild, true).NodeKey);

        //min
        Assert.assertEquals(2, tree.FinMinMax(tree.Root, false).NodeKey);
        Assert.assertEquals(2, tree.FinMinMax(tree.Root.LeftChild, false).NodeKey);
        Assert.assertEquals(7, tree.FinMinMax(tree.Root.RightChild, false).NodeKey);

        //remove
        Assert.assertEquals(true, tree.DeleteNodeByKey(7));
        Assert.assertEquals(false, tree.FindNodeByKey(7).NodeHasKey);
        Assert.assertEquals(null, tree.FindNodeByKey(8).Node.LeftChild);
        Assert.assertEquals(null, tree.Root.RightChild.LeftChild);
        Assert.assertEquals(null, tree.Root.RightChild.RightChild);
        Assert.assertEquals(false, tree.DeleteNodeByKey(7));
        Assert.assertEquals(5, tree.Count());

        Assert.assertEquals(true, tree.DeleteNodeByKey(3));
        Assert.assertEquals(false, tree.FindNodeByKey(3).NodeHasKey);
        Assert.assertEquals(4, tree.Root.LeftChild.NodeKey);
        Assert.assertEquals(4, tree.Root.LeftChild.LeftChild.Parent.NodeKey);
        Assert.assertEquals(2, tree.FindNodeByKey(5).Node.LeftChild.LeftChild.NodeKey);
        Assert.assertEquals(2, tree.FindNodeByKey(4).Node.LeftChild.NodeKey);
        Assert.assertEquals(4, tree.Count());

        Assert.assertEquals(true, tree.DeleteNodeByKey(5));
        Assert.assertEquals(3, tree.Count());
        Assert.assertEquals(8, tree.Root.NodeKey);
        Assert.assertEquals(4, tree.Root.LeftChild.NodeKey);
        Assert.assertEquals(2, tree.Root.LeftChild.LeftChild.NodeKey);
        Assert.assertEquals(false, tree.FindNodeByKey(5).NodeHasKey);

        Assert.assertEquals(true, tree.DeleteNodeByKey(2));
        Assert.assertEquals(2, tree.Count());
        Assert.assertEquals(8, tree.Root.NodeKey);
        Assert.assertEquals(4, tree.Root.LeftChild.NodeKey);
        Assert.assertEquals(null, tree.Root.LeftChild.LeftChild);
        Assert.assertEquals(false, tree.FindNodeByKey(2).NodeHasKey);
    }

    @Test
    public void testDeleteComplex(){
        BST<Integer> tree = new BST<>(null);
        tree.AddKeyValue(16, 16);
        tree.AddKeyValue(11, 11);
        tree.AddKeyValue(6, 6);
        tree.AddKeyValue(9, 9);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(10, 10);
        tree.AddKeyValue(7, 7);
        tree.AddKeyValue(8, 8);
        Assert.assertEquals(8, tree.Count());
        Assert.assertEquals(16, tree.Root.NodeKey);
        Assert.assertEquals(2, tree.FinMinMax(tree.Root, false).NodeKey);
        Assert.assertEquals(16, tree.FinMinMax(tree.Root, true).NodeKey);
        Assert.assertEquals(7, tree.FinMinMax(tree.FindNodeByKey(9).Node, false).NodeKey);
        Assert.assertEquals(10, tree.FinMinMax(tree.FindNodeByKey(9).Node, true).NodeKey);

        tree.DeleteNodeByKey(6);
        Assert.assertEquals(false, tree.FindNodeByKey(6).NodeHasKey);
        Assert.assertEquals(7, tree.Count());
        Assert.assertEquals(16, tree.Root.NodeKey);
        Assert.assertEquals(7, tree.Root.LeftChild.LeftChild.NodeKey);
        Assert.assertEquals(8, tree.Root.LeftChild.LeftChild.RightChild.LeftChild.NodeKey);
        Assert.assertEquals(10, tree.Root.LeftChild.LeftChild.RightChild.RightChild.NodeKey);
        Assert.assertEquals(9, tree.Root.LeftChild.LeftChild.RightChild.LeftChild.Parent.NodeKey);

        tree.DeleteNodeByKey(10);
        Assert.assertEquals(false, tree.FindNodeByKey(10).NodeHasKey);
        Assert.assertEquals(6, tree.Count());
        Assert.assertEquals(null, tree.Root.LeftChild.LeftChild.RightChild.RightChild);
    }

    @Test
    public void testDeleteNoLeftChild(){
        BST<Integer> tree = new BST<>(null);
        tree.AddKeyValue(11, 11);
        tree.AddKeyValue(7, 7);
        tree.AddKeyValue(8, 8);
        tree.AddKeyValue(9, 9);
        Assert.assertEquals(4, tree.Count());
        Assert.assertEquals(11, tree.Root.NodeKey);
        Assert.assertEquals(7, tree.Root.LeftChild.NodeKey);
        Assert.assertEquals(8, tree.Root.LeftChild.RightChild.NodeKey);
        Assert.assertEquals(9, tree.Root.LeftChild.RightChild.RightChild.NodeKey);
        Assert.assertEquals(null, tree.Root.LeftChild.RightChild.RightChild.RightChild);
        Assert.assertEquals(null, tree.Root.LeftChild.RightChild.RightChild.LeftChild);

        Assert.assertEquals(true, tree.DeleteNodeByKey(7));
        Assert.assertEquals(3, tree.Count());
        Assert.assertEquals(false, tree.FindNodeByKey(7).NodeHasKey);
        Assert.assertEquals(11, tree.Root.NodeKey);
        Assert.assertEquals(8, tree.Root.LeftChild.NodeKey);
        Assert.assertEquals(11, tree.FindNodeByKey(8).Node.Parent.NodeKey);
        Assert.assertEquals(null, tree.Root.LeftChild.LeftChild);
        Assert.assertEquals(9, tree.Root.LeftChild.RightChild.NodeKey);

        tree.DeleteNodeByKey(8);
        Assert.assertEquals(false, tree.FindNodeByKey(8).NodeHasKey);
        Assert.assertEquals(2, tree.Count());
        Assert.assertEquals(11, tree.Root.NodeKey);
        Assert.assertEquals(9, tree.Root.LeftChild.NodeKey);
        Assert.assertEquals(11, tree.Root.LeftChild.Parent.NodeKey);
        Assert.assertEquals(null, tree.Root.LeftChild.LeftChild);
        Assert.assertEquals(null, tree.Root.LeftChild.RightChild);

        tree.DeleteNodeByKey(11);
        Assert.assertEquals(1, tree.Count());
        Assert.assertEquals(false, tree.FindNodeByKey(11).NodeHasKey);
        Assert.assertEquals(9, tree.Root.NodeKey);
        Assert.assertEquals(null, tree.Root.Parent);
        Assert.assertEquals(null, tree.Root.LeftChild);
        Assert.assertEquals(null, tree.Root.RightChild);

        tree.DeleteNodeByKey(9);
        Assert.assertEquals(0, tree.Count());
        Assert.assertEquals(false, tree.FindNodeByKey(9).NodeHasKey);
        Assert.assertEquals(null, tree.Root);
    }

    @Test
    public void testDeleteNoLeftChildS(){
        BST<Integer> tree = new BST<>(null);
        tree.AddKeyValue(11, 11);
        tree.AddKeyValue(7, 7);
        tree.AddKeyValue(8, 8);
        tree.AddKeyValue(9, 9);

        Assert.assertEquals(true, tree.DeleteNodeByKey(7));
        Assert.assertEquals(3, tree.Count());
        Assert.assertEquals(false, tree.FindNodeByKey(7).NodeHasKey);
        Assert.assertEquals(11, tree.Root.NodeKey);
        Assert.assertEquals(8, tree.Root.LeftChild.NodeKey);
        Assert.assertEquals(11, tree.FindNodeByKey(8).Node.Parent.NodeKey);
        Assert.assertEquals(null, tree.Root.LeftChild.LeftChild);
        Assert.assertEquals(9, tree.Root.LeftChild.RightChild.NodeKey);

        tree.DeleteNodeByKey(8);
        Assert.assertEquals(false, tree.FindNodeByKey(8).NodeHasKey);
        Assert.assertEquals(2, tree.Count());
        Assert.assertEquals(11, tree.Root.NodeKey);
        Assert.assertEquals(9, tree.Root.LeftChild.NodeKey);
        Assert.assertEquals(11, tree.Root.LeftChild.Parent.NodeKey);
        Assert.assertEquals(null, tree.Root.LeftChild.LeftChild);
        Assert.assertEquals(null, tree.Root.LeftChild.RightChild);

        tree.DeleteNodeByKey(9);
        Assert.assertEquals(1, tree.Count());
        Assert.assertEquals(false, tree.FindNodeByKey(9).NodeHasKey);
        Assert.assertEquals(11, tree.Root.NodeKey);
        Assert.assertEquals(null, tree.Root.Parent);
        Assert.assertEquals(null, tree.Root.LeftChild);
        Assert.assertEquals(null, tree.Root.RightChild);

        tree.DeleteNodeByKey(11);
        Assert.assertEquals(0, tree.Count());
        Assert.assertEquals(false, tree.FindNodeByKey(11).NodeHasKey);
        Assert.assertEquals(null, tree.Root);
    }

    @Test
    public void testDeleteNoLeftChildT(){
        BST<Integer> tree = new BST<>(null);
        tree.AddKeyValue(11, 11);
        tree.AddKeyValue(7, 7);
        tree.AddKeyValue(8, 8);
        tree.AddKeyValue(9, 9);
        Assert.assertEquals(4, tree.Count());
        Assert.assertEquals(11, tree.Root.NodeKey);
        Assert.assertEquals(7, tree.Root.LeftChild.NodeKey);
        Assert.assertEquals(8, tree.Root.LeftChild.RightChild.NodeKey);
        Assert.assertEquals(9, tree.Root.LeftChild.RightChild.RightChild.NodeKey);
        Assert.assertEquals(null, tree.Root.LeftChild.RightChild.RightChild.RightChild);
        Assert.assertEquals(null, tree.Root.LeftChild.RightChild.RightChild.LeftChild);

        Assert.assertEquals(true, tree.DeleteNodeByKey(8));
        Assert.assertEquals(3, tree.Count());
        Assert.assertEquals(false, tree.FindNodeByKey(8).NodeHasKey);
        Assert.assertEquals(11, tree.Root.NodeKey);
        Assert.assertEquals(7, tree.Root.LeftChild.NodeKey);
        Assert.assertEquals(7, tree.FindNodeByKey(9).Node.Parent.NodeKey);
        Assert.assertEquals(9, tree.Root.LeftChild.RightChild.NodeKey);
        Assert.assertEquals(null, tree.Root.LeftChild.LeftChild);
        Assert.assertEquals(9, tree.Root.LeftChild.RightChild.NodeKey);

    }

    @Test
    public void testOrder(){
        BST<Integer> tree = new BST<>(null);
        tree.AddKeyValue(16, 16);
        tree.AddKeyValue(11, 11);
        tree.AddKeyValue(6, 6);
        tree.AddKeyValue(9, 9);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(10, 10);
        tree.AddKeyValue(7, 7);
        tree.AddKeyValue(8, 8);
        tree.AddKeyValue(20, 20);
        tree.AddKeyValue(18, 18);
        tree.AddKeyValue(30, 30);
        tree.AddKeyValue(17, 17);
        tree.AddKeyValue(19, 19);
        tree.AddKeyValue(35, 35);
        tree.AddKeyValue(25, 25);
        tree.AddKeyValue(24, 24);
        tree.AddKeyValue(26, 26);

        ArrayList<BSTNode> temp = tree.WideAllNodes();
        Assert.assertEquals(16, temp.get(0).NodeKey);
        Assert.assertEquals(11, temp.get(1).NodeKey);
        Assert.assertEquals(20, temp.get(2).NodeKey);
        Assert.assertEquals(6, temp.get(3).NodeKey);
        Assert.assertEquals(18, temp.get(4).NodeKey);
        Assert.assertEquals(30, temp.get(5).NodeKey);
        Assert.assertEquals(20, temp.get(2).NodeKey);
        Assert.assertEquals(8, temp.get(16).NodeKey);
        Assert.assertEquals(26, temp.get(15).NodeKey);

        temp = tree.DeepAllNodes(0);
        Assert.assertEquals(2, temp.get(0).NodeKey);
        Assert.assertEquals(6, temp.get(1).NodeKey);
        Assert.assertEquals(7, temp.get(2).NodeKey);
        Assert.assertEquals(16, temp.get(7).NodeKey);
        Assert.assertEquals(35, temp.get(16).NodeKey);
        Assert.assertEquals(30, temp.get(15).NodeKey);
        Assert.assertEquals(26, temp.get(14).NodeKey);

        temp = tree.DeepAllNodes(1);
        Assert.assertEquals(2, temp.get(0).NodeKey);
        Assert.assertEquals(8, temp.get(1).NodeKey);
        Assert.assertEquals(7, temp.get(2).NodeKey);
        Assert.assertEquals(17, temp.get(7).NodeKey);
        Assert.assertEquals(16, temp.get(16).NodeKey);
        Assert.assertEquals(20, temp.get(15).NodeKey);
        Assert.assertEquals(30, temp.get(14).NodeKey);

        temp = tree.DeepAllNodes(2);
        Assert.assertEquals(16, temp.get(0).NodeKey);
        Assert.assertEquals(11, temp.get(1).NodeKey);
        Assert.assertEquals(6, temp.get(2).NodeKey);
        Assert.assertEquals(10, temp.get(7).NodeKey);
        Assert.assertEquals(35, temp.get(16).NodeKey);
        Assert.assertEquals(26, temp.get(15).NodeKey);
        Assert.assertEquals(24, temp.get(14).NodeKey);
    }


}
