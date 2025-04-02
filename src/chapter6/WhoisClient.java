package chapter6;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class WhoisClient {
    public final static int DEFAULT_PORT = 443;
    public final String DEFAULT_HOST = "lookup.icann.org";
    public static void main(String[] args) {
        InetAddress server;
        try {
            server = InetAddress.getByName(DEFAULT_HOST);
        } catch (UnknownHostException e) {
            System.err.println("Error: Could not locate defualt host" + DEFAULT_HOST);
            System.err.println("Check to make sure you're connected to the Internet and that DNS is ");
        }
    }
}
