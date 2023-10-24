import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    private DoublyLinkedList list;

    @BeforeEach
    void setUp() {
        list = new DoublyLinkedList();
    }

    @Test
    void testAdd() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.size());
        assertTrue(list.find(1));
        assertTrue(list.find(2));
        assertTrue(list.find(3));
    }

    @Test
    void testAddAtIndex() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.add(2, 4);
        list.add(1, 5);
        list.add(5, 6);

        assertEquals(6, list.size());
        assertEquals(5, list.get(1));
        assertEquals(1, list.get(2));
        assertEquals(4, list.get(3));
        assertEquals(2, list.get(4));
        assertEquals(6, list.get(5));
        assertEquals(3, list.get(6));
    }

    @Test
    void testAddAtIndexOutOfBounds() {
        list.add(1);
        list.add(2);

        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, 3));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(0, 3));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(4, 3));
    }

    @Test
    void testGet() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(1, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(3, list.get(3));
    }

    @Test
    void testGetOutOfBounds() {
        list.add(1);

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(2));
    }

    @Test
    void testSet() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.set(2, 4);

        assertEquals(4, list.get(2));
    }

    @Test
    void testSetOutOfBounds() {
        list.add(1);

        assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, 3));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(2, 3));
    }

    @Test
    void testRemove() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(4);

        list.remove(2);

        assertEquals(3, list.size());
        assertFalse(list.find(2));
    }

    @Test
    void testRemoveNonExistent() {
        list.add(1);
        list.add(2);

        list.remove(3);

        assertEquals(2, list.size());
    }

    @Test
    void testFind() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertTrue(list.find(1));
        assertTrue(list.find(2));
        assertFalse(list.find(4));
    }

    @Test
    void testSize() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.size());

        list.remove(2);

        assertEquals(2, list.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(list.isEmpty());

        list.add(1);

        assertFalse(list.isEmpty());
    }

    @Test
    void testShow() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals("[ 1, 2, 3 ]", captureShowOutput());
    }

    @Test
    void testShowEmpty() {
        assertEquals("[ ]", captureShowOutput());
    }

    @Test
    void testShowBackwardEmpty() {
        assertEquals("[ ]", captureShowOutput());
    }

    @Test
    void testShowBackward() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals("[ 3, 2, 1 ]", captureShowBackwardOutput());
    }

    // Helper method to capture System.out for show()
    private String captureShowOutput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        list.show();
        return outputStream.toString().trim();
    }

    // Helper method to capture System.out for show_backward()
    private String captureShowBackwardOutput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        list.show_backward();
        return outputStream.toString().trim();
    }
}