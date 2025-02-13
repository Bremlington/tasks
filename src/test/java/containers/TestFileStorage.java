package containers;

import collections.CustomLinkedList;
import collections.CustomList;
import org.junit.jupiter.api.Test;

public class TestFileStorage {
    @Test
    void testFileStorageNotLinked(){
        CustomList myList = new CustomList();
        TestStorage.testFileStorage(myList, false);
    }

    @Test
    void testFileStorageLinked(){
        CustomLinkedList myList = new CustomLinkedList();
        TestStorage.testFileStorage(myList, true);
    }

}
