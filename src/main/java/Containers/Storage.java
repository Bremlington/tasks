package Containers;

import Collections.List;

public interface Storage {
    StorageSaveResult save(List list);
    StorageLoadResult load(String id, boolean isLinked);
}
