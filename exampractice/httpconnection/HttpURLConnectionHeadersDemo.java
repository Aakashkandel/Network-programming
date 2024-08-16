package exampractice.httpconnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionHeadersDemo {
    public static void main(String[] args) {
        String urlString = "http://www.example.com";
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            // Set request method
            connection.setRequestMethod("GET");
            
            // Get all headers
            for (String headerKey : connection.getHeaderFields().keySet()) {
                System.out.println(headerKey + ": " + connection.getHeaderField(headerKey));
            }
            
            // Get a specific header
            String specificHeader = connection.getHeaderField("Content-Type");
            System.out.println("Content-Type: " + specificHeader);

            // Read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Print the response
            System.out.println("Response: " + response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
