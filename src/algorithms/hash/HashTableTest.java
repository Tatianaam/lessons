package algorithms.hash;

import org.junit.Assert;
import org.junit.Test;

public class HashTableTest {

    @Test
    public void testHashTable(){
        HashTable hashTable = new HashTable(7, 3);
        int one = hashTable.put("asd");
        hashTable.put("asd");
        hashTable.put("asd");
        int two = hashTable.put("qwe");
        int three = hashTable.put("qweqwe");
        int four = hashTable.put("Asd");
        int five = hashTable.put("asdqwe");
        int six = hashTable.put("sad");
        int seven = hashTable.put("dsa");
        Assert.assertEquals(one, hashTable.find("asd"));
        Assert.assertEquals(two, hashTable.find("qwe"));
        Assert.assertEquals(three, hashTable.find("qweqwe"));
        Assert.assertEquals(four, hashTable.find("Asd"));
        Assert.assertEquals(five, hashTable.find("asdqwe"));
        Assert.assertEquals(six, hashTable.find("sad"));
        Assert.assertEquals(seven, hashTable.find("dsa"));
        Assert.assertEquals(-1, hashTable.put("extra"));
        Assert.assertEquals(-1, hashTable.find("ASD"));
    }
}
