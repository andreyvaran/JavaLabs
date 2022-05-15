package com.lab5;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BusesTest {
    Buses buses = new Buses();
    String[] s = {"london","moscow"};
    String[] s1 = {"london","paris"};
    String[] s2 = {"paris" , "amsterdam" , "rostov"};


    @Test
    void addBus() throws Exception {
        String[] s1 = {"london","paris"};
        buses.addBus("72",s1);
        try {
            buses.addBus("72", s1);
        }
        catch (Exception e){
            assertEquals(e.getMessage(),"Already exists for 1");
        }
    }

    @Test
    void stopsForBus() throws Exception {
        buses.addBus("71",s);
        buses.addBus("72",s1);
        buses.addBus("100" , s2);
        Set<Integer> k = new HashSet<>();
        k.add(2);
        assertEquals(buses.stopsForBus("71").get("london"),
                k);
        try {
            buses.stopsForBus("75");
        }
        catch (Exception e){
            assertEquals(e.getMessage(),"No bus");
        }

    }

    @Test
    void nbusesForStop() throws Exception {
        buses.addBus("71",s);
        buses.addBus("72",s1);
        buses.addBus("100" , s2);
        Set<Integer> k = new HashSet<>();
        k.add(1);
        k.add(2);
        assertEquals(buses.nbusesForStop("london") , k);
        try {
            buses.nbusesForStop("odessa");
        }
        catch (Exception e){
            assertEquals(e.getMessage(),"No stop");
        }
    }

    @Test
    void sbusesForStop() throws Exception {
        buses.addBus("71",s);
        buses.addBus("72",s1);
        buses.addBus("100" , s2);
        List<String> k = List.of(new String[]{"71", "72"});
        assertEquals(buses.sbusesForStop("london"), k);

    }


}