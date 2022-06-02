package addlab.lab1;

import java.util.Comparator;

public class FlatAreaComparator implements Comparator<Flat> {
    @Override
    public int compare(Flat o1, Flat o2) {
        return o1.compareTo(o2);
    }
}
