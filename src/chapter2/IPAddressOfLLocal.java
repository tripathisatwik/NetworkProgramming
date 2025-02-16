package chapter2;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAddressOfLLocal {
    public static void main(String[] args) {
        try{
            InetAddress me = InetAddress.getLocalHost();
            String dottedQuad = me.getHostAddress();
            System.out.println("My address is: " + dottedQuad);
        }catch(UnknownHostException ex){
            System.out.println("I'm Sorry. I don't know mu own address");
        }
    }
}
