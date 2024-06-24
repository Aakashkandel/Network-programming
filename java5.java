//network interface read

import java.net.*;
import java.util.Scanner;
public class java5 {
    public static void main (String[] args)
    {
        System.out.println("Enter the ip address ");
        Scanner sc=new Scanner(System.in);
        String ip=sc.nextLine();
        
        try{
            InetAddress local=InetAddress.getByName(ip);
            NetworkInterface ni=NetworkInterface.getByInetAddress(local);
            if(ni==null)
            {
                System.out.println("No locaback address");
            }
            else{
                System.out.println("Network interface name"+" "+ni.getName());//this method is used for to display actual name of the address
                System.out.println("Network interface name"+" "+ni.getDisplayName());//thsi method is used to display human readable form name of the loop address
            }
        
        }catch(SocketException ex)
        {
            System.err.println("could not list network interface");
        }
        catch(UnknownHostException ex)
        {
            System.err.println("could not lookup "+ip);
        }

    }
    
}
