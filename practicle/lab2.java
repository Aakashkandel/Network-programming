package practicle;
 import java.net.*;

public class lab2 {

   

 public static void main (String args[]) {
 try {
 InetAddress facebook = InetAddress.getByName("www.facebook.com");
 InetAddress fb = InetAddress.getByName("www.fb.com");
 if (facebook.equals(fb)) {
 System.out.println
 (" www.facebook.com is the same as www.fb.com");
 } else {
 System.out.println
 (" www.facebook.com is not same as www.fb.com");
 }
 } catch (UnknownHostException ex) {
 System.out.println("Host lookup failed.");
 }
 }
}
    

