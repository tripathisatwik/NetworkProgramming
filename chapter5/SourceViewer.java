package chapter5;
import java.io.*;
import java.net.*;

public class SourceViewer {
    public static void main(String[] args) {
        if(args.length > 0) {
            try {
                //Open the URL for reading
                @SuppressWarnings("deprecation")

                URL u = new URL(args[0]);
                try (InputStream in = new BufferedInputStream(u.openStream())) {
                    //chain the InputStream to a Reader
                    Reader r = new InputStreamReader(in);
                    int c;
                    while((c = r.read()) != -1) {
                        System.out.print((char) c);
                    }
                }
            } catch (MalformedURLException ex) {
                System.err.println(args[0] + " is not a parseable URL");
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
}
