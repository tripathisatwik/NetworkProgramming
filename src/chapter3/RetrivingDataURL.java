package chapter3;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class RetrivingDataURL {

    public static void main(String[] args) {
        try {
            URL u = new URL("https://google.com");

            URLConnection urlConnection = u.openConnection();
            InputStream in = u.openStream();
            int c;
            while ((c = in.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (MalformedURLException e) {
            System.err.println(args[0] + "is not a paraseable URL");
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
