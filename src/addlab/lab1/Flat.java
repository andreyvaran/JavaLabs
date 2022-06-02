package addlab.lab1;

import java.util.Objects;

public class Flat implements Comparable<Flat> {

    private int rooms;
    private float square;

    public Flat(int rooms, float square) {
        this.rooms = rooms;
        this.square = square;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public float getSquare() {
        return square;
    }

    public void setSquare(float square) {
        this.square = square;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flat flat = (Flat) o;
        return rooms == flat.rooms && Float.compare(flat.square, square) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rooms, square);
    }

    @Override
    public String toString() {
        return "Flat{" +
                "rooms=" + rooms +
                ", square=" + square +
                '}';
    }

    @Override
    public int compareTo(Flat o) {
        if (square > o.getSquare()) {
            return 1;
        } else if (square < o.getSquare()) {
            return -1;
        } else {
            return 0;
        }
    }
}
