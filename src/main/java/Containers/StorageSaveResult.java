package Containers;

public class StorageSaveResult {
    public final boolean success;
    public final String id;
    public final String error;

    public StorageSaveResult(boolean success, String id, String error) {
        this.success = success;
        this.id = id;
        this.error = error;
    }
}
