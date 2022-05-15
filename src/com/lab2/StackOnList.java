package com.lab2;

import java.util.ArrayList;

public class StackOnList<T> implements Stack<T> {
    //    Стек на основе Списка Из плюсов : можно добавлть разные типы данных
    private int _size = 16;
    private ArrayList<T> _stackArray;
    private int top;

    /**
     *
     * @param m размер стека
     */
    public StackOnList(int m) {
        this._size = m;
        _stackArray = new ArrayList<T>(_size);
        top = -1;
    }

    /**
     *  Конструктор с изначальным значением
     */
    public StackOnList() {
        _stackArray = new ArrayList<T>();
        top = -1;
    }

    public int size() {
        return this.top;
    }

    public void add(T element) throws StackOverflowError{
        if (isFull()) {
            throw new StackOverflowError("it is impossible to add , the stack is already full");
//            System.out.println("it is impossible to add , the stack is already full");
        } else {
            top++;
            _stackArray.add(element);
        }
    }


    public T pop() throws NullPointerException {
        T temp;
        if (top == -1) {
            throw new NullPointerException("Nothing to pop");
        }
        temp = _stackArray.remove(top);
        top--;
        return temp;
    }

    public T get(){
        if (top != -1) {
            return _stackArray.get(top);
        } else {
//            throw new NullPointerException("Nothing to get");
            System.out.println("Nothing to get");
            return null;
        }
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == _size - 1);
    }

//    @Override
//    public String toString() {
//        return "StackOnList{" +
//                "_size=" + _size +
//                ", _stackArray=" + _stackArray +
//                ", top=" + top +
//                '}';
//    }

    @Override
    public String toString() {
        return ""+ _stackArray;
    }
}
