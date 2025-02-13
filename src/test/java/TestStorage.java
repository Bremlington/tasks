import Collections.CustomLinkedList;
import Collections.CustomList;
import Collections.List;
import Containers.StorageLoadResult;
import Containers.StorageSaveResult;
import Containers.StorageType;
import Containers.StorageUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestStorage {

    @Test
    void testFileStorageNotLinked(){
        CustomList myList = new CustomList();
        testFileStorage(myList, false);
    }

    @Test
    void testFileStorageLinked(){
        CustomLinkedList myList = new CustomLinkedList();
        testFileStorage(myList, true);
    }

    @Test
    void testDatabaseStorageNotLinked(){
        CustomList myList = new CustomList();
        testDatabaseStorage(myList, false);
    }

    @Test
    void testDatabaseStorageLinked(){
        CustomLinkedList myList = new CustomLinkedList();
        testDatabaseStorage(myList, true);
    }

    void testStorage(List myList, boolean isLinked, StorageType storageType){
        myList.add(30);
        myList.add(10);
        myList.add(10);
        myList.add(40);

        StorageUnit storageUnit = new StorageUnit(storageType);
        StorageSaveResult saveResult = storageUnit.save(myList);
        assertTrue(saveResult.success);
        assertNotEquals(saveResult.id, "");

        StorageLoadResult loadResult = storageUnit.load(saveResult.id, isLinked);
        List newList = loadResult.list;
        assertEquals(4, newList.getSize());
        assertEquals(30, newList.getByIndex(0));
        assertEquals(10, newList.getByIndex(1));
        assertEquals(10, newList.getByIndex(2));
        assertEquals(40, newList.getByIndex(3));
    }

    void testFileStorage(List myList, boolean isLinked){
        testStorage(myList, isLinked, StorageType.FILE);
    }

    void testDatabaseStorage(List myList, boolean isLinked){
        testStorage(myList, isLinked, StorageType.DATABASE);
    }
}
