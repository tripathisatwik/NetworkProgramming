package chapter2;

import java.net.InetAddress;

public class Ipversion {
    // public static int getVersion(InetAddress ia){
    //     byte[] address = ia.getAddress();
    //     if(address.length == 4) return 4;
    //     elseif(address.length == 6) return 6;
    //     else return -1;
    // }

    public static int getIpAddressVersion(InetAddress ia){
        try {
            byte[] address = ia.getAddress(); 
            if(address.length == 4) return 4;
            else if(address.length == 16) return 6;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }
    public static void main(String[] args) {
        //my ip address v4
        String ip = "163.70.145.35";
        InetAddress ia = InetAddress.getByName(ip);

        int version = getIpAddressVersion(ia);
        System.out.println("IP Version is v");

        String ip2 = "1050:0000:0000:0000:000";
        InetAddress ia2 = InetAddress.getByAddress(ip2);

        int version2 = getIpAddressVersion(ia2);
        System.out.println("Ip version is v" + version2);
    }
}
