import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

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
    public void testConstructor() {
        CustomList myList = new CustomList(16);
        assertEquals(16, myList.getCapacity());

        CustomList myListDefault = new CustomList();
        assertEquals(8, myListDefault.getCapacity());
    }

    @Test
    public void testRemoveMethod() throws CustomListException {
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

        myList.removeByIndex(1);
        assertEquals(2, myList.getSize());
        assertEquals(10, myList.getByIndex(0));
        assertEquals(30, myList.getByIndex(1));
    }
}