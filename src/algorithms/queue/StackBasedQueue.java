package algorithms.queue;

import java.util.*;

public class StackBasedQueue<T> {

    private Stack<T> actual;
    private Stack<T> temp;

    public StackBasedQueue() {
        actual = new Stack<>();
        temp = new Stack<>();
    }

    public void enqueue(T item) {
        if (actual.size() == 0)
            temp.push(item);
        else
            actual.push(item);
    }

    public T dequeue() {
        if (actual.size() == 0) {
            while (temp.size() > 0)
                actual.push(temp.pop());
            return actual.pop();
        } else {
            while (actual.size() > 0)
                temp.push(actual.pop());
            return temp.pop();
        }

    }

    public int size() {
        return actual.size() == 0 ? temp.size() : actual.size();
    }

}