package chapter6;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class SocketInfo {
    public static void main(String[] args) {
        for (int i=0; i < args.length; i++){
            try {
                Socket theSocket = new Socket(args[i], 80);
                System.out.println("Connected to: " + theSocket.getInetAddress());
                System.out.println("Local Port: " + theSocket.getLocalPort());
                 System.out.println("IP of host: " + theSocket.getLocalAddress());
            } catch (UnknownHostException e) {
                System.err.println("Can't find " + args[i]);
            } catch (SocketException e) {
                System.err.println("Could not connect to "+ args[i]);
            } catch (IOException e ) {
                System.err.println(e);
            }
        }
    }
}
