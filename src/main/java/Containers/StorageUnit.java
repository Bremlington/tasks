package Containers;

import Collections.List;
import Containers.Database.DatabaseStorage;
import Containers.Database.StorageConfig;
import Containers.File.FileStorage;

public class StorageUnit implements Storage{
    private StorageType storageType;
    private StorageConfig storageConfig;

    public StorageUnit(StorageType storageType) {
        this.storageType = storageType;
        this.storageConfig = new StorageConfig(storageType);
    }

    public void setStorageConfig(StorageConfig storageConfig) {
        this.storageConfig = storageConfig;
    }

    public void setStorageType(StorageType storageType) {
        this.storageType = storageType;
        this.storageConfig = new StorageConfig(storageType);
    }

    @Override
    public StorageSaveResult save(List list) {
        switch (storageType) {
            case FILE -> {
                FileStorage fileStorage = new FileStorage(storageConfig);
                return fileStorage.save(list);
            }
            case DATABASE -> {
                DatabaseStorage databaseStorage = new DatabaseStorage(storageConfig);
                return databaseStorage.save(list);
            }
        }

        return new StorageSaveResult(false, "", "No such storage type processing");
    }

    @Override
    public StorageLoadResult load(String id, boolean isLinked) {
        switch (storageType) {
            case FILE -> {
                FileStorage fileStorage = new FileStorage(storageConfig);
                return fileStorage.load(id, isLinked);
            }
            case DATABASE -> {
                DatabaseStorage databaseStorage = new DatabaseStorage(storageConfig);
                return databaseStorage.load(id, isLinked);
            }
        }

        return new StorageLoadResult(false, null, "No such storage type processing");
    }
}
