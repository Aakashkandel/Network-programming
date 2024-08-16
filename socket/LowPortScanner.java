package socket;
//Example 8-5. Find out which of the first 1024 ports seem to be hosting TCP servers on a
//specified host
import java.net.*;
import java.util.Scanner;
import java.io.*;
public class LowPortScanner {
 public static void main(String[] args) {

    System.out.println("Enter the host name:");
    Scanner sc=new Scanner(System.in);
    String host = sc.nextLine();
    sc.close();
    if(host.isEmpty()){
        host="localhost";
    }   
 

 for (int i = 1; i < 1024; i++) {
 try {
 Socket s = new Socket(host, i);
 System.out.println("There is a server on port " + i + " of "
 + host);
 s.close();
 } catch (UnknownHostException ex) {
 System.err.println(ex);
 break;
 } catch (IOException ex) {
 // must not be a server on this port
 }
 }
 }
}