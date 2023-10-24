import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ArrayListTest {
    private ArrayList arrayList;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    @BeforeEach
    public void setUp() {
        arrayList = new ArrayList(5);
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testAddAndGet() {
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);

        Assertions.assertEquals(10, arrayList.get(0));
        Assertions.assertEquals(20, arrayList.get(1));
        Assertions.assertEquals(30, arrayList.get(2));
    }

    @Test
    public void testAddAtIndex() {
        arrayList.add(0, 10);
        arrayList.add(1, 20);
        arrayList.add(2, 30);

        Assertions.assertEquals(10, arrayList.get(0));
        Assertions.assertEquals(20, arrayList.get(1));
        Assertions.assertEquals(30, arrayList.get(2));
    }

    @Test
    public void testAddThrowsExceptionWhenFull() {
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(40);
        arrayList.add(50);

        Assertions.assertThrows(RuntimeException.class, () -> arrayList.add(60));
    }

    @Test
    public void testAddAtIndexThrowsExceptionWhenOutOfBounds() {
        arrayList.add(10);
        arrayList.add(20);

        Assertions.assertThrows(RuntimeException.class, () -> arrayList.add(3, 30));
    }

    @Test
    public void testGetThrowsExceptionWhenIndexNotFound() {
        arrayList.add(10);
        arrayList.add(20);

        Assertions.assertThrows(RuntimeException.class, () -> arrayList.get(2));
    }

    @Test
    public void testSetThrowsExceptionWhenIndexNotFound() {
        arrayList.add(10);
        arrayList.add(20);

        Assertions.assertThrows(RuntimeException.class, () -> arrayList.set(2, 30));
    }

    @Test
    public void testRemove() {
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);

        arrayList.remove(20);

        Assertions.assertEquals(2, arrayList.size());
        Assertions.assertEquals(10, arrayList.get(0));
        Assertions.assertEquals(30, arrayList.get(1));
    }

    @Test
    public void testIndexOf() {
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);

        Assertions.assertEquals(0, arrayList.indexOf(10));
        Assertions.assertEquals(1, arrayList.indexOf(20));
        Assertions.assertEquals(2, arrayList.indexOf(30));
        Assertions.assertEquals(-1, arrayList.indexOf(40));
    }

    @Test
    public void testSize() {
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);

        Assertions.assertEquals(3, arrayList.size());
    }

    @Test
    public void testMaxSize() {
        arrayList = new ArrayList(10);

        Assertions.assertEquals(10, arrayList.max_size());
    }

    @Test
    public void testIsEmpty() {
        Assertions.assertTrue(arrayList.isEmpty());

        arrayList.add(10);

        Assertions.assertFalse(arrayList.isEmpty());
    }

    @Test
    public void testIsFull() {
        arrayList = new ArrayList(2);

        arrayList.add(10);
        arrayList.add(20);

        Assertions.assertTrue(arrayList.isFull());

        arrayList.remove(10);

        Assertions.assertFalse(arrayList.isFull());
    }

    @Test
    public void testShow() {
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);

        arrayList.show();

        String expectedOutput = "[ 0=>10, 1=>20, 2=>30, 3=>0, 4=>0 ]";
        Assertions.assertEquals(expectedOutput, outputStream.toString().trim());
    }

    @Test
    public void testAddAndGetWithLargeSize() {
        arrayList = new ArrayList(1000);

        for (int i = 0; i < 1000; i++) {
            arrayList.add(i);
        }
        for (int i = 0; i < 1000; i++) {
            Assertions.assertEquals(i, arrayList.get(i));
        }
    }

    @Test
    public void testSetThrowsExceptionWhenIndexOutOfBounds() {
        arrayList.add(10);
        arrayList.add(20);

        Assertions.assertThrows(RuntimeException.class, () -> arrayList.set(3, 30));
    }

    @Test
    public void testRemoveThrowsExceptionWhenElementNotFound() {
        arrayList.add(10);
        arrayList.add(20);

        Assertions.assertThrows(RuntimeException.class, () -> arrayList.remove(30));
    }

    @Test
    public void testSizeWithEmptyArrayList() {
        Assertions.assertEquals(0, arrayList.size());
    }

    @Test
    public void testMaxSizeWithLargeSize() {
        arrayList = new ArrayList(1000);

        Assertions.assertEquals(1000, arrayList.max_size());
    }

    @Test
    public void testIsEmptyWithEmptyArrayList() {
        Assertions.assertTrue(arrayList.isEmpty());
    }

    @Test
    public void testIsFullWithFullArrayList() {
        arrayList = new ArrayList(2);
        arrayList.add(10);
        arrayList.add(20);

        Assertions.assertTrue(arrayList.isFull());
    }
}
