package queue;

import org.junit.Assert;
import org.junit.Test;

public class QueueTest {

    @Test
    public void testQueue(){
        Queue queue = new Queue();
        Assert.assertEquals(0, queue.size());
        queue.enqueue("Hello");
        Assert.assertEquals(1, queue.size());
        queue.enqueue(123.123);
        Assert.assertEquals(2, queue.size());
        Assert.assertEquals("Hello", queue.dequeue());
        Assert.assertEquals(1, queue.size());
        Assert.assertEquals(123.123, queue.dequeue());
        Assert.assertEquals(0, queue.size());
    }

    @Test
    public void rotateQueueForNTest(){
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        Assert.assertEquals(5, queue.size());
        queue.rotateQueueForN(2);
        Assert.assertEquals(5, queue.size());
        Assert.assertEquals(3, queue.dequeue());
    }

    @Test
    public void testStackBasedQueue(){
        StackBasedQueue queue = new StackBasedQueue();
        Assert.assertEquals(0, queue.size());
        queue.enqueue("Hello");
        Assert.assertEquals(1, queue.size());
        queue.enqueue(123.123);
        Assert.assertEquals(2, queue.size());
        Assert.assertEquals("Hello", queue.dequeue());
        Assert.assertEquals(1, queue.size());
        Assert.assertEquals(123.123, queue.dequeue());
        Assert.assertEquals(0, queue.size());
    }
}
