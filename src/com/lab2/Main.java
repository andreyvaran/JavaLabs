package com.lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        String exper = new String("(({}()[]))/*oguhetz*/");
        System.out.println(exper);
        System.out.println(Tasks.bracketSequence(exper));

        String exper1 = new String("1+3*4-7");
        List<String> s1 = new ArrayList<String>(Collections.singleton(exper1));
        System.out.println(s1);

    }
}
