package practicle.buffer;


import java.nio.*;
import java.nio.CharBuffer;

public class Bufferpractice {
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

        buffer.position(5);
        buffer.mark();
        System.out.println("Buffer position: "+buffer.position());
        buffer.reset();
        System.out.println("Buffer position after reset: "+buffer.position());
        buffer.clear();
        System.out.println("Buffer position after clear: "+buffer.position());
        System.out.println("Buffer limit after clear: "+buffer.limit());
        System.out.println("Buffer capacity after clear: "+buffer.capacity());
        System.out.println("Buffer content after clear: ");
        while(buffer.hasRemaining())
        {
            System.out.print(buffer.get());
        }

    
    }

    
}
