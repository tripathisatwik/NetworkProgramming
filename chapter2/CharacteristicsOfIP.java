package chapter2;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class CharacteristicsOfIP {
    public static void main(String[] args) {

        try {
            // Get the InetAddress object for "localhost"
            InetAddress address = InetAddress.getByName("localhost");

            // Check if the address is a wildcard address (0.0.0.0 or ::)
            if (address.isAnyLocalAddress()) {
                System.out.println(address + " is a wildcard address.");
            }

            // Check if the address is a loopback address (127.0.0.1 or ::1)
            if (address.isLoopbackAddress()) {
                System.out.println(address + " is a loopback address.");
            }

            // Check if the address is a link-local address (169.254.0.0/16 or fe80::/10)
            if (address.isLinkLocalAddress()) {
                System.out.println(address + " is a link-local address.");
            }
            // Check if the address is a site-local address (deprecated, but still checked)
            else if (address.isSiteLocalAddress()) {
                System.out.println(address + " is a site-local address.");
            } else {
                // If none of the above, it's likely a global address
                System.out.println(address + " is a global address.");
            }

            // Check if the address is a multicast address
            if (address.isMulticastAddress()) {
                // Check the scope of the multicast address
                if (address.isMCGlobal()) {
                    System.out.println(address + " is a global multicast address.");
                } else if (address.isMCOrgLocal()) {
                    System.out.println(address + " is an organization-wide multicast address.");
                } else if (address.isMCSiteLocal()) {
                    System.out.println(address + " is a site-wide multicast address.");
                } else if (address.isMCLinkLocal()) {
                    System.out.println(address + " is a subnet-wide multicast address.");
                } else if (address.isMCNodeLocal()) {
                    System.out.println(address + " is an interface-local multicast address.");
                } else {
                    System.out.println(address + " is an unknown multicast address.");
                }
            } else {
                // If not a multicast address, it's a unicast address
                System.out.println(address + " is a unicast address.");
            }
        } catch (UnknownHostException ex) {
            // Handle the exception if the host name is not found
            System.out.println("Error: " + ex.getMessage());
        }
    }
}