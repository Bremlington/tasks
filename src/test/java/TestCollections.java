import Collections.CustomLinkedList;
import Collections.CustomList;
import Collections.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCollections {

    public void testAddMethod(List myList){
        myList.add(10);
        assertEquals(1, myList.getSize());
        myList.add(10);
        assertEquals(2, myList.getSize());
        myList.add(10);
        assertEquals(3, myList.getSize());
    }

    @Test
    public void testAddMethodNotLinked() {
        CustomList myList = new CustomList(16);
        testAddMethod(myList);
    }

    @Test
    public void testAddMethodLinked() {
        CustomLinkedList myList = new CustomLinkedList();
        testAddMethod(myList);
    }

    @Test
    public void testCapacity() {
        CustomList myList = new CustomList(16);
        assertEquals(16, myList.getCapacity());

        CustomList myListDefault = new CustomList();
        assertEquals(8, myListDefault.getCapacity());
    }

    public void testRemoveElement(List myList){
        myList.add(10);
        myList.add(20);
        myList.add(30);
        myList.add(30);
        myList.add(50);

        assertTrue(myList.removeElement(30));
        assertEquals(3, myList.getSize());
        assertEquals(10, myList.getByIndex(0));
        assertEquals(20, myList.getByIndex(1));
        assertEquals(50, myList.getByIndex(2));
    }

    @Test
    public void testRemoveElementMethodNotLinked(){
        CustomList myList = new CustomList();
        testRemoveElement(myList);
    }

    @Test
    public void testRemoveElementMethodLinked() {
        CustomLinkedList myList = new CustomLinkedList();
        testRemoveElement(myList);
    }

    public void testRemoveByIndexMethod(List myList){
        myList.add(10);
        myList.add(20);
        myList.add(30);

        assertTrue(myList.removeByIndex(1));
        assertEquals(2, myList.getSize());
        assertEquals(10, myList.getByIndex(0));
        assertEquals(30, myList.getByIndex(1));
    }

    @Test
    public void testRemoveByIndexMethodNotLinked() {
        CustomList myList = new CustomList();
        testRemoveByIndexMethod(myList);
    }

    @Test
    public void testRemoveByIndexMethodLinked() {
        CustomLinkedList myList = new CustomLinkedList();
        testRemoveByIndexMethod(myList);
    }

    public void testGetByIndex(List myList) throws RuntimeException {
        myList.add(10);
        myList.add(20);
        myList.add(30);

        assertEquals(10, myList.getByIndex(0));
        assertEquals(20, myList.getByIndex(1));
        assertEquals(30, myList.getByIndex(2));
    }

    @Test
    public void testGetByIndexNotLinked() throws RuntimeException {
        CustomList myList = new CustomList();
        testGetByIndex(myList);
    }

    @Test
    public void testGetByIndexLinked() throws RuntimeException {
        CustomLinkedList myList = new CustomLinkedList();
        testGetByIndex(myList);
    }

    public void testGetSize(List myList){
        myList.add(10);
        myList.add(20);
        myList.add(30);

        assertEquals(myList.getSize(), 3);
    }

    @Test
    void testSizeNotLinked(){
        CustomList myList = new CustomList();
        testGetSize(myList);
    }

    @Test
    void testSizeLinked(){
        CustomLinkedList myList = new CustomLinkedList();
        testGetSize(myList);
    }

}