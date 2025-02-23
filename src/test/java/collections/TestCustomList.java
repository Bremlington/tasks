package collections;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCustomList {

    private CustomList myList;

    @Before
    public void setUp(){
        myList = new CustomList();
        myList.add(10);
        myList.add(20);
        myList.add(30);
        myList.add(30);
        myList.add(50);
    }

    @Test
    public void testAdd() {
        myList.add(10);
        assertEquals(6, myList.getSize());
        myList.add(10);
        assertEquals(7, myList.getSize());
        myList.add(10);
        assertEquals(8, myList.getSize());
    }

    @Test
    public void testGetCapacity() {
        CustomList myListCapacity = new CustomList(16);
        assertEquals(16, myListCapacity.getCapacity());

        CustomList myListDefault = new CustomList();
        assertEquals(8, myListDefault.getCapacity());
    }

    @Test
    public void testRemoveElement(){
        assertFalse(myList.removeElement(300));
        assertTrue(myList.removeElement(30));

        assertEquals(3, myList.getSize());
        assertEquals(10, myList.getByIndex(0));
        assertEquals(20, myList.getByIndex(1));
        assertEquals(50, myList.getByIndex(2));
    }
    @Test
    public void testRemoveByIndex() {
        assertTrue(myList.removeByIndex(1));
        assertEquals(4, myList.getSize());
        assertEquals(10, myList.getByIndex(0));
        assertEquals(30, myList.getByIndex(1));

        assertFalse(myList.removeByIndex(100));
    }

    @Test
    public void testGetByIndex() throws RuntimeException {
        assertEquals(10, myList.getByIndex(0));
        assertEquals(20, myList.getByIndex(1));
        assertEquals(30, myList.getByIndex(2));
    }

    @Test
    public void testGetSize(){
        assertEquals(myList.getSize(), 5);
    }

}
