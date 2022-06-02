package addlab.lab1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HouseTest {
    House test = new House();
    @Test
    void addFlat() {
        Flat f = new Flat(5,5);
        test.addFlat(f);
        assertEquals(test.getCountFlats() , 1);
    }

    @Test
    void addFlats() {
        ArrayList<Flat> temp = new ArrayList<>();
        temp.add(new Flat(5,6));
        temp.add(new Flat(4,6));
        temp.add(new Flat(3,6));
        temp.add(new Flat(2,6));
        temp.add(new Flat(1,6));

        test.addFlats(temp);
        assertEquals(test.getCountFlats() , 5);


    }


}