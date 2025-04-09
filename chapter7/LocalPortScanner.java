//191
package chapter7;

import java.io.IOException;
import java.net.ServerSocket;

public class LocalPortScanner {
    public static void main(String[] args) {
        int start = 1;
        int end = 500;
        for(int port=start;port<=end;port++){
            try {
                ServerSocket server = new ServerSocket(port);
                System.out.println("There no server running, the port is open and ready to be used:" + port);
            } catch (IOException e) {
                System.out.println("There is a server running on port: " + port);
            }
        }
    }

}
