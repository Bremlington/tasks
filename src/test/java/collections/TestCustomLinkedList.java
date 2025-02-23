package collections;

import org.junit.jupiter.api.Test;

public class TestCustomLinkedList {
    @Test
    public void testAdd() {
        CustomLinkedList myList = new CustomLinkedList();
        TestList.testAdd(myList);
    }

    @Test
    public void testRemoveElement() {
        CustomLinkedList myList = new CustomLinkedList();
        TestList.testRemoveElement(myList);
    }

    @Test
    public void testRemoveByIndex() {
        CustomLinkedList myList = new CustomLinkedList();
        TestList.testRemoveByIndex(myList);
    }

    @Test
    public void testGetByIndex() throws RuntimeException {
        CustomLinkedList myList = new CustomLinkedList();
        TestList.testGetByIndex(myList);
    }

    @Test
    void testSize(){
        CustomLinkedList myList = new CustomLinkedList();
        TestList.testGetSize(myList);
    }
}
