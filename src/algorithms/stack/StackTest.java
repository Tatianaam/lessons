package algorithms.stack;

import org.junit.Assert;
import org.junit.Test;

public class StackTest {

    @Test
    public void testStackString(){
        Stack stack = new Stack();
        Assert.assertEquals(0, stack.size());
        Assert.assertEquals(null, stack.peek());
        stack.push("Hello");
        Assert.assertEquals("Hello", stack.peek());
        Assert.assertEquals(1, stack.size());
        stack.push("Hi");
        Assert.assertEquals("Hi", stack.peek());
        Assert.assertEquals(2, stack.size());
        Assert.assertEquals("Hi", stack.pop());
        Assert.assertEquals(1, stack.size());
        Assert.assertEquals("Hello", stack.pop());
        Assert.assertEquals(0, stack.size());
        Assert.assertEquals(null, stack.pop());
        Assert.assertEquals(null, stack.peek());
        Assert.assertEquals(0, stack.size());
        stack.push("Haha");
        Assert.assertEquals(1, stack.size());
        Assert.assertNotEquals("Nope", stack.peek());
        Assert.assertEquals("Haha", stack.peek());
        Assert.assertEquals("Haha", stack.pop());
        Assert.assertEquals(null, stack.pop());
        Assert.assertEquals(null, stack.peek());
        Assert.assertEquals(0, stack.size());
    }

    @Test
    public void testStackWithDifferentTypes(){
        Stack stack = new Stack();
        stack.push(1);
        stack.push(1.5);
        stack.push("Hoho");
        stack.push(new String[3]);
        Assert.assertEquals(4, stack.size());
        Assert.assertNotEquals(null, stack.pop());
        Assert.assertEquals(3, stack.size());
        Assert.assertEquals("Hoho", stack.pop());
        Assert.assertEquals(1.5, stack.peek());
    }

    @Test
    public void testIsBalanced(){
        Assert.assertEquals(true, StackExtra.isBalanced("(())"));
        Assert.assertEquals(true, StackExtra.isBalanced("(())()"));
        Assert.assertEquals(true, StackExtra.isBalanced("(())((()))"));
        Assert.assertEquals(false, StackExtra.isBalanced("))(("));
        Assert.assertEquals(false, StackExtra.isBalanced(")))(())"));
        Assert.assertEquals(false, StackExtra.isBalanced("((((())"));
        Assert.assertEquals(false, StackExtra.isBalanced("())("));
        Assert.assertEquals(false, StackExtra.isBalanced(")"));
    }

    @Test
    public void testCalc(){
        Stack input = new Stack();
        input.push('*');
        input.push(3);
        input.push('+');
        input.push(2);
        input.push(1);
        Assert.assertEquals(9, StackExtra.calc(input));

        input.push('+');
        input.push(9);
        input.push('*');
        input.push(5);
        input.push('+');
        input.push(2);
        input.push(8);
        Assert.assertEquals(59, StackExtra.calc(input));
    }

}
