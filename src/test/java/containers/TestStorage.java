package containers;

import collections.List;
import containers.database.StorageConfig;

import static containers.StorageType.FILE;
import static org.junit.jupiter.api.Assertions.*;

public class TestStorage {

    static void testStorage(List myList, boolean isLinked, StorageType storageType){
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

        StorageConfig incorrectConfig;
        switch (storageType) {
            case FILE ->
                incorrectConfig = new StorageConfig("///////");

            case DATABASE ->
                incorrectConfig = new StorageConfig("incorrect", "incorrect", "incorrect", 0, "incorrect", "incorrect");

            default -> {
                return;
            }
        }

        StorageUnit storageIncorrectUnit = new StorageUnit(storageType, incorrectConfig);
        StorageSaveResult saveIncorrectResult = storageIncorrectUnit.save(myList);
        assertFalse(saveIncorrectResult.success);
    }

    static void testFileStorage(List myList, boolean isLinked){
        testStorage(myList, isLinked, FILE);
    }

    static void testDatabaseStorage(List myList, boolean isLinked){
        testStorage(myList, isLinked, StorageType.DATABASE);
    }

}
