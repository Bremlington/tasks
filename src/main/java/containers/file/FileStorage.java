package containers.file;

import collections.List;
import containers.database.StorageConfig;
import containers.Storage;
import containers.StorageLoadResult;
import containers.StorageSaveResult;
import utilites.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.UUID;

public class FileStorage implements Storage {
    private final Logger logger = LoggerFactory.getLogger(Logger.class);
    private final Serializer serializer = new Serializer();
    private final StorageConfig config;

    public FileStorage(StorageConfig config) {
        this.config = config;
    }

    private String getFullPathToFileById(String id){
        return config.getPathToSavedFiles() + id +".txt";
    }

    @Override
    public StorageSaveResult save(List list) {
        UUID uuid = UUID.randomUUID();
        String fullPathToFile = getFullPathToFileById(uuid.toString());

        try {
            String dataList = serializer.serialize(list);

            BufferedWriter writer = new BufferedWriter(new FileWriter(fullPathToFile));
            writer.write(dataList);
            writer.close();
            return new StorageSaveResult(true, uuid.toString(), "");
        } catch (IOException e) {
            String errorMessage = "Error saving to file: "+e;
            logger.error(errorMessage);
            return new StorageSaveResult(false, "", errorMessage);
        }
    }

    @Override
    public StorageLoadResult load(String id, boolean isLinked) {
        String fullPathToFile = getFullPathToFileById(id);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fullPathToFile));
            String currentLine = reader.readLine();
            reader.close();

            return new StorageLoadResult(true, serializer.deserialize(currentLine, isLinked), "");
        } catch (IOException e) {
            String errorMessage = "Error loading from file: "+e;
            logger.error(errorMessage);
            return new StorageLoadResult(false, null, errorMessage);
        }
    }
}
