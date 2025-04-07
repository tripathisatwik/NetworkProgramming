package chapter1;

import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 5344)){
            System.out.println("Connected to server");
            DataOutputStream d = new DataOutputStream(socket.getOutputStream());
            d.writeUTF("Hello, server! I am Satwik Tripathi");
            d.flush();
            d.close();
            socket.close();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
        }
        
    }
}
