import java.util.*;


class Node<T> {
    public T value;
    public Node<T> next, prev;

    public Node(T _value) {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T> {
    public Node<T> head, tail;
    private boolean _ascending;
    private int size;

    public OrderedList(boolean asc) {
        head = null;
        tail = null;
        _ascending = asc;
        size = 0;
    }

    public int compare(T v1, T v2) {
        int result;
        if (v1.getClass().equals(Integer.class) && v2.getClass().equals(Integer.class)) {
            if ((Integer) v1 < (Integer) v2) result = -1;
            else if (v1 == v2) result = 0;
            else result = 1;
        } else {
            String temp1 = (String) v1;
            String temp2 = (String) v2;
            result = temp1.trim().compareTo(temp2.trim());
        }

        return result;
    }

    public void add(T value) {
        if (this.size == 0) {
            this.head = this.tail = new Node<T>(value);
            size++;
            return;
        }

        int order = _ascending ? -1 : 1;
        Node temp = this.head;
        size++;
        while (temp != null) {
            if ((compare(value, (T) temp.value) == 0 || compare(value, (T) temp.value) == -1 * order))
                temp = temp.next;
            else {
                Node insert = new Node(value);
                if (this.head != temp) {
                    insert.prev = temp.prev;
                    temp.prev.next = insert;
                } else {
                    this.head = insert;
                }
                insert.next = temp;
                temp.prev = insert;
                return;
            }
        }
        Node insert = new Node(value);
        this.tail.next = insert;
        insert.prev = this.tail;
        this.tail = insert;
    }

    public Node<T> find(T val) {

        if (size == 0)
            return null;

        Node temp = this.head;
        int order = _ascending ? -1 : 1;
        if (_ascending) {
            while (temp != null && (compare(val, (T) temp.value) == 0 || compare(val, (T) temp.value) == -1 * order)) {
                if (temp.value.equals(val))
                    return temp;
                else
                    temp = temp.next;
            }
        }
        return null;
    }

    public void delete(T val) {
        Node current = this.head;
        while (current != null) {
            if (current.value.equals(val)) {
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
                size--;
                break;
            }
            current = current.next;
        }
    }

    public void clear(boolean asc) {
        _ascending = asc;
        this.head = null;
        this.tail = null;
        size = 0;
    }

    public int count() {
        return size;
    }

    ArrayList<Node<T>> getAll() {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while (node != null) {
            r.add(node);
            node = node.next;
        }
        return r;
    }
}
