package com.lab1;

public class Main {
    public static void main(String[] args) {
        Graph roads = new Graph(9);
//        СОздаем граф по заданию
        int[] t1 = new int[]{3};
        int[] t2 = new int[]{4, 8};
        int[] t3 = new int[]{5};
        int[] t4 = new int[]{6, 1};
        int[] t5 = new int[]{};
        int[] t6 = new int[]{5};
        int[] t7 = new int[]{6, 3};
        int[] t8 = new int[]{7, 1};

        roads.addEdges(1, t1);
        roads.addEdges(2, t2);
        roads.addEdges(3, t3);
        roads.addEdges(4, t4);
        roads.addEdges(5, t5);
        roads.addEdges(6, t6);
        roads.addEdges(7, t7);
        roads.addEdges(8, t8);
        int start = 2;
        int end = 7;
//        roads.addEdge(8,5);
        //  Я не понял алгоритм который был в ворде решил просто сделать БФС по графу для  получения ответа

        System.out.println("Roads from "+ start + " to " + end + " = "+roads.countPaths(start, end));
        System.out.println(roads);


    }
}

