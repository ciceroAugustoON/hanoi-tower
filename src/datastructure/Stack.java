package datastructure;

import java.util.EmptyStackException;

public class Stack<T> {
    private Node<T> top;
    private int lenght;
    
    public Stack(){}

    public void push(T data) {
        Node<T> newNode = new Node<T>(data);
        newNode.next = top;
        top = newNode;

        lenght++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        T removedValue = top.data;
        top = top.next;

        lenght--;

        return removedValue;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException(); 
        }

        return top.data;
    }

    public int lenght() {
        return lenght;
    }

    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public String toString() {
        String str = "";
        Node<T> current = top;
        while (current != null) {
            str += current.data + "\n";
            current = current.next;
        }
        return str;
    }
}
