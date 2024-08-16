package practicle;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class CheckSpam2 {
    public static final String BLACKHOLE="sbl.spamhaus.org";

    public  boolean  isSpammer(String ip)
    {
        try{
            InetAddress address= InetAddress.getByName(ip);
        byte[] byteip=address.getAddress();
        String query=BLACKHOLE;
        for(byte oct:byteip)
        {
           
             int unSignedByte=oct<0?oct+256:oct;
                query=unSignedByte+"."+query;

        }

        InetAddress.getByName(query);
        return true;



        }
        catch(UnknownHostException e)
        {
            return false;

        }


    }

    public static class SpamDemo{
        public static void main(String[] args)
        {
            System.out.println("Enter the ip address which you want to check?");
    
            Scanner sc =new Scanner (System.in);
            String ip=sc.nextLine();
    
            CheckSpam2 obj=new CheckSpam2();
            if(obj.isSpammer(ip))
            {
                System.out.println(ip+" is legimate ip address");
            }
            else{
                System.out.println(ip+" is Spam ip address");
            }
    
        }
    }

    
}


