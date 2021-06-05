

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class server {


     static ServerSocket server;
     static  Socket socket;
     static int port = 9876;
    static ObjectInputStream ois;
    static ObjectOutputStream oos;
    static InetAddress host;



    static void init() throws IOException {
        server = new ServerSocket(port);
    }



    static void sendmsg(Object obj) throws IOException {
        socket = server.accept();
        oos = new ObjectOutputStream(socket.getOutputStream());
        System.out.println("Sending msg to client: "+obj);
        //write object to Socket
        oos.writeObject(obj);
        oos.close();
        socket.close();
    }


    static String receivemsg() throws IOException, ClassNotFoundException {
        socket = server.accept();
        ois = new ObjectInputStream(socket.getInputStream());
        String message = (String) ois.readObject();
        System.out.println("Message Received from client: " + message);
        ois.close();
        socket.close();
        return message;
    }



     static void does() throws Exception {

        init();

        while (true) receivemsg();

       


    }






    public static void main(String args[]) throws Exception{
        does();
     
    }


}
