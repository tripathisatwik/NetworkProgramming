package chapter3;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class SourceViewer {
public static void main(String[] args) {
    try {
        @SuppressWarnings("deprecation")
        URL u = new URL("http://example.com");
        InputStream in = u.openStream();
        int c;
        while ((c=in.read())!=-1) { 
            System.out.print(c);
        }
    } catch (IOException e) {
        System.err.println(e);
    }
}
}
