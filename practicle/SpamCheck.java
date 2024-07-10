 package practicle;
import java.net.*;
import java.util.Scanner;

public class SpamCheck {
    public static final String BLACKHOLE = "sbl.spamhaus.org";


    public static void main(String[] args) throws UnknownHostException {

        System.out.println("Enter the IP address to check if it is a spammer or not:");
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        if (isSpammer(ip)) {
            System.out.println(ip + " is a known spammer.");
        } else {
            System.out.println(ip + " appears legitimate.");
        }
    }

    private static boolean isSpammer(String ip) {
        try {
            InetAddress address = InetAddress.getByName(ip);
            byte[] quad = address.getAddress();
            String query = BLACKHOLE;
            for (byte octet : quad) {
                int unsignedByte = octet < 0 ? octet + 256 : octet;
                query = unsignedByte + "." + query;
            }
            InetAddress.getByName(query);
            return true;
        } catch (UnknownHostException e) {
            return false;
        }
    }
}
