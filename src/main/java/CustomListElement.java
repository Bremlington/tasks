public class CustomListElement {
    private CustomListElement next;
    private CustomListElement previous;
    private int value;

    CustomListElement(int value){
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
