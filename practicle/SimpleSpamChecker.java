package practicle;
import java.net.*;

public class SimpleSpamChecker {

    public static final String BLACKHOLE = "dnsbl.sorbs.net";

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide IP addresses or hostnames to check.");
            return;
        }

        for (String arg : args) {
            System.out.println("Checking: " + arg);
            if (isSpammer(arg)) {
                System.out.println(arg + " is a known spammer.");
            } else {
                System.out.println(arg + " appears legitimate.");
            }
        }
    }

    private static boolean isSpammer(String arg) {
        try {
            InetAddress address = InetAddress.getByName(arg);
            byte[] quad = address.getAddress();
            StringBuilder query = new StringBuilder(BLACKHOLE);

            // Building the query string
            for (int i = quad.length - 1; i >= 0; i--) {
                int unsignedByte = quad[i] < 0 ? quad[i] + 256 : quad[i];
                query.insert(0, unsignedByte + ".");
            }
            System.out.println("Query: " + query.toString());

            // Attempting to resolve the query
            InetAddress.getByName(query.toString());
            return true;
        } catch (UnknownHostException e) {
            return false;
        }
    }
}
