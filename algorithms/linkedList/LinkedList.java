package com.company;

import java.util.*;

public class LinkedList
{
    public Node head;
    public Node tail;

    public LinkedList()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
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
        Node previous = null;
        Node current = this.head;

        while (current != null) {
            if (current.value == _value) {
                if (this.head == current) {
                    this.head = current.next;
                    if (this.tail == current)
                        this.tail = null;
                } else {
                    if (current.next != null) {
                        current.value = current.next.value;
                        current.next = current.next.next;
                    } else {
                        previous.next = null;
                        this.tail = previous;
                    }
                }
                result = true;
                break;
            }
            previous = current;
            current = current.next;
        }
        return result;
    }

    public void removeAll(int _value)
    {
        Node previous = null;
        Node current = this.head;

        while (current != null) {
            if (current.value == _value) {
                if (this.head == current) {
                    this.head = current.next;
                    if (this.tail == current)
                        this.tail = null;
                } else {
                    if (current.next != null) {
                        previous.next = current.next;
                    } else {
                        previous.next = null;
                        this.tail = previous;
                        break;
                    }
                }
                current = current.next;
            } else {
                previous = current;
                current = current.next;
            }
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
            if (this.tail == _nodeAfter)
                this.tail = _nodeToInsert;
        } else {
            _nodeToInsert.next = node;
            this.head = _nodeToInsert;
        }
    }

}

class Node
{
    public int value;
    public Node next;
    public Node(int _value)
    {
        value = _value;
        next = null;
    }
}
