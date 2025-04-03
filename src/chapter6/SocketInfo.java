package chapter6;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class SocketInfo {
    public static void main(String[] args) {
        String target = "example.com";
        try {
            Socket theSocket = new Socket(target, 80);
            System.out.println("Connected to: " + theSocket.getInetAddress());
            System.out.println("Port: " + theSocket.getPort());
            System.out.println("Local Port: " + theSocket.getLocalPort());
            System.out.println("IP of host: " + theSocket.getLocalAddress());
            System.out.println("Input Stream: " + theSocket.getInputStream());
            System.out.println("Output Stream: " + theSocket.getOutputStream());
            theSocket.close();

        } catch (UnknownHostException e) {
            System.err.println("Can't find " + target);
        } catch (SocketException e) {
            System.err.println("Could not connect to "+ target);
        } catch (IOException e ) {
            System.err.println(e);
        }
    }
}
