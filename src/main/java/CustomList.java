import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Arrays;
import java.util.regex.Pattern;

public class CustomList implements CustomLists{
    private int[] array;
    private int size;
    private int capacity;
    private final Logger logger = LoggerFactory.getLogger(Logger.class);
    private static final int DEFAULT_CAPACITY = 8;

    @Override
    public String toString() {
        int[] arrayToString = Arrays.copyOf(array, size);
        return Arrays.toString(arrayToString);
    }

    public CustomList(int capacity) {
        array = new int[capacity];
        this.capacity = capacity;
    }

    public CustomList() {
        capacity = DEFAULT_CAPACITY;
        array = new int[capacity];
    }

    public int getByIndex(int index) throws RuntimeException{
        if(index < size){
            return array[index];
        } else {
            throw new RuntimeException("Index is out of range");
        }
    }

    public boolean removeByIndex(int index) {
        if(index > size - 1){
            logger.error("Index is out of list size");
            return false;
        }
        if(index < size - 1){
            System.arraycopy(array,index+1, array, index, size-index-1);
        }
        this.size--;

        return true;
    }

    public boolean removeElement(int value) {
        int[] foundIndexes= new int[size];
        int count = 0;
        for(int i=0; i<size; i++){
            if(array[i] == value){
                foundIndexes[count] = i;
                count++;
            }
        }

        for(int i=0; i<count; i++){
            boolean result = this.removeByIndex(foundIndexes[i]-i);
            if(!result){
                return false;
            }
        }

        return true;
    }

    public int getSize(){
        return this.size;
    }

    @Override
    public boolean saveToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileName));
            writer.write(this.toString());
            writer.close();
            return true;
        } catch (IOException e) {
            logger.error("Error saving to: "+e);
            return false;
        }
    }

    @Override
    public boolean readFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.fileName));
            String currentLine = reader.readLine();
            reader.close();

            currentLine = currentLine.replace("[", "");
            currentLine = currentLine.replace("]", "");
            currentLine = currentLine.replace(" ", "");

            Pattern pattern = Pattern.compile(",");
            String[] strings = pattern.split(currentLine);

            this.clear();
            for(int i=0; i < strings.length; i++){
                this.add(Integer.parseInt(strings[i]));
            }

            return true;
        } catch (IOException e) {
            logger.error("Error loading from: "+e);
            return false;
        }
    }

    public int getCapacity() {return this.capacity;}

    public void add(int i){
        size++;
        if(size == capacity){
            capacity = capacity * 2;
            int[] newArray = new int[capacity];
            System.arraycopy(array,0, newArray, 0, size-1);
            array = newArray;
        }
        array[size-1] = i;
    }

    @Override
    public void clear() {
        capacity = 1; //minimum
        size = 0;
        array = new int[capacity];
    }

}
