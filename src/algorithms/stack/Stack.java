package algorithms.stack;

import java.util.*;

public class Stack<T>
{
    private int size;
    private Node<T> tail;

    public Stack()
    {
       this.tail = null;
       this.size = 0;
    }

    public int size()
    {
        return this.size;
    }

    public T pop()
    {
       if (this.size == 0)
           return null;

        this.size--;
        T temp = this.tail.value;
        this.tail = tail.prev;
        return temp;
    }

    public void push(T val)
    {
        this.size++;
        Node<T> temp = this.tail;
        this.tail = new Node<>(val, temp);
    }

    public T peek()
    {
        return this.size == 0 ? null : this.tail.value;
    }

}

class Node <T> {
    Node prev;
    T value;

    public Node(T value, Node prev){
        this.value = value;
        this.prev = prev;
    }
}