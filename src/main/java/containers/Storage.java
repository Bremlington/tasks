package containers;

import collections.List;

public interface Storage {
    StorageSaveResult save(List list);
    StorageLoadResult load(String id, boolean isLinked);
}
