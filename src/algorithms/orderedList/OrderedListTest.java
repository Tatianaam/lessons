package algorithms.orderedList;

import org.junit.Assert;
import org.junit.Test;

public class OrderedListTest {

    @Test
    public void compareTest(){
        OrderedList orderedList = new OrderedList<>(true);
        Assert.assertEquals(-1, orderedList.compare(1, 2));
        Assert.assertEquals(1, orderedList.compare(11, 2));
        Assert.assertEquals(0, orderedList.compare(12, 12));
    }

    @Test
    public void orderedListAscTest(){  //asc 123
        OrderedList orderedList = new OrderedList<>(true);
        Assert.assertEquals(0, orderedList.count());
        Assert.assertEquals(null, orderedList.find(1));
        orderedList.add(1);
        Assert.assertEquals(1, orderedList.count());
        Assert.assertEquals(1, orderedList.head.value);
        Assert.assertEquals(1, orderedList.tail.value);
        Assert.assertEquals(null, orderedList.head.next);
        Assert.assertEquals(null, orderedList.tail.prev);
        orderedList.add(4);
        Assert.assertEquals(2, orderedList.count());
        Assert.assertEquals(1,orderedList.head.value);
        Assert.assertEquals(4, orderedList.tail.value);
        Assert.assertEquals(null, orderedList.head.prev);
        Assert.assertEquals(null, orderedList.tail.next);
        orderedList.add(0);
        Assert.assertEquals(3, orderedList.count());
        Assert.assertEquals(0, orderedList.head.value);
        Assert.assertEquals(4, orderedList.tail.value);
        Assert.assertEquals(null, orderedList.head.prev);
        Assert.assertEquals(null, orderedList.tail.next);
        orderedList.add(3);
        Assert.assertEquals(4, orderedList.count());
        Assert.assertEquals(0, orderedList.head.value);
        Assert.assertEquals(4, orderedList.tail.value);
        Assert.assertEquals(null, orderedList.head.prev);
        Assert.assertEquals(null, orderedList.tail.next);
        orderedList.delete(4);
        Assert.assertEquals(3, orderedList.count());
        Assert.assertEquals(0, orderedList.head.value);
        Assert.assertEquals(3, orderedList.tail.value);
        Assert.assertEquals(null, orderedList.head.prev);
        Assert.assertEquals(null, orderedList.tail.next);
        orderedList.delete(0);
        Assert.assertEquals(2, orderedList.count());
        Assert.assertEquals(1, orderedList.head.value);
        Assert.assertEquals(3, orderedList.tail.value);
        Assert.assertEquals(null, orderedList.head.prev);
        Assert.assertEquals(null, orderedList.tail.next);
        orderedList.delete(1);
        Assert.assertEquals(1, orderedList.count());
        Assert.assertEquals(3, orderedList.head.value);
        Assert.assertEquals(3, orderedList.tail.value);
        Assert.assertEquals(null, orderedList.head.prev);
        Assert.assertEquals(null, orderedList.tail.next);
        orderedList.delete(5);
        Assert.assertEquals(1, orderedList.count());
        Assert.assertEquals(3, orderedList.head.value);
        Assert.assertEquals(3, orderedList.tail.value);
        Assert.assertEquals(null, orderedList.head.prev);
        Assert.assertEquals(null, orderedList.tail.next);
        orderedList.delete(3);
        Assert.assertEquals(0, orderedList.count());
        Assert.assertEquals(null, orderedList.head);
        Assert.assertEquals(null, orderedList.tail);
    }

    @Test
    public void orderedListDescTest(){  //desc 654
        OrderedList orderedList = new OrderedList<>(false);
        Assert.assertEquals(0, orderedList.count());
        Assert.assertEquals(null, orderedList.find(1));
        orderedList.add(1);
        Assert.assertEquals(1, orderedList.count());
        Assert.assertEquals(1, orderedList.head.value);
        Assert.assertEquals(1, orderedList.tail.value);
        Assert.assertEquals(null, orderedList.head.next);
        Assert.assertEquals(null, orderedList.tail.prev);
        orderedList.add(4);
        Assert.assertEquals(2, orderedList.count());
        Assert.assertEquals(4,orderedList.head.value);
        Assert.assertEquals(1, orderedList.tail.value);
        Assert.assertEquals(null, orderedList.head.prev);
        Assert.assertEquals(null, orderedList.tail.next);
        orderedList.add(0);
        Assert.assertEquals(3, orderedList.count());
        Assert.assertEquals(4, orderedList.head.value);
        Assert.assertEquals(0, orderedList.tail.value);
        Assert.assertEquals(null, orderedList.head.prev);
        Assert.assertEquals(null, orderedList.tail.next);
        orderedList.add(3);
        Assert.assertEquals(4, orderedList.count());
        Assert.assertEquals(4, orderedList.head.value);
        Assert.assertEquals(0, orderedList.tail.value);
        Assert.assertEquals(null, orderedList.head.prev);
        Assert.assertEquals(null, orderedList.tail.next);
        orderedList.delete(4);
        Assert.assertEquals(3, orderedList.count());
        Assert.assertEquals(3, orderedList.head.value);
        Assert.assertEquals(0, orderedList.tail.value);
        Assert.assertEquals(null, orderedList.head.prev);
        Assert.assertEquals(null, orderedList.tail.next);
        orderedList.delete(0);
        Assert.assertEquals(2, orderedList.count());
        Assert.assertEquals(3, orderedList.head.value);
        Assert.assertEquals(1, orderedList.tail.value);
        Assert.assertEquals(null, orderedList.head.prev);
        Assert.assertEquals(null, orderedList.tail.next);
        orderedList.delete(1);
        Assert.assertEquals(1, orderedList.count());
        Assert.assertEquals(3, orderedList.head.value);
        Assert.assertEquals(3, orderedList.tail.value);
        Assert.assertEquals(null, orderedList.head.prev);
        Assert.assertEquals(null, orderedList.tail.next);
        orderedList.delete(5);
        Assert.assertEquals(1, orderedList.count());
        Assert.assertEquals(3, orderedList.head.value);
        Assert.assertEquals(3, orderedList.tail.value);
        Assert.assertEquals(null, orderedList.head.prev);
        Assert.assertEquals(null, orderedList.tail.next);
        orderedList.delete(3);
        Assert.assertEquals(0, orderedList.count());
        Assert.assertEquals(null, orderedList.head);
        Assert.assertEquals(null, orderedList.tail);
    }

    @Test
    public  void findTest(){
        OrderedList orderedList = new OrderedList(true);
        orderedList.add(1);
        orderedList.add(4);
        orderedList.add(3);
        Assert.assertEquals(null, orderedList.find(123));
        Assert.assertNotEquals(null, orderedList.find(1));
        Assert.assertEquals(1, orderedList.find(1).value);
    }
}
