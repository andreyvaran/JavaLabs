package com.lab2;
import java.util.Arrays;

public class StackOnArray<T> implements Stack<T> {
    //    Стек на основе Массива
    private int _size;
    private Object[] _stackArray;
    private int top;

    public StackOnArray(int m) {
        this._size = m;
        this._stackArray = new Object[_size];
        this.top = -1;
    }

    public StackOnArray() {
        this._stackArray = new Object[_size];
        this.top = -1;
    }

    public int size() {
        return this._size;
    }

    public void add(T element) {
        if (isFull()) {
            System.out.println("it is impossible to add , the stack is already full");
        } else {
            top++;
            _stackArray[top] = element;
        }
    }


    public T pop() throws NullPointerException {
        T temp;
        if (top == -1) {
            throw new NullPointerException("Nothing to pop");
        }
        return (T) _stackArray[top--];

    }

    public T get() {
        if (top != -1) {
            return (T) _stackArray[top];
        } else {
            System.out.println("Nothing to get");
            return null;
        }
    }
    public int get100(){
        return 100;
    }


    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == _size - 1);
    }

    @Override
    public String toString() {
        return "StackOnArray{" +
                "_size=" + _size +
                ", _stackArray=" + Arrays.toString(_stackArray) +
                ", top=" + top +
                '}';
    }
}

