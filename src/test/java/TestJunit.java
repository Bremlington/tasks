import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestJunit {

    @Test
    public void testAddMethod() {
        CustomList myList = new CustomList(16);
        myList.add(10);
        assertEquals(1, myList.getSize());
        myList.add(10);
        assertEquals(2, myList.getSize());
        myList.add(10);
        assertEquals(3, myList.getSize());
    }

    @Test
    public void testAddMethodLinked() {
        CustomLinkedList myList = new CustomLinkedList();
        myList.add(10);
        assertEquals(1, myList.getSize());
        myList.add(10);
        assertEquals(2, myList.getSize());
        myList.add(10);
        assertEquals(3, myList.getSize());
    }

    @Test
    public void testCapacity() {
        CustomList myList = new CustomList(16);
        assertEquals(16, myList.getCapacity());

        CustomList myListDefault = new CustomList();
        assertEquals(8, myListDefault.getCapacity());
    }

    @Test
    public void testRemoveElementMethod() throws ArrayIndexOutOfBoundsException {
        CustomList myList = new CustomList();
        myList.add(10);
        myList.add(10);
        myList.add(20);
        myList.add(20);
        myList.add(30);

        myList.removeElement(20);
        assertEquals(3, myList.getSize());
        assertEquals(10, myList.getByIndex(0));
        assertEquals(10, myList.getByIndex(1));
        assertEquals(30, myList.getByIndex(2));
    }

    @Test
    public void testRemoveElementMethodLinked() throws ArrayIndexOutOfBoundsException {
        CustomLinkedList myList = new CustomLinkedList();
        myList.add(10);
        myList.add(10);
        myList.add(20);
        myList.add(20);
        myList.add(30);

        myList.removeElement(20);
        assertEquals(3, myList.getSize());
        assertEquals(10, myList.getByIndex(0));
        assertEquals(10, myList.getByIndex(1));
        assertEquals(30, myList.getByIndex(2));
    }

    @Test
    public void testRemoveByIndexMethod() throws ArrayIndexOutOfBoundsException {
        CustomList myList = new CustomList();
        myList.add(10);
        myList.add(20);
        myList.add(30);

        myList.removeByIndex(1);
        assertEquals(2, myList.getSize());
        assertEquals(10, myList.getByIndex(0));
        assertEquals(30, myList.getByIndex(1));
    }

    @Test
    public void testRemoveByIndexMethodLinked() throws ArrayIndexOutOfBoundsException {
        CustomLinkedList myList = new CustomLinkedList();
        myList.add(10);
        myList.add(20);
        myList.add(30);

        myList.removeByIndex(1);
        assertEquals(2, myList.getSize());
        assertEquals(10, myList.getByIndex(0));
        assertEquals(30, myList.getByIndex(1));
    }

    @Test
    public void testGetByIndex() throws ArrayIndexOutOfBoundsException {
        CustomList myList = new CustomList();
        myList.add(10);
        myList.add(20);
        myList.add(30);

        assertEquals(10, myList.getByIndex(0));
        assertEquals(20, myList.getByIndex(1));
        assertEquals(30, myList.getByIndex(2));
    }

    @Test
    public void testGetByIndexLinked() throws ArrayIndexOutOfBoundsException {
        CustomLinkedList myList = new CustomLinkedList();
        myList.add(10);
        myList.add(20);
        myList.add(30);

        assertEquals(10, myList.getByIndex(0));
        assertEquals(20, myList.getByIndex(1));
        assertEquals(30, myList.getByIndex(2));
    }

    @Test void testToString(){
        CustomList myList = new CustomList(4);
        myList.add(10);
        myList.add(20);
        myList.add(30);

        String result = "CustomList{array=[10, 20, 30, 0], size=3, capacity=4}";
        assertEquals(result, myList.toString());
    }

    @Test void testSize(){
        CustomList myList = new CustomList();
        myList.add(10);
        myList.add(20);
        myList.add(30);

        assertTrue(myList.getSize() == 3);
    }
}