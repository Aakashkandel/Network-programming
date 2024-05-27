import java.net.*;
public class Jaddress{
    public static void main (String[] args)
    {
        try{
            InetAddress address=InetAddress.getByName("www.aakashkandel.com.np");
            System.out.println(address);
            
        }
        catch(UnknownHostException ex)
        {
            System.out.println("could not find www.aakash.com.np");
        }
    }
}