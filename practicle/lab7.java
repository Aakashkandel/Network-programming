package practicle;
import java.net.*;
import java.util.Scanner;

public class lab7 {
    public static void main(String[] args) {
        try {
            System.out.println("Enter the URL here:");
            Scanner sc = new Scanner(System.in);
            String url = sc.nextLine();
            sc.close();
            
            URL u = new URL(url);
            System.out.println("The URL is " + u);
            System.out.println("The scheme is " + u.getProtocol());
            System.out.println("The user info is " + u.getUserInfo());
            
            String host = u.getHost();
            if (host != null) {
                int atSign = host.indexOf('@');
                if (atSign != -1) host = host.substring(atSign + 1);
                System.out.println("The host is " + host);
            } else {
                System.out.println("The host is null.");
            }
            
            System.out.println("The port is " + u.getPort());
            System.out.println("The path is " + u.getPath());
            System.out.println("The ref is " + u.getRef());
            System.out.println("The query string is " + u.getQuery());
        } catch (MalformedURLException ex) {
            System.err.println("The input is not a valid URL.");
        }
        System.out.println();
    }
}
// "http://www.example.com:80/docs/resource1.html?name=networking#DOWNLOADING" 