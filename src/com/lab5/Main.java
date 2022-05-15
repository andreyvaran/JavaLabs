package com.lab5;

import java.util.*;
import java.util.stream.Collectors;

class Main{
    public static void main(String[] args) throws Exception{
        Buses buses = new Buses();
        String[] s = {"london","moscow"};
        buses.addBus("71",s);
        String[] s1 = {"london","paris"};
        buses.addBus("72",s1);
        String[] s2 = {"paris" , "amsterdam" , "rostov"};
        buses.addBus("100" , s2);
        System.out.println(buses);
        buses.sbusesForStop("london");
        Map<String,Set<Integer>> stops = buses.stopsForBus("71");
        System.out.println(stops);
    }
}
