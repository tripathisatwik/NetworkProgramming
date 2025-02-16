package chapter3;

import java.net.URL;

public class ContentGetter {

    public static void main(String[] args) { 
        try {
            URL u = new URL("https://google.com");
            Object o = u.getContent();
            System.out.println("I got a " + o.getClass().getName());
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
}