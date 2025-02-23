package containers;

import collections.List;
import containers.database.DatabaseStorage;
import containers.database.StorageConfig;
import containers.file.FileStorage;

public class StorageUnit implements Storage{
    private final StorageType storageType;
    private Storage storage;

    public StorageUnit(StorageType storageType, StorageConfig storageConfig) {
        this.storageType = storageType;
        this.setStorageConfig(storageConfig);
    }

    public void setStorageConfig(StorageConfig storageConfig) {
        switch (storageType) {
            case FILE ->
                storage = new FileStorage(storageConfig);

            case DATABASE ->
                storage = new DatabaseStorage(storageConfig);
        }
    }

    @Override
    public StorageSaveResult save(List list) {
        return storage.save(list);
    }

    @Override
    public StorageLoadResult load(String id, boolean isLinked) {
        return storage.load(id, isLinked);
    }
}
