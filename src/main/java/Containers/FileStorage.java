package Containers;

import Collections.List;
import Utilites.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.UUID;

public class FileStorage implements Storage {
    private final Logger logger = LoggerFactory.getLogger(Logger.class);
    private String pathToSavedFiles;

    public void setPathToSavedFiles(String pathToSavedFiles) {
        this.pathToSavedFiles = pathToSavedFiles;
    }

    private String getFullPathToFileById(String id){
        return this.pathToSavedFiles + id +".txt";
    }

    private boolean saveToFile(String fullPathToFile, List list){
        try {
            Serializer serializer = new Serializer();
            String dataList = serializer.SerializeList(list);

            BufferedWriter writer = new BufferedWriter(new FileWriter(fullPathToFile));
            writer.write(dataList);
            writer.close();
            return true;
        } catch (IOException e) {
            logger.error("Error saving to file: "+e);
            return false;
        }
    }

    @Override
    public String save(List list) {
        UUID uuid = UUID.randomUUID();
        String fullPathToFile = getFullPathToFileById(uuid.toString());
        boolean saveResult = saveToFile(fullPathToFile, list);
        if(saveResult){
            return uuid.toString();
        }

        return "";
    }

    private String loadFromFile(String fullPathToFile) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fullPathToFile));
            String currentLine = reader.readLine();
            reader.close();

            return currentLine;
        } catch (IOException e) {
            logger.error("Error loading from file: "+e);
            return "";
        }
    }

    @Override
    public List load(String id, boolean isLinked) {
        String fullPathToFile = getFullPathToFileById(id);
        String loadResult = loadFromFile(fullPathToFile);

        Serializer serializer = new Serializer();
        if(isLinked){
            return serializer.DeserializeAsCustomLinkedList(loadResult);
        } else {
            return serializer.DeserializeAsCustomList(loadResult);
        }
    }
}
