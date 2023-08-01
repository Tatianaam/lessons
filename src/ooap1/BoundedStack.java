package ooap1;

import java.util.ArrayList;
import java.util.List;

public class BoundedStack<T> {

    // скрытые поля
    private List<T> stack; // основное хранилище стека
    private int peek_status; // статус запроса peek()
    private int pop_status; // статус команды pop()
    private int push_status; // статус команды push()
    private int capacity; // размер стека

    // интерфейс класса, реализующий АТД Stack
    public final static int POP_NIL = 0;
    public final static int POP_OK = 1;
    public final static int POP_ERR = 2;
    public final static int PEEK_NIL = 0;
    public final static int PEEK_OK = 1;
    public final static int PEEK_ERR = 2;
    public final static int PUSH_NIL = 0;
    public final static int PUSH_OK = 1;
    public final static int PUSH_ERR = 2;
    public final static int DEFAULT_SIZE = 32;

    // конструктор
    public BoundedStack() {
        this.capacity = DEFAULT_SIZE;
        clear();
    }

    public BoundedStack(int capacity) {
        this.capacity = capacity;
        clear();
    }

    public void push(T value) {
        if (size() < capacity) {
            stack.add(value);
            push_status = PUSH_OK;
        } else {
            push_status = PUSH_ERR;
        }
    }

    public void pop() {
        if (size() > 0) {
            stack.remove(stack.size() - 1);
            pop_status = POP_OK;
        } else {
            pop_status = POP_ERR;
        }
    }

    public void clear() {
        // пустой список/стек
        stack = new ArrayList(this.capacity);

        // начальные статусы для предусловий peek() и pop()
        peek_status = PEEK_NIL;
        pop_status = POP_NIL;
        push_status = PUSH_NIL;
    }


    public T peek() {
        T result;
        if (size() > 0) {
            result = stack.get(stack.size() - 1);
            peek_status = PEEK_OK;
        } else {
            result = null;
            peek_status = PEEK_ERR;
        }
        return result;
    }

    public int size() {
        return stack.size();
    }

    // запросы статусов
    public int get_pop_status() {
        return pop_status;
    }

    public int get_peek_status() {
        return peek_status;
    }

}
