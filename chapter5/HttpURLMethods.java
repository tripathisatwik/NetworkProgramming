package chapter5;
import java.net.*;

public class HttpURLMethods {
public static void main(String[] args) {
        try {
            @SuppressWarnings("deprecation")
            URL url = new URL("https://httpbin.org/get");
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();

            // Sending a request
            huc.setRequestMethod("GET");
            huc.connect();

            // Printing HTTP response details
            System.out.println("Content-Type: " + huc.getContentType());
            System.out.println("Content-Length: " + huc.getContentLength());
            System.out.println("Content-Encoding: " + huc.getContentEncoding());
            System.out.println("Date: " + huc.getDate());
            System.out.println("Last-Modified: " + huc.getLastModified());
            System.out.println("Expiration: " + huc.getExpiration());

            // Example of printing all headers
            System.out.println("\nResponse Headers:");
            for (int i = 0;; i++) {
                String headerKey = huc.getHeaderFieldKey(i);
                String headerValue = huc.getHeaderField(i);
                if (headerKey == null && headerValue == null) {
                    break;
                }
                System.out.println((headerKey != null ? headerKey : "") + ": " + headerValue);
            }

            huc.disconnect();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
