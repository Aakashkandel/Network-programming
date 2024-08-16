package exampractice;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SocketClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter server hostname:");
        String hostname = sc.nextLine();

        System.out.println("Enter server port number:");
        int port = sc.nextInt();
        sc.nextLine(); // Consume the newline left-over

        sc.close();

        Socket socket = null;
        BufferedReader reader = null;

        try {

            socket = new Socket(hostname, port);
            socket.setSoTimeout(5000); // Set a timeout of 5 seconds

            InputStream input = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(input));

            // Read the server's response
            String serverTime = reader.readLine();
            if (serverTime != null) {
                System.out.println("Server time: " + serverTime);
            } else {
                System.out.println("No response from server.");
            }

        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        } finally {
            // Close resources in the finally block to ensure they are closed even if an
            // exception occurs
            try {
                if (reader != null) {
                    reader.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException ex) {
                System.out.println("Error closing resources: " + ex.getMessage());
            }
        }
    }
}
