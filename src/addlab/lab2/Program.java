package addlab.lab2;


import java.io.File;
import java.util.ArrayList;

public class Program {
    static MyTread one_tread;
    static MyTread second_tread;
    static MyTread third_tread;
    static MyTread fourth;

    public static void main(String[] args) {


        System.out.println("Work with 1 thread ");
        long time_to_1 = System.currentTimeMillis();

        File dir1 = new File("src/addlab/lab2/fiels");
        one_tread = new MyTread("one thread");

        second_tread = new MyTread("one thread");

        third_tread = new MyTread("third thread");

        fourth = new MyTread("fourth thread");
        if (dir1.isDirectory()) {
            File[] arrFiles = dir1.listFiles();
            assert arrFiles != null;
            for (File t : arrFiles) {
//                System.out.println(t.getPath());
                one_tread = new MyTread("one thread" );
                one_tread.start_with_path(t.getPath());
                while (one_tread.isAlive()){}
                one_tread.interrupt();

//                new MyTread("one thread" + t.getPath() , t.getPath()).start();

            }
        }

        System.out.printf("The time for it is ");
        System.out.println(System.currentTimeMillis() - time_to_1);
        time_to_1 = System.currentTimeMillis() - time_to_1;

// ------------------------------------------------------------------------------------------------------------------------
        long time_to_2 = System.currentTimeMillis();
        System.out.println("Work with 2 thread ");
        if (dir1.isDirectory()) {
            File[] arrFiles = dir1.listFiles();
            for (int i = 0; i < 4; i++) {
                if (one_tread == null){
                    one_tread = new MyTread("one thread");

                }
                if (second_tread == null){
                    second_tread = new MyTread("one thread");

                }

                if (! one_tread.isAlive()) {
                    one_tread = new MyTread("one thread");
                    assert arrFiles != null;
                    one_tread.start_with_path(arrFiles[2*i].getPath());
                }

                if (! second_tread.isAlive()) {
                    second_tread = new MyTread("second thread");
                    assert arrFiles != null;
                    second_tread.start_with_path(arrFiles[2*i+1].getPath());
                }
//                Таким образом я избавляют от гонки потоков , по умному это сделать не получилось

                while (one_tread.isAlive() || second_tread.isAlive()){}
                one_tread.interrupt();
                second_tread.interrupt();

            }
        }


        System.out.printf("The time for it is ");
        System.out.println(System.currentTimeMillis() - time_to_2);
        time_to_2 = System.currentTimeMillis() - time_to_2;
// ------------------------------------------------------------------------------------------------------------------------
        long time_to_4 = System.currentTimeMillis();
        System.out.println("Work with 2 thread ");
        if (dir1.isDirectory()) {
            File[] arrFiles = dir1.listFiles();
            for (int i = 0; i < 2; i++) {

                if (! one_tread.isAlive()) {
                    one_tread = new MyTread("one thread");
                    assert arrFiles != null;
                    one_tread.start_with_path(arrFiles[4*i].getPath());
                }
                if (! second_tread.isAlive()) {
                    second_tread = new MyTread("second thread");
                    assert arrFiles != null;
                    second_tread.start_with_path(arrFiles[4*i+1].getPath());
                }

                if (! third_tread.isAlive()) {
                    third_tread = new MyTread("third thread");
                    assert arrFiles != null;
                    third_tread.start_with_path(arrFiles[4*i+2].getPath());
                }
                if (! fourth.isAlive()) {
                    fourth = new MyTread("fourth thread");
                    assert arrFiles != null;
                    fourth.start_with_path(arrFiles[4*i+3].getPath());
                }

                while (one_tread.isAlive() || second_tread.isAlive() || third_tread.isAlive() || fourth.isAlive()){}
                one_tread.interrupt();
                second_tread.interrupt();
                third_tread.interrupt();
                fourth.interrupt();

            }
        }


        System.out.printf("The time for it is ");
        System.out.println(System.currentTimeMillis() - time_to_4);
        time_to_4 = System.currentTimeMillis() - time_to_4;
// ------------------------------------------------------------------------------------------------------------------------
        System.out.println("Work with 8 thread ");
        long time_to_8 = System.currentTimeMillis();
        ArrayList<MyTread> temp = new ArrayList<>();
        if (dir1.isDirectory()) {
            File[] arrFiles = dir1.listFiles();
            for (File t : arrFiles) {
//                System.out.println(t.getPath());
//                one_tread = new MyTread("one thread" );
//                one_tread.start_with_path(t.getPath());
//                while (one_tread.isAlive()){}
//                one_tread.interrupt();
                MyTread k = new MyTread("one thread" + t.getPath());
                temp.add(k);
                k.start_with_path(t.getPath());

            }
        }


        while (temp.stream().anyMatch(Thread::isAlive)){
        }
        System.out.printf("The time for it is ");
        System.out.println(System.currentTimeMillis() - time_to_8);
        time_to_8 = System.currentTimeMillis() - time_to_8;


        System.out.println();

        System.out.println("Time to read all files with 1 tread is " + time_to_1);
        System.out.println("Time to read all files with 2 tread is " + time_to_2);
        System.out.println("Time to read all files with 4 tread is " + time_to_4);
        System.out.println("Time to read all files with 8 tread is " + time_to_8);
//        System.out.println("Main thread started...");
//        new MyTread("JThread").start();
//        System.out.println("Main thread finished...");
    }
}