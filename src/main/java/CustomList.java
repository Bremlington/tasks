public class CustomList {
    private int array[];
    private int size;

    public CustomList() {
        array = new int[size];
    }

    public int size(){
        return array.length;
    }

    public void add(int i){
        size++;

        int[] tempArray = new int[size];
        for(int j=0;j<size-1;j++){
            tempArray[j] = array[j];
        }
        tempArray[size-1] = i;
        array = tempArray;
    }

    public void printElements(){
        for(int j=0;j<size;j++){
            System.out.println(array[j]);
        }
    }
}
