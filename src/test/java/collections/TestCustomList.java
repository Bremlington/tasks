package collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCustomList {
    @Test
    public void testAdd() {
        CustomList myList = new CustomList(2);
        TestList.testAdd(myList);
    }

    @Test
    public void testGetCapacity() {
        CustomList myList = new CustomList(16);
        assertEquals(16, myList.getCapacity());

        CustomList myListDefault = new CustomList();
        assertEquals(8, myListDefault.getCapacity());
    }

    @Test
    public void testRemoveElement(){
        CustomList myList = new CustomList();
        TestList.testRemoveElement(myList);
    }
    @Test
    public void testRemoveByIndex() {
        CustomList myList = new CustomList();
        TestList.testRemoveByIndex(myList);
    }

    @Test
    public void testGetByIndex() throws RuntimeException {
        CustomList myList = new CustomList();
        TestList.testGetByIndex(myList);
    }

    @Test
    void testGetSize(){
        CustomList myList = new CustomList();
        TestList.testGetSize(myList);
    }

}
