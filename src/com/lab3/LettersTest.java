package com.lab3;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class LettersTest {
    Letters list = new Letters("1234");
    Letters list1 = new Letters("b");

    @Test
    void size() {
        assertEquals(list.size(), 4);
    }

    @Test
    void isEmpty() {
        Letters list = new Letters();
        assertTrue(list.isEmpty());
        list.add('h');
        assertFalse(list.isEmpty());

    }

    @Test
    void contains() {

    }

    @Test
    void testEquals() {
        Letters list2 = new Letters("qwertyuiop");
        Letters list3 = new Letters("qwertyuiop");
        assertTrue(list2.equals(list3));
        assertFalse(list2.equals(list1));
    }

    @Test
    void iterator() {
        Letters list1 = new Letters("1234");
        Iterator temp = list1.iterator();
        Character[] temp2 = list1.toArray();
        int c = 0;
        while (temp.hasNext()) {
            assertEquals(temp2[c++], temp.next());
//            c++;
        }

    }

    @Test
    void adds() {
        Letters list2 = new Letters("qwe");
        Letters t = new Letters("100");
        list2.addStr("123");
        list2.add('q');
        list2.addAll(t);
        assertEquals(list2.toString(), "qwe123q100");

    }

    @Test
    void remove() {
        Letters list2 = new Letters("qwe");
        list2.remove("qwe");
        list2.remove('z');

    }


    @Test
    void retainAll() {
        Letters list = new Letters("abcbcdefgh");
        Letters list1 = new Letters("b");
        list.retainAll(list1);
        assertEquals(list.toString(), "bb");
    }

    @Test
    void clear() {
        Letters list = new Letters("abcbcdefgh");
        list.clear();
        assertTrue(list.isEmpty());
    }
}