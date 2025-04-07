package chapter6;

import java.io.*;
import java.net.*;

public class WhoisClient {
    public final static int DEFAULT_PORT = 43;
    public final static String DEFAULT_HOST = "whois.iana.org";

    public static void main(String[] args) {
        String query = "tripathisatwik.com.np";
        try {
            InetAddress server = InetAddress.getByName(DEFAULT_HOST);
            Socket socket = new Socket(server, DEFAULT_PORT);

            Writer out = new OutputStreamWriter(socket.getOutputStream(), "ISO-8859-1");
            out.write(query + "\r\n");
            out.flush();

            System.out.println("\n Details of " + query);
            InputStream in = new BufferedInputStream(socket.getInputStream());
            int c;
            while ((c = in.read()) != -1) {
                System.out.write(c);
            }

            socket.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}