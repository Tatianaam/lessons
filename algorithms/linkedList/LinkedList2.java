import java.util.*;

public class LinkedList2
{
    public Node head;
    public Node tail;

    public LinkedList2()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item)
    {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public Node find(int _value)
    {
        Node node = this.head;
        while (node != null) {
            if (node.value == _value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value)
    {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
        while (node != null) {
            if (node.value == _value)
                nodes.add(node);
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value)
    {
        boolean result = false;
        Node current = this.head;

        while (current != null) {
            if (current.value == _value) {
                if (this.head == current) {
                    this.head = current.next;
                    if (this.tail == current)
                        this.tail = null;
                    else
                        this.head.prev = null;
                } else {
                    if (current.next != null) {
                        current.prev.next = current.next;
                        current.next.prev = current.prev;
                    } else {
                        this.tail = current.prev;
                        this.tail.next = null;
                    }
                }
                result = true;
                break;
            }
            current = current.next;
        }
        return result;
    }

    public void removeAll(int _value)
    {
        Node current = this.head;

        while (current != null) {
            if (current.value == _value) {
                if (this.head == current) {
                    this.head = current.next;
                    if (this.tail == current)
                        this.tail = null;
                    else
                        this.head.prev = null;
                } else {
                    if (current.next != null) {
                        current.next.prev = current.prev;
                        current.prev.next = current.next;
                    } else {
                        current.prev.next = null;
                        this.tail = current.prev;
                        break;
                    }
                }
            }
            current = current.next;
        }
    }

    public void clear()
    {
        this.head = null;
        this.tail = null;
    }

    public int count()
    {
        int count = 0;
        Node node = this.head;
        while(node != null) {
            count ++;
            node = node.next;
        }
        return count;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        Node node = this.head;

        if (_nodeAfter != null) {
            node = _nodeAfter.next;
            _nodeAfter.next = _nodeToInsert;
            _nodeToInsert.next = node;
            _nodeToInsert.prev = _nodeAfter;
            if (this.tail == _nodeAfter)
                this.tail = _nodeToInsert;
            else
                node.prev = _nodeToInsert;
        } else {
            _nodeToInsert.next = node;
            if (node != null)
                node.prev = _nodeToInsert;
            this.head = _nodeToInsert;
            if (this.tail == null)
                this.tail = _nodeToInsert;
        }
    }
}

class Node
{
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}
