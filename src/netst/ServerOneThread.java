package netst;

import java.io.*;
import java.net.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Данный класс реализует взаимодействие сервера с одним
 * клиентом, создавая для него поток и  завершая его,
 * после получения от клиента сообщения о завершении сеанса работы
 */
public class ServerOneThread extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private int count;

    public ServerOneThread(Socket s , int c) throws IOException {
        socket = s;// получение сокета для обмена данными
        count = c;
        in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(
                new BufferedWriter(new OutputStreamWriter(
                        socket.getOutputStream())), true);
// Если какой либо, указанный выше класс выбросит исключение 
// вызывающая процедура ответственна за закрытие сокета
// В противном случае нить(поток) закроет его.
        start();
    }

    public void run() {
        try {
            out.println("Hello! Enter END to exit.");
            boolean done = true;
            UserList temp = new UserList();
            out.println("enter name ");
            String name = in.readLine();

            temp.addUser(name);
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            System.out.println(dateFormat.format(date));

            out.printf("Привет - %s! Сейчас время на серере -%s\n", name ,date );
            out.printf("Количество подключенных юзеров: %d", this.count);
            while (done) {
//        String str = in.readLine();
                String str = in.readLine();

                out.println();


//        Человек може
                if (str.equals("BYE")) {
                    out.println("close");
                    done = false;
                    Thread.currentThread().interrupt();
                } else {
                    System.out.println("Echoing: " + str);
                    out.println("ECHO:" + str);
                }
            }
        } catch (IOException e) {
            System.err.println("IO Exception");
        } finally {
            try {
                System.out.println("closing...");
                socket.close();
            } catch (IOException e) {
                System.err.println("Socket not closed");
            }
        }
    }
}
   
