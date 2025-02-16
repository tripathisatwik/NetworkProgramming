package chapter3;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {
    public static URL createURL(String urlString){
        try {
            URL url3 = new URL(urlString);
            return url3;
        } catch (MalformedURLException ex) {
            System.err.println("Malformed URL Exception: " + ex.getMessage());
        }
        return null;
    }

    public static URL createURL(){
        try {
            URL myURL = new URL("https://www.example.com/pages/");
            URL baseurl = new URL(myURL, "page1.html");
            return baseurl;
        } catch (MalformedURLException ex) {
            System.err.println("Malformed URL Exception: " + ex.getMessage());
        }
        return null;
    }
    
    private static void showDemo(String urlString){
        try{
            URL url = new URL(urlString);
            URL url2 = createURL();
            URL url3 = new URL("https","facebook.com",8000,"/tripathisatwik");
            createURL("https://example.com");
            System.out.println("1. URL: " + url);
            System.out.println("2. Protocol: " + url.getProtocol());
            System.out.println("3. Host: " + url.getHost());
            System.out.println("4. Port: " + url.getPort());
            System.out.println("5. File: " + url.getFile());
            System.out.println("6. Authority: " + url.getAuthority());
            System.out.println("7. Query: " + url.getQuery());
            System.out.println("8. Default Port: " + url.getDefaultPort());
            System.out.println("9. Ref: " + url.getRef());
            System.out.println("10. Test Same URL: " + url.equals(url2));
            System.out.println("11. Comparing with explicit port: " + url.equals(url2));
        }catch(MalformedURLException ex){
            System.err.println("Malformed URL Exception: " + ex.getMessage());
        }catch(Exception e){
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        showDemo("https://google.com:80");
    }
}