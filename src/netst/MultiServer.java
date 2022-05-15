package netst;

import java.io.*;
import java.net.*;


  public class MultiServer {  
  static final int PORT = 8189;
  public static int count = 0;
  public static void main(String[] args)throws IOException {
    ServerSocket s = new ServerSocket(PORT);
    System.out.println("Server Started");

    try {
      while(true) {
        count ++;
// Останавливаем выполнение, до нового соединения:
        System.out.printf("On server %s", count);
        Socket socket = s.accept();
        try {
          new ServerOneThread(socket, count);

        } catch(IOException e) {
// Если неудача - закрываем сокет,
// в противном случае нить закроет его:
          socket.close();
        }
      }
    } finally {
        
      s.close();
    }
  }
}
