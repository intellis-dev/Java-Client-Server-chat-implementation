

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class client {

    static ObjectInputStream ois;
    static ObjectOutputStream oos;
    static  InetAddress host;
    static Socket socket;




    static void sendmsg(Object obj) throws IOException {

        socket = new Socket(host.getHostName(), 9876);
        oos = new ObjectOutputStream(socket.getOutputStream());
        System.out.println("Sending msg to  Server: "+obj);
        oos.writeObject(obj);
        oos.close();
    }


    static String receivemsg() throws IOException, ClassNotFoundException {
         socket = new Socket(host.getHostName(), 9876);
        ois = new ObjectInputStream(socket.getInputStream());
        String message = (String) ois.readObject();
        System.out.println("Message received from server: " + message);
        ois.close();
        return message;
    }


    static void init() throws UnknownHostException {
        host = InetAddress.getLocalHost();
        socket = null;
        oos = null;
        ois = null;
    }





     static void does() throws Exception {

        init();

       for(int i=1;i<10;i++) sendmsg("msg no: "+i);

        

         }

    }



    public static void main(String[] args) throws Exception{

        does();

    
    }


}
