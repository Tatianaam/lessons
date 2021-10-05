package queue;

import java.util.*;

public class Queue<T> {

    private LinkedList<T> list;

    public Queue() {
        list = new LinkedList<>();
    }

    public void enqueue(T item) {
        list.addLast(item);
    }

    public T dequeue() {
        return list.size() == 0 ? null : list.removeFirst();
    }

    public int size() {
        return list.size();
    }

    public void rotateQueueForN(int n) {
        while (n > 0) {
            this.enqueue(this.dequeue());
            n--;
        }
    }

}