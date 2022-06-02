package addlab.lab1;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        House h = new House();
        for (int i = 0; i < 11; i++) {

            float area = new Random().nextFloat();
            Flat f = new Flat((i+1) % 5 ,area*10 );
            System.out.println(f);
            h.addFlat(f);

        }
        System.out.println(h);
        System.out.println(h.getInfo());
        System.out.println(h.getGreatestInAreaFlats(4));
    }

}
