package com.lab2;

public interface Stack<T>{
    void add(T element);
    T pop();
    T get();
    int size();

    boolean isEmpty();
    boolean isFull();

}