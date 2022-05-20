package com.lab3;

public class Main {

    public static void main(String[] args) {
        Letters list = new Letters("abcbcdefgh");
        Letters list1 = new Letters("b");
//        list.retainAll(list1);
        System.out.println(list);
        System.out.println(list.hashCode());
        Object[] temp = list.toArray();
        for (Object i : temp){
            System.out.print(i);
        }

    }
}
