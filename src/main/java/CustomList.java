public class CustomList {
    private int[] array;

    private int size;
    private int capacity;

    private static final int DEFAULT_CAPACITY = 8;
    public CustomList(int capacity) {
        if(capacity == 0){
            capacity = DEFAULT_CAPACITY;
        }
        array = new int[capacity];
        this.capacity = capacity;
    }

    public void removeByIndex(int index){
        if(index > size - 1){
            return;
        }
        if(index < size - 1){
            System.arraycopy(array,index+1, array, index, size-index-1);
        }
        this.size--;
    }

    public void removeElement(int element){
        int[] foundIndexes= new int[size];
        int count = 0;
        for(int i=0; i<size; i++){
            if(array[i] == element){
                foundIndexes[count] = i;
                count++;
            }
        }

        for(int i=0; i<count; i++){
            this.removeByIndex(foundIndexes[i]-i);
        }
    }

    public int size(){
        return this.size;
    }

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

    public void printElements(){
        for(int i=0;i<size;i++){
            System.out.print(array[i]+" ");
        }
    }
}
