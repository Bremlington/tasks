public interface CustomLists {
    int getByIndex(int index) throws ArrayIndexOutOfBoundsException;
    void removeByIndex(int index) throws ArrayIndexOutOfBoundsException;
    void removeElement(int value) throws ArrayIndexOutOfBoundsException;
    void add(int i);
    int getSize();
    
}
