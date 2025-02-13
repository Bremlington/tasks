package Containers;

import Collections.List;

public class StorageLoadResult {
    public final boolean success;
    public final List list;
    public final String error;

    public StorageLoadResult(boolean success, List list, String error) {
        this.success = success;
        this.list = list;
        this.error = error;
    }
}
