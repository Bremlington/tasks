public class Main {
    public static void main(String[] args) {
        CustomList myList = new CustomList();
        myList.add(10);
        System.out.println(myList.size());

        myList.printElements();

        myList.add(20);
        System.out.println(myList.size());

        myList.printElements();
    }
}