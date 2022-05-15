package com.lab5;

import java.util.*;
import java.util.stream.Collectors;

class Route {
    public int id;
    public String name;
    public String[] stops;

    Route(String name, int id, String[] stops) {
        this.id = id;
        this.name = name;
        this.stops = stops;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        return stops != null ? stops.equals(route.stops) : route.stops == null;
    }

    @Override
    public int hashCode() {
        return stops != null ? stops.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stops=" + Arrays.toString(stops) +
                '}';
    }
}


class Buses {
    public List<Route> routes;

    public Buses() {
        routes = new ArrayList<>();
    }

    /**
     * @param name  Название
     * @param stops Массив остановок
     * @return id автобуса
     * @throws Exception выбрасывается если уже присутствует автобус с таким именем
     */
    public int addBus(String name, String[] stops) throws Exception {
        List<Route> route = routes.stream().filter(x -> x.stops.equals(stops)).collect(Collectors.toList());

        if (!route.isEmpty()) {
            throw new Exception("Already exists for " + route.get(0).id);
        }

        int id = routes.size() + 1;
        routes.add(new Route(name, id, stops));
        return id;
    }

    /**
     * Выдает названия всех остановок автобуса заданного названия,
     * для каждой остановки задается множество номеров автобусов, на которые можно пересесть.
     *
     * @param name название автобуса
     * @return множество остановок на которых можно пересесть на автобусы
     * @throws Exception Если такого автобуса нет, выбрасывается исключение с текстом No bus.
     */
    public Map<String, Set<Integer>> stopsForBus(String name) throws Exception {
        List<Route> routesLocal = routes.stream().filter(x -> x.name.equals(name)).collect(Collectors.toList());
        // Если не нашлось найти автобус с нужным именем то выбрасываем ошибку
        if (routesLocal.isEmpty()) {
            throw new Exception("No bus");
        }

        Route route = routesLocal.get(0);
        Map<String, Set<Integer>> stopsForBusLocal = new HashMap<>();
        for (int i = 0; i < route.stops.length; i++) {

            String currentStop = route.stops[i];
            Set<Integer> routesForSwitching = routes
                    .stream().filter(x -> {
                        for (int j = 0; j < x.stops.length; j++) {
                            if (x.stops[j].equals(currentStop)) {
                                return true;
                            }
                        }
                        return false;
                    }).map(y -> y.id).collect(Collectors.toSet());
            routesForSwitching.remove(route.id);
            stopsForBusLocal.put(currentStop, routesForSwitching);

        }
        return stopsForBusLocal;
    }

    /**
     *
     * @param nameStop название остановки
     * @return Массив всех Route  в которых встречается данная остановка
     * @throws Exception Если через остановку нет маршрутов, выбрасывается исключение с текстом No stop.
     */
    private List<Route> russesForStop(String nameStop) throws Exception {
        List<Route> routesForStop = routes.stream()
                .filter(x -> !Arrays.stream(x.stops)
                        .filter(y -> y.equals(nameStop))
                        .collect(Collectors.toList()).isEmpty()).collect(Collectors.toList());
        if (routesForStop.isEmpty()) {
            throw new Exception("No stop");
        }
        return routesForStop;
    }

    /**
     * @param nameStop название остановки
     * @return Номера всех маршрутов проходящих через nameStop
     * @throws Exception Если через остановку нет маршрутов, выбрасывается исключение с текстом No stop.
     */
    public Set<Integer> nbusesForStop(String nameStop) throws Exception {
        List<Route> routesForStopLocal = russesForStop(nameStop);
        return routesForStopLocal.stream().map(x -> x.id).collect(Collectors.toSet());
    }

    /**
     * @param nameStop Название остановки
     * @return список названий всех маршрутов автобусов, проходящих через остановку nameStop в том порядке, в котором они создавались
     * @throws Exception Если через остановку нет маршрутов, выбрасывается исключение с текстом No stop.
     */
    public List<String> sbusesForStop(String nameStop) throws Exception {
        List<Route> routesForStopLocal = russesForStop(nameStop);
        System.out.println(routesForStopLocal);
        return routesForStopLocal.stream().map(x -> x.name).collect(Collectors.toList());
    }

    /**
     * Bыдает список названий всех маршрутов автобусов  в алфавитном порядке
     * @return
     * @throws Exception
     */
    public List<String> allBuses() throws Exception {
        List<String> names = routes.stream().map(x -> x.name).collect(Collectors.toList());
        if (names.isEmpty()) throw new Exception("No buses ");
        Collections.sort(names);
        return names;
    }

    @Override
    public String toString() {
        return "Buses{" +
                "routes=" + routes +
                '}';
    }
}

