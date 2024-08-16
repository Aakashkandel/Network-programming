
package practicle.buffer;
import java.nio.*;
public class BufferReading {
    public static void main(String[] args)
    {
        CharBuffer buffer = CharBuffer.allocate(10);
        String text="bufferDemo";
        System.out.println("Input value: "+text);

        for(int i=0;i<text.length();i++)
        {
            char c=text.charAt(i);
            buffer.put(c);
        }

        int buffpos=buffer.position();
        System.out.println("Buffer position: "+buffpos);
        buffer.flip();
        System.out.println("Buffer position after flip: "+buffer.position());
        System.out.println("Buffer limit after flip: "+buffer.limit());
        System.out.println("Buffer capacity after flip: "+buffer.capacity());
        System.out.println("Buffer content after flip: ");
        while(buffer.hasRemaining())
        {
            System.out.print(buffer.get());
        }

        System.out.println("\nBuffer position after get: "+buffer.position());
        System.out.println("Buffer limit after get: "+buffer.limit());

    }
    
}

