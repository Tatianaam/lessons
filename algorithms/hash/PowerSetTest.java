package PowerSet;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public class PowerSetTest {

    @Test
    public void removeTest(){
        PowerSet powerSet = new PowerSet();
        Assert.assertEquals(false, powerSet.remove("d"));
        powerSet.put("d");
        powerSet.put("22");
        powerSet.put("! #");
        powerSet.put("!# ");
        powerSet.put(" !#");
        powerSet.put("# !");
        Assert.assertEquals(6, powerSet.size());
        Assert.assertEquals(true, powerSet.get("d"));
        Assert.assertEquals(true, powerSet.remove("d"));
        Assert.assertEquals(false, powerSet.remove("d"));
        Assert.assertEquals(true, powerSet.remove("! #"));
        Assert.assertEquals(false, powerSet.remove("! #"));
        Assert.assertEquals(true, powerSet.remove("# !"));
        Assert.assertEquals(false, powerSet.remove("# !"));
        Assert.assertEquals(3, powerSet.size());
//        Arrays.fill(powerSet.slots, String.valueOf(Math.random()));
//        powerSet.size = 20000;
//        Assert.assertEquals(false, powerSet.remove("B"));
//        Assert.assertEquals(false, powerSet.remove("C"));
//        Assert.assertEquals(20000, powerSet.getNonEmpty().length);
    }


    @Test
    public void testDiff(){
        PowerSet one = new PowerSet();
        PowerSet two = new PowerSet();
        Assert.assertEquals(0, one.difference(two).size());
        Assert.assertEquals(0, two.difference(one).size());
        one.put("A");
        Assert.assertEquals(1, one.difference(two).size());
        Assert.assertEquals(true, one.difference(two).get("A"));
        Assert.assertEquals(0, two.difference(one).size());
        two.put("B");
        Assert.assertEquals(1, one.difference(two).size());
        Assert.assertEquals(1, two.difference(one).size());
    }

    @Test
    public void testPowerSet(){
        PowerSet powerSet = new PowerSet();
        powerSet.put("A");
        Assert.assertEquals(1, powerSet.size());
        powerSet.put("B");
        Assert.assertEquals(2, powerSet.size());
        powerSet.put("A");
        Assert.assertEquals(2, powerSet.size());
        PowerSet powerSet1 = new PowerSet();
        powerSet1.put("A");
        Assert.assertEquals(true, powerSet.isSubset(powerSet1));
        powerSet1.put("B");
        Assert.assertEquals(true, powerSet.isSubset(powerSet1));
        powerSet1.put("C");
        Assert.assertEquals(false, powerSet.isSubset(powerSet1));
        Assert.assertEquals(true, powerSet.intersection(powerSet1).get("A"));
        Assert.assertEquals(true, powerSet.intersection(powerSet1).get("B"));
        Assert.assertEquals(2, powerSet.intersection(powerSet1).size());
        Assert.assertEquals(false, powerSet.difference(powerSet1).get("C"));
        Assert.assertEquals(true, powerSet1.difference(powerSet).get("C"));
        Assert.assertEquals(0, powerSet.difference(powerSet1).size());
        powerSet1.remove("C");
        Assert.assertEquals(false, powerSet.difference(powerSet1).get("C"));
        Assert.assertEquals(0, powerSet.difference(powerSet1).size());
        powerSet.put("D");
        powerSet1.put("E");
        Assert.assertEquals(true, powerSet.union(powerSet1).get("D"));
        Assert.assertEquals(true, powerSet.union(powerSet1).get("E"));
        Assert.assertEquals(true, powerSet.union(powerSet1).get("A"));
        Assert.assertEquals(true, powerSet.union(powerSet1).get("B"));
        Assert.assertEquals(false, powerSet.union(powerSet1).get("C"));
        Assert.assertEquals(4, powerSet.union(powerSet1).size());

    }

    @Test
    public void testEmpty(){
        PowerSet powerSet = new PowerSet();
        powerSet.put("A");
        PowerSet empty = new PowerSet();
        Assert.assertEquals(false, empty.difference(powerSet).get("A"));
        Assert.assertEquals(true, powerSet.difference(empty).get("A"));
        Assert.assertEquals(false, powerSet.intersection(empty).get("A"));
        Assert.assertEquals(0, powerSet.intersection(empty).size());
        Assert.assertEquals(false, empty.intersection(empty).get("A"));
        Assert.assertEquals(0, empty.intersection(empty).size());
        Assert.assertEquals(false, empty.intersection(powerSet).get("A"));
        Assert.assertEquals(0, empty.intersection(powerSet).size());
        Assert.assertEquals(1, powerSet.union(empty).size());
        Assert.assertEquals(1, empty.union(powerSet).size());
        Assert.assertEquals(true, powerSet.isSubset(empty));
        Assert.assertEquals(false, empty.isSubset(powerSet));
    }

    @Test
    public void testSubset(){
        PowerSet powerSet = new PowerSet();
        powerSet.put("A");
        PowerSet big = new PowerSet();
        big.put("A");
        big.put("B");
        Assert.assertEquals(true, big.isSubset(powerSet));
        Assert.assertEquals(false, powerSet.isSubset(big));
        Assert.assertEquals(0, powerSet.difference(big).size());
        Assert.assertEquals(1, big.difference(powerSet).size());
        powerSet.put("B");
        Assert.assertEquals(true, big.isSubset(powerSet));
        Assert.assertEquals(true, powerSet.isSubset(big));
        Assert.assertEquals(0, powerSet.difference(big).size());
        Assert.assertEquals(0, big.difference(powerSet).size());
        Assert.assertEquals(2, powerSet.intersection(big).size());
        Assert.assertEquals(2, powerSet.union(big).size());
    }

    @Test
    public void testIntersection(){
        PowerSet one = new PowerSet();
        one.put("A");
        PowerSet two = new PowerSet();
        two.put("B");
        Assert.assertEquals(0, one.intersection(two).size());
        two.put("A");
        Assert.assertEquals(1, one.intersection(two).size());
        Assert.assertEquals(1, two.intersection(one).size());
    }

    @Test
    public void testUnion(){
        PowerSet one = new PowerSet();
        one.put("A");
        PowerSet two = new PowerSet();
        two.put("B");
        Assert.assertEquals(2, one.union(two).size());
        Assert.assertEquals(2, two.union(one).size());
        one.remove("A");
        Assert.assertEquals(1, one.union(two).size());
        Assert.assertEquals(1, two.union(one).size());
        two.remove("B");
        Assert.assertEquals(0, one.union(two).size());
        Assert.assertEquals(0, two.union(one).size());
        two.put("B");
        one.put("B");
        Assert.assertEquals(1, one.union(two).size());
        Assert.assertEquals(1, two.union(one).size());
    }


//    @Test
//    public void timeTest(){
//        System.out.println(LocalDateTime.now());
//        PowerSet one = new PowerSet();
//        PowerSet two = new PowerSet();
//        one.size = 20000;
//        two.size = 20000;
//        Arrays.fill(one.slots, String.valueOf(Math.random()));
//        Arrays.fill(two.slots, String.valueOf(Math.random()));
//        System.out.println(LocalDateTime.now());
//        Assert.assertEquals(40000, one.union(two).size());
//        System.out.println(LocalDateTime.now());
//    }
}
