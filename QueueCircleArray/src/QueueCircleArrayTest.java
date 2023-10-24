import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class QueueCircleArrayTest {

    private QueueCircleArray queue;

    @BeforeEach
    public void setUp() {
        queue = new QueueCircleArray(5);
    }

    @Test
    public void testEnqueueAndDequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());

        queue.enqueue(4);
        queue.enqueue(5);

        assertEquals(3, queue.dequeue());
        assertEquals(4, queue.dequeue());
        assertEquals(5, queue.dequeue());

        assertTrue(queue.isEmpty());
    }

    @Test
    public void testEnqueueFullQueue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> queue.enqueue(6));
    }

    @Test
    public void testDequeueEmptyQueue() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> queue.dequeue());
    }

    @Test
    public void testPeekEmptyQueue() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> queue.peek());
    }

    @Test
    public void testPeekAfterDequeue() {
        queue.enqueue(10);
        queue.enqueue(20);
        assertEquals(10, queue.peek());

        queue.dequeue();

        assertEquals(20, queue.peek());
    }

    @Test
    public void testCircularBehavior() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.dequeue();
        queue.enqueue(3);
        queue.enqueue(4);

        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertEquals(4, queue.dequeue());

        assertTrue(queue.isEmpty());
    }

    @Test
    public void testShow() {
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        queue.enqueue("E");
        assertThrows(RuntimeException.class, () -> queue.enqueue("F"));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        queue.show();

        System.setOut(originalOut);

        String expectedOutput = "[0 => A, 1 => B, 2 => C, 3 => D, 4 => E]";
        String actualOutput = outputStream.toString().trim();

        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testShow2() {
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        queue.enqueue("E");

        assertThrows(RuntimeException.class, () -> queue.enqueue("F"));

        assertEquals("A", queue.dequeue());
        queue.enqueue("F");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        queue.show();

        System.setOut(originalOut);

        String expectedOutput = "[1 => B, 2 => C, 3 => D, 4 => E, 0 => F]";
        String actualOutput = outputStream.toString().trim();

        Assertions.assertEquals(expectedOutput, actualOutput);
    }
}