package practicle;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SourceViewer {
    public static void main(String[] args) {
        InputStream in = null;
        try {
            System.out.println("Enter the URL here:");
            Scanner sc = new Scanner(System.in);
            String url = sc.nextLine();
            sc.close();

            URL u = new URL(url);
            in = u.openStream();
            // buffer the input to increase performance
            in = new BufferedInputStream(in);
            // chain the InputStream to a Reader
            Reader r = new InputStreamReader(in);
            int c;
            while ((c = r.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (MalformedURLException ex) {
            System.err.println("The URL is not parseable.");
        } catch (IOException ex) {
            System.err.println(ex);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    // ignore
                }
            }
        }
    }
}

// https://aakashkandel.com.np/
