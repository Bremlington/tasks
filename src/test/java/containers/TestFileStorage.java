package containers;

import collections.CustomLinkedList;
import collections.CustomList;
import collections.List;
import containers.database.StorageConfig;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestFileStorage {
    private final StorageType storageType = StorageType.FILE;

    @Test
    void testFileStorageList(){
        CustomList myList = new CustomList();
        testFileStorage(myList, false);

        CustomLinkedList myListLinked = new CustomLinkedList();
        testFileStorage(myListLinked, true);
    }

    void testFileStorage(List myList, boolean isLinked){
        myList.add(30);
        myList.add(10);
        myList.add(10);
        myList.add(40);

        StorageConfig storageConfig = new StorageConfig(storageType);
        StorageUnit storageUnit = new StorageUnit(storageType, storageConfig);
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

        StorageConfig incorrectConfig = new StorageConfig("///////");

        StorageUnit storageIncorrectUnit = new StorageUnit(storageType, incorrectConfig);
        StorageSaveResult saveIncorrectResult = storageIncorrectUnit.save(myList);
        assertFalse(saveIncorrectResult.success);
    }
}
