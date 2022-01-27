package algorithms.tree;

import org.junit.Assert;
import org.junit.Test;

public class aBSTTest {

    @Test
    public void testaBST(){
        aBST tree = new aBST(2);
        Assert.assertEquals(7, tree.Tree.length);
        Assert.assertEquals(null, tree.Tree[0]);
        Assert.assertEquals(0, tree.FindKeyIndex(123).intValue());
        tree.AddKey(5);
        Assert.assertEquals(5, tree.Tree[0].intValue());
        Assert.assertEquals(0, tree.FindKeyIndex(5).intValue());
        tree.AddKey(3);
        Assert.assertEquals(3, tree.Tree[1].intValue());
        Assert.assertEquals(4, tree.AddKey(4));
        Assert.assertEquals(4, tree.Tree[4].intValue());
        tree.AddKey(1);
        Assert.assertEquals(1, tree.Tree[3].intValue());
        tree.AddKey(8);
        Assert.assertEquals(8, tree.Tree[2].intValue());
        tree.AddKey(10);
        Assert.assertEquals(10, tree.Tree[6].intValue());
        tree.AddKey(6);
        Assert.assertEquals(6, tree.Tree[5].intValue());
        Assert.assertEquals(null, tree.FindKeyIndex(123));
        Assert.assertEquals(-1, tree.AddKey(123));
        Assert.assertEquals(2, tree.FindKeyIndex(8).intValue());
    }
}
