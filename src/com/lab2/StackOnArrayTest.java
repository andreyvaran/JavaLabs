package com.lab2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackOnArrayTest {
    Stack st = new StackOnArray(4);

    @Test
    void size() {
        Stack st = new StackOnList(123);
        assertEquals(st.size(), 123);
        Stack st1 = new StackOnList();
        assertEquals(st1.size(), 16);
//        assertEquals(st1.size() ,11);
    }

    @Test
    void add() {
        st.add("qwe");
        st.add(123);
        st.add(123.45f);
        st.add("asdasd");
        try {
            st.add(3);
        }
        catch (StackOverflowError e) {
            assertTrue(1==1);
        }

    }

    @Test
    void pop() {
        try {
            st.pop();
        } catch (NullPointerException e) {
            assertTrue(1 == 1);
        }
        st.add(123.45f);
        Object f = st.pop();
        assertEquals(123.45f, f);
    }

    @Test
    void get() {

        st.add(123.45f);
        Object f = st.get();
        assertEquals(123.45f, f);
    }

    @Test
    void isEmpty() {
        assertTrue(st.isEmpty() == true);
        st.add(123);
        assertTrue(st.isEmpty() == false);
    }

    @Test
    void isFull() {
        st.add("qwe");
        assertTrue(st.isFull() == false);
        st.add(123);
        st.add(123.45f);
        st.add("asdasd");
        assertTrue(st.isFull() == true);
    }
}