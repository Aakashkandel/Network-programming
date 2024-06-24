import java.net.MalformedURLException;

import java.net.URL;
import java.util.*;
public class createurl {
    public static void main(String [] args)
    {
        System.out.println("enter url here:");
        Scanner sc=new Scanner(System.in);
        String url=sc.nextLine();
        try{
            URL u=new URL(url);
           System.out.println( u.getHost()+" "+u.getProtocol());

            

        }catch(MalformedURLException ex)
        {
            System.out.println(ex);
        }
    }
    
}
