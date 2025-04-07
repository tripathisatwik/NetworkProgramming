package chapter5;
import java.io.*;
import java.net.*;
public class URLConnectionTest {
    public static void main(String[] args) {
        try{
            @SuppressWarnings("deprecation")

            URL u =  new URL("https://httpbin.org/get");

            URLConnection uc = u.openConnection();
            System.out.println("Content-Type: " + uc.getContentType());
        }catch(MalformedURLException e) {
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
