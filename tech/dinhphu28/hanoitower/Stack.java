package tech.dinhphu28.hanoitower;

public class Stack<T> implements Cloneable{
    private Object[] arr;
    private int capacity;
    private int top;

    public Stack(int size) {
        arr = new Object[size];
        capacity = size;
        top = -1;
    }

    public void push(T value) {
        if(isFull()) {
            throw new RuntimeException("Stack Overflow");
        }

        arr[++top] = value;
    }

    public T pop() {
        if(isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return (T) arr[top--];
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public boolean isFull() {
        return top == (capacity - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i <= top; i++) {
            if(i > 0) {
                res.append(" ");
            }
            res.append(arr[i]);
        }

        return res.toString();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Stack<T> clone() throws CloneNotSupportedException {
        Stack<T> stack = (Stack<T>) super.clone();
        stack.arr = stack.arr.clone();

        return stack;
    }
}
