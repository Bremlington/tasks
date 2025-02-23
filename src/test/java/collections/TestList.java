package collections;

import static org.junit.jupiter.api.Assertions.*;

public class TestList {
    public static void testAdd(List myList){
        myList.add(10);
        assertEquals(1, myList.getSize());
        myList.add(10);
        assertEquals(2, myList.getSize());
        myList.add(10);
        assertEquals(3, myList.getSize());
    }

    public static void testRemoveElement(List myList){
        myList.add(10);
        myList.add(20);
        myList.add(30);
        myList.add(30);
        myList.add(50);

        assertFalse(myList.removeElement(300));
        assertTrue(myList.removeElement(30));

        assertEquals(3, myList.getSize());
        assertEquals(10, myList.getByIndex(0));
        assertEquals(20, myList.getByIndex(1));
        assertEquals(50, myList.getByIndex(2));
    }

    public static void testRemoveByIndex(List myList){
        myList.add(10);
        myList.add(20);
        myList.add(30);

        assertTrue(myList.removeByIndex(1));
        assertEquals(2, myList.getSize());
        assertEquals(10, myList.getByIndex(0));
        assertEquals(30, myList.getByIndex(1));

        assertFalse(myList.removeByIndex(100));
    }

    public static void testGetByIndex(List myList) throws RuntimeException {
        myList.add(10);
        myList.add(20);
        myList.add(30);

        assertEquals(10, myList.getByIndex(0));
        assertEquals(20, myList.getByIndex(1));
        assertEquals(30, myList.getByIndex(2));
    }

    public static void testGetSize(List myList){
        myList.add(10);
        myList.add(20);
        myList.add(30);

        assertEquals(myList.getSize(), 3);
    }

}
