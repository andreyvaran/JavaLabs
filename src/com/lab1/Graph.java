package com.lab1;

import java.util.*;

/**
 * Представление графа списками смежности основанного на Map.
 */
public class Graph {
    private final Map<Integer, ArrayList> lGraph;// Списки смежности
    private final int nVertex;            // Число вершин

    /**
     * Конструктор пустого графа с заданным числом вершин
     * @param nVert Число вершин
     */
    public Graph(int nVert) {
        lGraph = new HashMap<>();// Списки смежности
        for (int i = 0; i < nVert; ++i) {
            lGraph.put(i, new ArrayList());
        }
        nVertex = nVert;
    }

    /**
     * @return Число вершин графа
     */
    public int getCount() {
        return nVertex;
    }

    /**
     * @param from Откуда идет дуга (номер вершины)
     * @param to   Массив куда дуги приходят (номера вершин)
     */
    public void addEdges(int from, int[] to) {
        assert from < nVertex && from >= 0;
        for (int i : to) {
            assert i < nVertex && i >= 0;
            lGraph.get(from).add(i);
            System.out.println(from + " to = " + i
            );
        }
    }

    public void addEdge(int from, int to) {
        assert from < nVertex && from >= 0;
        assert to < nVertex && to >= 0;
        lGraph.get(from).add(to);
        System.out.println(from + " to " + to);
    }



    /**
     * Данная версия не работает тк она не рассматривает все возможные пути :(
     * Идея была в том что бы создать массив тех вершин которые нужно посетить , уже посещенных и идти по вершинам
     * добавляя
     *
     * @param from Из какой вершины ищем путь
     * @param to   В какую вершину
     * @return количество путей
     */
    public int countRoads(int from, int to) {
        assert from < nVertex && from >= 0;
        assert to < nVertex && to >= 0;
        int[] array = new int[this.nVertex];
        for (int i = 1; i < nVertex - 1; i++) {
            array[i] = 0;
            if (i == from) {
                array[i] = 1;
            }

        }

        printArray(array);
        ArrayList<Integer> to_visit = new ArrayList(nVertex);
        ArrayList<Integer> visited = new ArrayList(nVertex);
        to_visit.add(from);
        int cur;
        while (!to_visit.isEmpty()) {
            cur = to_visit.get(0);
            System.out.println("cur " + cur);
            for (Object i : lGraph.get(cur)) {
                if (visited.indexOf(i) == -1) {
//                    Если мы уже посещали город , то пропускаем его
                    to_visit.add((Integer) i);
                    array[(int) i] += array[cur];
                }
            }
            printArray(array);
            to_visit.remove(0);
            visited.add(cur);
        }
        printArray(array);
        return 1;
    }

    /**
     * Попробуем идею модернезировать тем что будем считать рекурсивно все возможные пути
     * и добавлять только те которые нам подходят
     *
     * @param cur       нынешняя вершина
     * @param finish
     * @param visited   уже пройденные вершины
     * @param pathCount количество путей
     * @return pathCount
     */
    int countPathsUtil(int cur, int finish, boolean visited[], int pathCount) {
        visited[cur] = true;
//        System.out.print(cur + "  ");
//        printArray(visited);
        if (cur == finish) {
            pathCount++;
        } else {
            ArrayList i = (ArrayList) lGraph.get(cur).clone();
            while (!i.isEmpty()) {
                int n = (int) i.get(0);
                if (!visited[n]) {
                    pathCount = countPathsUtil(n, finish,
                            visited,
                            pathCount);
                }
                i.remove(0);
            }
        }
        visited[cur] = false;
        return pathCount;

    }

    /**
     * @param start Начальная вершина
     * @param end Конечная вершина
     * @return
     */
    int countPaths(int start, int end) {
        boolean visited[] = new boolean[nVertex];
        Arrays.fill(visited, false);
        int pathCount = 0;

        pathCount = countPathsUtil(start, end, visited, pathCount);
        return pathCount;
    }


    private void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(' ');
            System.out.print(i);
        }
        System.out.println();
    }

    private void printArray(boolean[] arr) {
        for (boolean i : arr) {
            System.out.print(' ');
            System.out.print(i);
        }
        System.out.println();
    }


    @Override
    public String toString() {
        return "Graph{" +
                "lGraph=" + lGraph +
                ", nVertex=" + nVertex +
                '}';
    }
}

