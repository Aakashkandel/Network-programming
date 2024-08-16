package socket;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class socketchannelserver {
    public static void main(String[] args)throws IOException{
        SocketChannel server=SocketChannel.open();
        SocketAddress socketaddr=new InetSocketAddress("localhost",9000);
        server.connect(socketaddr);
        Path path=Paths.get("c:/Test/temp.txt");
        FileChannel fileChannel=FileChannel.open(path);
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        while(fileChannel.read(buffer)>0)
        {
            buffer.flip();
            server.write(buffer);
            buffer.clear();

        }

        fileChannel.close();
        System.out.println("File send successfully");
        server.close();

    }
    
}
