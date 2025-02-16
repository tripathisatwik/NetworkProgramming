package chapter3;

import java.net.URI;

public class URIDemo {
    public static void main(String[] args) {
        
        try{
             URI voice = new URI("tel:+1-800-9900-9938");
             URI web = new URI("http://www.xml.com/pub/a/2003/00/0/12");
             URI tutorial = new URI("urn:oasis:names:specification:docbook:dtd:xml:4.1.2");
             
             URI isbn = new URI("isbn:8956231025");
             System.out.println(isbn);
             
             URI iso = new URI("iso:9001/2000");
             System.out.println(iso);
             System.out.println(iso.getScheme());
                     
               
             System.out.println("Telephone: " + voice);
             System.out.println("Web URI: " + web);
             System.out.println("Tutorial: "+ tutorial);
             
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
