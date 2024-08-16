package socket;

import java.net.*;
import java.io.*;

public class MyClient {

    public static void main(String[] args) {
        Socket socket = null;
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;
        BufferedReader bufferedReader = null;
        BufferedReader inputReader = null;

        try {
            // Connect to the server on localhost and port 3333
            socket = new Socket("localhost", 3333);
            System.out.println("Connected to the server...");

            // Create input and output streams for communication
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            inputReader = new BufferedReader(new InputStreamReader(System.in));

            String messageToSend;
            String serverResponse;

            // Read message from the user and send to server
            while (true) {
                System.out.print("Enter message to send to server: ");
                messageToSend = inputReader.readLine();

                // Send message to server
                dataOutputStream.writeUTF(messageToSend);
                dataOutputStream.flush();

                // Receive response from server
                serverResponse = dataInputStream.readUTF();
                System.out.println("Received from server: " + serverResponse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (dataInputStream != null) dataInputStream.close();
                if (dataOutputStream != null) dataOutputStream.close();
                if (socket != null) socket.close();
                if (bufferedReader != null) bufferedReader.close();
                if (inputReader != null) inputReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
