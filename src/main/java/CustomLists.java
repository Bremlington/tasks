public interface CustomLists {
    int getByIndex(int index) throws RuntimeException;
    boolean removeByIndex(int index);
    boolean removeElement(int value);
    void add(int i);
    void clear();
    int getSize();

    String fileName = "listData.txt";
    boolean saveToFile();
    boolean readFromFile();
}
