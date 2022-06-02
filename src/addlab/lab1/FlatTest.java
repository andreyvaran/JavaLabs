package addlab.lab1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlatTest {
    Flat test = new Flat(5 , 123);
    Flat test2 = new Flat(4 , 122);
    @Test
    void getRooms() {
        assertEquals(5 , test.getRooms());
    }

    @Test
    void setRooms() {
        test2.setRooms(5);
        assertEquals(5, test2.getRooms());
    }

    @Test
    void getSquare() {
        assertEquals(123, test.getRooms());
    }

    @Test
    void setSquare() {
        test.setSquare(234);
        assertEquals(234 , test.getSquare());
    }

    @Test
    void testEquals() {
        Flat temp = new Flat(5 , 123);
        assertEquals(test, temp);
        assertNotEquals(test2,temp );

    }

}