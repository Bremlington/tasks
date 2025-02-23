package containers;

import collections.CustomLinkedList;
import collections.CustomList;
import org.junit.jupiter.api.Test;

public class TestDatabaseStorage {

    @Test
    void testDatabaseStorageNotLinked(){
        CustomList myList = new CustomList();
        TestStorage.testDatabaseStorage(myList, false);
    }

    @Test
    void testDatabaseStorageLinked(){
        CustomLinkedList myList = new CustomLinkedList();
        TestStorage.testDatabaseStorage(myList, true);
    }

}
