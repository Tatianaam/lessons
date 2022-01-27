package algorithms.queue;

import java.util.*;

public class Deque<T> {
    private LinkedList<T> list;

    public Deque() {
        list = new LinkedList<>();
    }

    public void addFront(T item) {
        list.addFirst(item);
    }

    public void addTail(T item) {
        list.addLast(item);
    }

    public T removeFront() {
        return list.size() == 0 ? null : list.removeFirst();
    }

    public T removeTail() {
        return list.size() == 0 ? null : list.removeLast();
    }

    public int size() {
        return list.size();
    }

    public boolean isPalindrome(String str) {
        Deque deque = new Deque();
        for (int i = 0; i < str.length(); i ++){
            deque.addTail(str.charAt(i));
        }
        while (deque.size() > 1) {
            if (!deque.removeFront().equals(deque.removeTail()))
                return false;
        }
        return true;
    }
}