public class CustomListElement {
    private CustomListElement next;
    private CustomListElement previous;
    private final int value;

    CustomListElement(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public CustomListElement getPrevious() {
        return previous;
    }

    public void setPrevious(CustomListElement previous) {
        this.previous = previous;
    }

    public CustomListElement getNext() {
        return next;
    }

    public void setNext(CustomListElement next) {
        this.next = next;
    }
}
