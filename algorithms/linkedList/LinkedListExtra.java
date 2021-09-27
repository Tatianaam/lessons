public class LinkedListExtra {

    //returns null if lengths of two provided lists are not equal
    public static LinkedList sumOfTwoLists(LinkedList one, LinkedList two) {
        LinkedList sum = new LinkedList();
        Node currentOne = one.head;
        Node currentTwo = two.head;
        Node sumNode;

        while (currentOne != null) {
            if (currentTwo != null) {
                sumNode = new Node(currentOne.value + currentTwo.value);
                if (currentOne == one.head)
                    sum.head = sumNode;
                else
                    sum.tail.next = sumNode;
                sum.tail = sumNode;
                currentOne = currentOne.next;
                currentTwo = currentTwo.next;
            } else {
                sum = null;
                break;
            }
        }

        if (currentTwo != null)
            sum = null;

        return sum;
    }


    //using count() and addInTail()
    public static LinkedList sumOfTwoListsTwo(LinkedList one, LinkedList two) {
        LinkedList sum = null;

        if (one.count() == two.count()) {
            sum = new LinkedList();
            Node currentOne = one.head;
            Node currentTwo = two.head;

            while (currentOne != null) {
                sum.addInTail(new Node(currentOne.value + currentTwo.value));
                currentOne = currentOne.next;
                currentTwo = currentTwo.next;
            }
        }
        return sum;
    }
}
