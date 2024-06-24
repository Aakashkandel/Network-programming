 //write a java program to accept the url from user and encode the url and 
// display encoded url string and then decode the encoded url 
// and again display the decoded url.

import java.util.*;
import java.net.*;

public class url_practice{
    public static void main(String [] args)
    {
      System.out.println("Please enter url here");
      Scanner sc=new Scanner(System.in);

      String url=sc.nextLine();

      try{
        String encodeurl= URLEncoder.encode(url, "UTF-8");
    System.out.println(encodeurl);

    String decodeurl=URLDecoder.decode(encodeurl,"UTF-8");
    System.out.println(decodeurl);

    

      } catch(Exception e)
      {
        System.out.println(e);
      }

    }
}