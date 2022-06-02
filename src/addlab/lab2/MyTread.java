package addlab.lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MyTread extends Thread {
    private String path;

    MyTread(String name ){
        super(name);


    }
    public synchronized void start_with_path(String path){
        this.path = path;
        start();
    }

    public synchronized void run(){

        System.out.printf("%s started... \n", Thread.currentThread().getName());
        File temp = new File(this.path);
        if (temp.isFile()){
            System.out.printf("we are reading file: %s \n" , this.path);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            FileReader fr= null;
            try {
                fr = new FileReader(this.path);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Scanner scan = new Scanner(fr);
            int count = 0;
            while (scan.hasNextLine()){
                for( Character c : scan.nextLine().toCharArray()){
                    count++;

                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("Thread has been interrupted");
                    e.printStackTrace();

                }
            }
            System.out.printf("Total symbol is %d in %s \n", count , this.path);

        }

        System.out.printf("%s fiished... \n", Thread.currentThread().getName());
    }
}
