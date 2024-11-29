public class Main {
    public static void main(String[] args) {
        CustomList myList = new CustomList(2);

        myList.add(10);
        myList.add(20);
        myList.add(30);
        myList.add(40);
        myList.add(40);

        myList.printElements();
        System.out.println(myList.size());

        myList.removeByIndex(0);
        myList.removeByIndex(1);
        myList.printElements();
        System.out.println(myList.size());

        myList.add(60);
        myList.printElements();
        System.out.println(myList.size());

        myList.removeElement(20);
        myList.printElements();
        System.out.println(myList.size());

        myList.removeElement(40);
        myList.printElements();
        System.out.println(myList.size());

        myList.removeElement(60);
        myList.printElements();
        System.out.println(myList.size());
    }
}