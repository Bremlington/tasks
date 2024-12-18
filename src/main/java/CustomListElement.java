public class CustomListElement {
    private CustomListElement next;
    private CustomListElement previous;
    private final int value;
    private final boolean isEmpty;

    CustomListElement(int value){
        this.value = value;
        this.isEmpty = false;
        this.next = new CustomListElement();
        this.previous = new CustomListElement();
    }

    CustomListElement(){
        this.value = 0;
        this.isEmpty = true;
        this.next = this;
        this.previous = this;
    }

    public boolean isEmpty() {
        return isEmpty;
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
