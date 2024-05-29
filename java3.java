
//Give the address,find the hostname
import java.net.*;
public class java3 {
    public static void main(String[] args) throws UnknownHostException{
        InetAddress ia=InetAddress.getByName("104.21.11.93");
        System.out.println(ia.getCanonicalHostName());
    }
}
