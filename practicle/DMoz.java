package practicle;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class DMoz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter search query: ");
        String queryStr = scanner.nextLine().trim();

        // Encode the query string
        String encodedQuery = URLEncoder.encode(queryStr, StandardCharsets.UTF_8);

        // Build the URL and fetch the content
        try {
            URL url = new URL("https://github.com/Aakashkandel?tab=" + encodedQuery);
            try (InputStream in = new BufferedInputStream(url.openStream());
                 InputStreamReader theHTML = new InputStreamReader(in)) {
                int c;
                while ((c = theHTML.read()) != -1) {
                    System.out.print((char) c);
                }
            }
        } catch (MalformedURLException ex) {
            System.err.println("Malformed URL: " + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("I/O Error: " + ex.getMessage());
        } finally {
            scanner.close(); // Close the scanner to free resources
        }
    }
}
//repositories