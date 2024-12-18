public interface List {
    int getByIndex(int index) throws RuntimeException;
    boolean removeByIndex(int index);
    boolean removeElement(int value);
    void add(int i);
    int getSize();
}
