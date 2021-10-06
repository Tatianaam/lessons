package queue;

import org.junit.Assert;
import org.junit.Test;

public class DequeTest {

    @Test
    public void testDeque(){
        Deque deque = new Deque();
        Assert.assertEquals(0, deque.size());
        deque.addFront(1);
        Assert.assertEquals(1, deque.size());
        deque.addFront(2);
        Assert.assertEquals(2, deque.removeFront());
        deque.addTail(3);
        Assert.assertEquals(2, deque.size());
        Assert.assertEquals(3, deque.removeTail());
        Assert.assertEquals(1, deque.removeTail());
        Assert.assertEquals(0, deque.size());
    }

    @Test
    public void isPalindromeTest(){
        Deque deque = new Deque();
        String str = "asddsa";
        Assert.assertEquals(true, deque.isPalindrome(str));
        str = "asdfdsa";
        Assert.assertEquals(true, deque.isPalindrome(str));
        str = "aa";
        Assert.assertEquals(true, deque.isPalindrome(str));
        str = "aaa";
        Assert.assertEquals(true, deque.isPalindrome(str));
        str = "asa";
        Assert.assertEquals(true, deque.isPalindrome(str));
        str = "qwe";
        Assert.assertEquals(false, deque.isPalindrome(str));
        str = "asas";
        Assert.assertEquals(false, deque.isPalindrome(str));

    }
}
