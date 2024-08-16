package exampractice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

public class Englishtolatin {
    public static final String server="dict.org";
    public static final int port=2628;
    public static final int timeout=15000;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Socket socket = null;
        try {
            socket = new Socket(server, port);
            socket.setSoTimeout(timeout);
            OutputStream out = socket.getOutputStream();
            Writer writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));

            for (String word : "book".split(" ")) {
                define(word, writer, reader);
            }

            writer.write("quit\r\n");
            writer.flush();

        } catch (IOException ex) {

            System.err.println(ex);

        } finally {
            
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException ex) {
                    // Ignore
                }
            }
        }
    }

    private static void define(String word, Writer writer, BufferedReader reader) throws IOException {
        writer.write("DEFINE fd-eng-lat " + word + "\r\n");
        writer.flush();
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            if (line.startsWith("250 ")) {
                break;
            }
        }
    }
    


}