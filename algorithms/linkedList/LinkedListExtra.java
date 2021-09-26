package com.company;

public class LinkedListExtra {

    public static LinkedList sumOfTwoLists(LinkedList one, LinkedList two) {
        LinkedList sum = null;

        if(one.count() == two.count()) {
            sum = new LinkedList();
            Node currentOne = one.head;
            Node currentTwo = two.head;

            while(currentOne != null) {
                sum.addInTail(new Node(currentOne.value + currentTwo.value));
                currentOne = currentOne.next;
                currentTwo = currentTwo.next;
            }
        }

        return sum;
    }
}
