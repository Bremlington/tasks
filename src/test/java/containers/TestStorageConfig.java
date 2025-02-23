package containers;

import containers.database.StorageConfig;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStorageConfig {
    @Test
    void testConfigFiles(){
        StorageConfig config = new StorageConfig("\files\save");
        assertEquals("\files\save", config.getPathToSavedFiles());
    }

    @Test
    void testConfigDatabase(){
        StorageConfig config = new StorageConfig("user", "password", "host.com", 8080, "database", "UTC");
        assertEquals("jdbc:mysql://host.com:8080/database?serverTimezone=UTC", config.getConnectionUrl());
    }
}
