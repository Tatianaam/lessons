package algorithms.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BalancedBSTTest {

    @Test
    public void testSingle() {
        int[] input = {1};
        BalancedBST balancedBST = new BalancedBST();
        Assert.assertEquals(null, balancedBST.Root);
        balancedBST.GenerateTree(input);
        Assert.assertEquals(1, balancedBST.Root.NodeKey);
        Assert.assertEquals(0, balancedBST.Root.Level);
        Assert.assertEquals(null, balancedBST.Root.Parent);
        Assert.assertEquals(null, balancedBST.Root.LeftChild);
        Assert.assertEquals(null, balancedBST.Root.RightChild);
        Assert.assertEquals(true, balancedBST.IsBalanced(balancedBST.Root));
    }

    @Test
    public void testTwo() {
        int[] input = {1, 2};
        BalancedBST balancedBST = new BalancedBST();
        Assert.assertEquals(null, balancedBST.Root);
        balancedBST.GenerateTree(input);
        Assert.assertEquals(2, balancedBST.Root.NodeKey);
        Assert.assertEquals(0, balancedBST.Root.Level);
        Assert.assertEquals(null, balancedBST.Root.Parent);
        Assert.assertEquals(null, balancedBST.Root.RightChild);
        Assert.assertEquals(1, balancedBST.Root.LeftChild.NodeKey);
        Assert.assertEquals(1, balancedBST.Root.LeftChild.Level);
        Assert.assertEquals(true, balancedBST.IsBalanced(balancedBST.Root));
    }

    @Test
    public void testThree() {
        int[] input = {1, 2, 3};
        BalancedBST balancedBST = new BalancedBST();
        Assert.assertEquals(null, balancedBST.Root);
        balancedBST.GenerateTree(input);
        Assert.assertEquals(2, balancedBST.Root.NodeKey);
        Assert.assertEquals(0, balancedBST.Root.Level);
        Assert.assertEquals(null, balancedBST.Root.Parent);
        Assert.assertEquals(3, balancedBST.Root.RightChild.NodeKey);
        Assert.assertEquals(1, balancedBST.Root.RightChild.Level);
        Assert.assertEquals(1, balancedBST.Root.LeftChild.NodeKey);
        Assert.assertEquals(1, balancedBST.Root.LeftChild.Level);
        Assert.assertEquals(2, balancedBST.Root.LeftChild.Parent.NodeKey);
        Assert.assertEquals(2, balancedBST.Root.RightChild.Parent.NodeKey);
        Assert.assertEquals(true, balancedBST.IsBalanced(balancedBST.Root));
    }

    @Test
    public void testFour() {
        int[] input = {1, 2, 3, 5};
        BalancedBST balancedBST = new BalancedBST();
        Assert.assertEquals(null, balancedBST.Root);
        balancedBST.GenerateTree(input);
        Assert.assertEquals(1, balancedBST.Root.LeftChild.LeftChild.NodeKey);
        Assert.assertEquals(true, balancedBST.IsBalanced(balancedBST.Root));
    }


    @Test
    public void testFive() {
        int[] input = {1, 2, 3, 5, 6};
        BalancedBST balancedBST = new BalancedBST();
        Assert.assertEquals(null, balancedBST.Root);
        balancedBST.GenerateTree(input);
        Assert.assertEquals(1, balancedBST.Root.LeftChild.LeftChild.NodeKey);
        Assert.assertEquals(5, balancedBST.Root.RightChild.LeftChild.NodeKey);
        Assert.assertEquals(true, balancedBST.IsBalanced(balancedBST.Root));
    }

    @Test
    public void testMany() {
        int[] input = {9, 18, 11, 6, 2, 19, 35, 25, 30, 17, 16, 20, 21, 22, 23};
        Arrays.sort(input);
        BalancedBST balancedBST = new BalancedBST();
        Assert.assertEquals(null, balancedBST.Root);
        balancedBST.GenerateTree(input);
        Assert.assertEquals(19, balancedBST.Root.NodeKey);
        Assert.assertEquals(2, balancedBST.Root.LeftChild.LeftChild.LeftChild.NodeKey);
        Assert.assertEquals(35, balancedBST.Root.RightChild.RightChild.RightChild.NodeKey);
        Assert.assertEquals(3, balancedBST.Root.LeftChild.LeftChild.LeftChild.Level);
        Assert.assertEquals(3, balancedBST.Root.RightChild.RightChild.RightChild.Level);
        Assert.assertEquals(22, balancedBST.Root.RightChild.LeftChild.RightChild.NodeKey);
        Assert.assertEquals(3, balancedBST.Root.RightChild.LeftChild.RightChild.Level);
        Assert.assertEquals(true, balancedBST.IsBalanced(balancedBST.Root));
    }

    @Test
    public void testImbalanced() {
        BSTNode node = new BSTNode(6, null);
        BSTNode nL = new BSTNode(4, node);
        node.LeftChild = nL;
        BSTNode nLL = new BSTNode(2, nL);
        nL.LeftChild = nLL;
        BalancedBST balancedBST = new BalancedBST();
        balancedBST.Root = node;
        Assert.assertEquals(false, balancedBST.IsBalanced(node));
        Assert.assertEquals(true, balancedBST.IsBalanced(nL));
        BSTNode nR = new BSTNode(8, node);
        node.RightChild = nR;
        Assert.assertEquals(true, balancedBST.IsBalanced(node));
        nLL.RightChild = nR;
        Assert.assertEquals(false, balancedBST.IsBalanced(node));
    }

    @Test
    public void testSame(){
        int[] input = {1, 1, 2, 2};
        BalancedBST balancedBST = new BalancedBST();
        Assert.assertEquals(null, balancedBST.Root);
        balancedBST.GenerateTree(input);
        Assert.assertEquals(2, balancedBST.Root.RightChild.NodeKey);
        Assert.assertEquals(1, balancedBST.Root.LeftChild.RightChild.NodeKey);
        Assert.assertEquals(true, balancedBST.IsBalanced(balancedBST.Root));
    }

    @Test
    public void test(){
        int[] input = {1, 1, 2, 2, 3, 3, 3, 3, 6, 9, 7, 7, 8};
        BalancedBST balancedBST = new BalancedBST();
        Assert.assertEquals(null, balancedBST.Root);
        balancedBST.GenerateTree(input);
        Assert.assertEquals(true, balancedBST.IsBalanced(balancedBST.Root));
    }

}
