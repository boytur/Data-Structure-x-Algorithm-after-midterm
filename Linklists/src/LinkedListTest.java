//
//import org.junit.jupiter.api.AfterEach;
//
//import org.junit.jupiter.api.BeforeEach;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.io.ByteArrayOutputStream;
//
//import java.io.PrintStream;
//
//
//
//public class LinkedListTest {
//
//    private LinkedList list;
//
//    private final PrintStream originalSystemOut = System.out;
//
//    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//
//
//
//    @BeforeEach
//
//    void setUp() {
//
//        list = new LinkedList();
//
//        System.setOut(new PrintStream(outputStream));
//
//    }
//
//
//
//    @Test
//
//    void testShow() {
//
//        list.add(1);
//
//        list.add(2);
//
//        list.add(3);
//
//        list.show();
//
//
//
//        String expectedOutput = "[ 1, 2, 3 ]";
//
//        assertEquals(expectedOutput, outputStream.toString().trim());
//
//    }
//
//
//
//    @Test
//
//    void testShowEmptyList() {
//
//        list.show();
//
//
//
//        String expectedOutput = "[ ]";
//
//        assertEquals(expectedOutput, outputStream.toString().trim());
//
//    }
//
//
//
//    @Test
//
//    void testShowSingleElementList() {
//
//        list.add(5);
//
//        list.show();
//
//
//
//        String expectedOutput = "[ 5 ]";
//
//        assertEquals(expectedOutput, outputStream.toString().trim());
//
//    }
//
//
//
//    @Test
//
//    void testShowAfterModifyingList() {
//
//        list.add(1);
//
//        list.add(2);
//
//        list.add(3);
//
//        list.remove(2);
//
//        list.show();
//
//
//
//        String expectedOutput = "[ 1, 3 ]";
//
//        assertEquals(expectedOutput, outputStream.toString().trim());
//
//    }
//
//
//
//    @Test
//
//    void testShowNoOutput() {
//
//// No output is expected because the list is empty
//
//        list.show();
//
//
//
//        assertEquals("[ ]", outputStream.toString().trim());
//
//    }
//
//
//
//    @AfterEach
//
//    void restoreSystemOut() {
//
//        System.setOut(originalSystemOut);
//
//    }
//
//
//
//    @Test
//
//    void testAdd() {
//
//        list.add(1);
//
//        list.add(2);
//
//        list.add(3);
//
//
//
//        assertEquals(3, list.size());
//
//        assertTrue(list.find(1));
//
//        assertTrue(list.find(2));
//
//        assertTrue(list.find(3));
//
//    }
//
//
//
//    @Test
//
//    void testAddAtIndex() {
//
//        list.add(1);
//
//        list.add(2);
//
//        list.add(3);
//
//        list.add(2, 5);
//
//
//
//        assertEquals(4, list.size());
//
//        assertEquals(1, list.get(1));
//
//        assertEquals(5, list.get(2));
//
//        assertEquals(2, list.get(3));
//
//        assertEquals(3, list.get(4));
//
//    }
//
//
//
//    @Test
//
//    void testGet() {
//
//        list.add(1);
//
//        list.add(2);
//
//        list.add(3);
//
//
//
//        assertEquals(1, list.get(1));
//
//        assertEquals(2, list.get(2));
//
//        assertEquals(3, list.get(3));
//
//    }
//
//
//
//    @Test
//
//    void testSet() {
//
//        list.add(1);
//
//        list.add(2);
//
//        list.add(3);
//
//        list.set(2, 5);
//
//
//
//        assertEquals(3, list.size());
//
//        assertEquals(1, list.get(1));
//
//        assertEquals(5, list.get(2));
//
//        assertEquals(3, list.get(3));
//
//    }
//
//
//
//    @Test
//
//    void testRemove() {
//
//        list.add(1);
//
//        list.add(2);
//
//        list.add(3);
//
//        list.remove(2);
//
//
//
//        assertEquals(2, list.size());
//
//        assertTrue(list.find(1));
//
//        assertFalse(list.find(2));
//
//        assertTrue(list.find(3));
//
//    }
//
//
//
//    @Test
//
//    void testSize() {
//
//        list.add(1);
//
//        list.add(2);
//
//        list.add(3);
//
//
//
//        assertEquals(3, list.size());
//
//    }
//
//
//
//    @Test
//
//    void testIsEmpty() {
//
//        assertTrue(list.isEmpty());
//
//
//
//        list.add(1);
//
//        assertFalse(list.isEmpty());
//
//    }
//
//
//
//    @Test
//
//    void testAddAndRemove() {
//
//        list.add(1);
//
//        list.add(2);
//
//        list.add(3);
//
//        list.remove(2);
//
//
//
//        assertEquals(2, list.size());
//
//        assertEquals(1, list.get(1));
//
//        assertEquals(3, list.get(2));
//
//    }
//
//
//
//    @Test
//
//    void testAddAtIndexOutOfBounds() {
//
//        list.add(1);
//
//        list.add(2);
//
//        list.add(3);
//
//        assertThrows(IndexOutOfBoundsException.class, () -> list.add(5, 4)); // Adding at an index greater than the list size
//
//
//
//        assertEquals(3, list.size());
//
//        assertEquals(1, list.get(1));
//
//        assertEquals(2, list.get(2));
//
//        assertEquals(3, list.get(3));
//
//    }
//
//
//
//    @Test
//
//    void testGetOutOfBounds() {
//
//        list.add(1);
//
//        list.add(2);
//
//        list.add(3);
//
//
//
//        assertThrows(IndexOutOfBoundsException.class, () -> list.get(4)); // Getting an element at an index greater than the list size
//
//    }
//
//
//
//    @Test
//
//    void testSetOutOfBounds() {
//
//        list.add(1);
//
//        list.add(2);
//
//        list.add(3);
//
//
//
//        assertThrows(IndexOutOfBoundsException.class, () -> list.set(4, 4)); // Setting an element at an index greater than the list size
//
//    }
//
//
//
//    @Test
//
//    void testRemoveNonexistentElement() {
//
//        list.add(1);
//
//        list.add(2);
//
//        list.add(3);
//
//        list.remove(4); // Removing an element that doesn't exist in the list
//
//
//
//        assertEquals(3, list.size());
//
//        assertEquals(1, list.get(1));
//
//        assertEquals(2, list.get(2));
//
//        assertEquals(3, list.get(3));
//
//    }
//
//
//
//    @Test
//
//    void testIsEmptyWithElements() {
//
//        list.add(1);
//
//        list.add(2);
//
//        list.add(3);
//
//
//
//        assertFalse(list.isEmpty());
//
//    }
//
//
//
//    @Test
//
//    void testIsEmptyWithoutElements() {
//
//        assertTrue(list.isEmpty());
//
//    }
//
//
//
//}
//
