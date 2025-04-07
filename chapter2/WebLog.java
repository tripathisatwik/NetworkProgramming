package chapter2;
import java.io.*;
import java.net.*;

public class WebLog {
    public static void main(String[] args) {

        try (FileInputStream fin = new FileInputStream(args[0]);
             Reader in = new InputStreamReader(fin);
             BufferedReader bin = new BufferedReader(in)) {
            
            // Using a for loop to read each line
            for (String entry = bin.readLine(); entry != null; entry = bin.readLine()) {
                // Separate out the IP address
                int index = entry.indexOf(' ');
                if (index == -1) {
                    System.err.println("Skipping malformed line: " + entry);
                    continue; // Skip malformed lines
                }

                String ip = entry.substring(0, index);
                String theRest = entry.substring(index);

                // Ask DNS for the hostname and print it out
                try {
                    InetAddress address = InetAddress.getByName(ip);
                    System.out.println(address.getHostName() + theRest);
                } catch (UnknownHostException ex) {
                    System.err.println("Unknown host for IP: " + ip);
                }
            }
        } catch (IOException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }
}
