package Tree;

import org.junit.Assert;
import org.junit.Test;

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
        Assert.assertEquals(false, tree.DeleteNodeByKey(7));
        Assert.assertEquals(5, tree.Count());

        Assert.assertEquals(true, tree.DeleteNodeByKey(3));
        Assert.assertEquals(false, tree.FindNodeByKey(3).NodeHasKey);
        Assert.assertEquals(null, tree.FindNodeByKey(5).Node.LeftChild);
        Assert.assertEquals(false, tree.FindNodeByKey(4).NodeHasKey);
        Assert.assertEquals(2, tree.Count());
    }
}
